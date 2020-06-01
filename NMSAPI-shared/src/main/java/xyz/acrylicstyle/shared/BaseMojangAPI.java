package xyz.acrylicstyle.shared;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import util.CollectionList;
import util.JSONAPI;
import util.promise.Promise;

import java.util.Objects;
import java.util.UUID;

public class BaseMojangAPI {
    /**
     * Calls mojang API and lookups player uuid from name.<br />
     * Throws RuntimeException when rate limit exceeded.
     * @param name Name of the player.
     * @return Player's uuid.
     */
    public static UUID getUniqueId(@NotNull String name) {
        Player player = Bukkit.getPlayer(name);
        if (player != null) return player.getUniqueId();
        JSONAPI.Response response = new JSONAPI("https://api.mojang.com/users/profiles/minecraft/" + name).call(JSONObject.class);
        if (response.getResponseCode() != 200) return null;
        JSONObject json = (JSONObject) response.getResponse();
        return UUID.fromString(json.getString("id").replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
    }

    /**
     * Calls mojang API and lookups player uuid from name.
     * @param name Name of the player.
     * @return Player's uuid.
     */
    public static Promise<UUID> getUniqueIdAsync(@NotNull String name) {
        return new Promise<UUID>() {
            @Override
            public UUID apply(Object o) {
                return getUniqueId(name);
            }
        };
    }

    /**
     * Calls mojang API and lookups player name from uuid.<br />
     * Throws RuntimeException when rate limit exceeded.
     * @param uuid Name of the player.
     * @return Name histories
     */
    public static CollectionList<NameHistory> getNameChanges(@NotNull UUID uuid) {
        JSONAPI.Response response = new JSONAPI("https://api.mojang.com/user/profiles/" + uuid.toString().replaceAll("-", "") + "/names").call();
        if (response.getResponseCode() != 200) return null;
        JSONArray json = new JSONArray(response.getRawResponse());
        CollectionList<NameHistory> histories = new CollectionList<>();
        json.forEach(o -> {
            JSONObject obj = (JSONObject) o;
            String name = obj.getString("name");
            Long changedToAt = obj.has("changedToAt") ? obj.getLong("changedToAt") : null;
            histories.add(new NameHistory(name, changedToAt));
        });
        return histories;
    }

    public static String getName(@NotNull UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if (player != null && player.getName() != null) return player.getName();
        CollectionList<NameHistory> a = getNameChanges(uuid);
        if (a == null) return null;
        return Objects.requireNonNull(a.last()).getName();
    }

    public static PlayerProfile getPlayerProfile(@NotNull UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        String name = player == null ? Objects.requireNonNull(getName(uuid)) : player.getName();
        return new PlayerProfile(name, uuid);
    }

    public static PlayerProfile getPlayerProfile(@NotNull String name) {
        Player player = Bukkit.getPlayer(name);
        if (player != null) return new PlayerProfile(player.getName(), player.getUniqueId());
        JSONAPI.Response response = new JSONAPI("https://api.mojang.com/users/profiles/minecraft/" + name).call(JSONObject.class);
        if (response.getResponseCode() != 200) return null;
        JSONObject json = (JSONObject) response.getResponse();
        return new PlayerProfile(json.getString("name"), json.getString("id"));
    }


    @NotNull
    public static String getSkin(@NotNull UUID uuid) {
        return (String) getProperty(uuid, "value");
    }

    @NotNull
    public static String getSkinSignature(@NotNull UUID uuid) {
        return (String) getProperty(uuid, "signature");
    }

    @NotNull
    public static JSONObject getProperty(@NotNull UUID uuid) {
        JSONAPI.Response response = new JSONAPI(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", uuid.toString().replaceAll("-", ""))).call(JSONObject.class);
        if (response.getResponseCode() != 200) throw new RuntimeException("Response code isn't 200! (" + response.getResponseCode() + ")");
        JSONObject json = (JSONObject) response.getResponse();
        JSONArray properties = json.getJSONArray("properties");
        return (JSONObject) properties.get(0);
    }

    @NotNull
    public static Object getProperty(@NotNull UUID uuid, @NotNull String s) {
        return getProperty(uuid).getString(s);
    }
}
