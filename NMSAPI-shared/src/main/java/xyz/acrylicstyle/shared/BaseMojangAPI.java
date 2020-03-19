package xyz.acrylicstyle.shared;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import util.JSONAPI;

import java.util.UUID;

public class BaseMojangAPI {
    /**
     * Calls mojang API and lookups player uuid from name.<br />
     * Throws RuntimeException when rate limit exceeded.
     * @param name Name of the player.
     * @return Player's uuid.
     */
    @NotNull
    public static UUID getUniqueId(@NotNull String name) {
        JSONAPI.Response response = new JSONAPI("https://api.mojang.com/users/profiles/minecraft/" + name).call();
        if (response.getResponseCode() != 200) throw new RuntimeException("Response code isn't 200! (" + response.getResponseCode() + ")");
        JSONObject json = response.getResponse();
        return UUID.fromString(json.getString("id").replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
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
        JSONAPI.Response response = new JSONAPI(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", uuid.toString().replaceAll("-", ""))).call();
        if (response.getResponseCode() != 200) throw new RuntimeException("Response code isn't 200! (" + response.getResponseCode() + ")");
        JSONObject json = response.getResponse();
        JSONArray properties = json.getJSONArray("properties");
        return (JSONObject) properties.get(0);
    }

    @NotNull
    public static Object getProperty(@NotNull UUID uuid, @NotNull String s) {
        return getProperty(uuid).getString(s);
    }
}
