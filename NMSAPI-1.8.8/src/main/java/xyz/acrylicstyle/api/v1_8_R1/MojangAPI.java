package xyz.acrylicstyle.api.v1_8_R1;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import util.JSONAPI;
import util.promise.Promise;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.authlib.properties.Property;
import xyz.acrylicstyle.authlib.properties.PropertyMap;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.entity.CraftPlayer;
import xyz.acrylicstyle.shared.BaseMojangAPI;

import java.util.Objects;
import java.util.UUID;

public class MojangAPI extends BaseMojangAPI {
    private MojangAPI() {}

    @NotNull
    public static GameProfile getGameProfile(@NotNull String name) {
        UUID uuid = getUniqueId(name);
        if (uuid == null) throw new RuntimeException("UUID is null (rate limit?)");
        return getGameProfile(uuid);
    }

    @NotNull
    public static Promise<GameProfile> getGameProfileAsync(@NotNull UUID uuid) {
        return new Promise<GameProfile>() {
            @Override
            public GameProfile apply(Object o) {
                return getGameProfile(uuid);
            }
        };
    }

    @NotNull
    public static GameProfile getGameProfile(@NotNull UUID uuid) {
        JSONAPI.Response response = new JSONAPI(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", uuid.toString().replaceAll("-", ""))).call(JSONObject.class);
        if (response.getResponseCode() != 200) throw new RuntimeException("Response code isn't 200! (" + response.getResponseCode() + ")");
        JSONObject json = (JSONObject) response.getResponse();
        UUID id = UUID.fromString(json.getString("id").replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
        String name = json.getString("name");
        JSONArray properties = json.getJSONArray("properties");
        JSONObject property = (JSONObject) properties.get(0);
        String textures_value = property.getString("value");
        String textures_signature = property.getString("signature");
        GameProfile profile = new GameProfile(id, name);
        PropertyMap propertyMap = profile.getProperties();
        propertyMap.put("textures", new Property("textures", textures_value, textures_signature));
        profile.setProperties(propertyMap);
        return profile;
    }

    @NotNull
    public static Promise<Player> changeSkinAsync(@NotNull Plugin plugin, @NotNull Player player, @NotNull UUID uuid) {
        return getGameProfileAsync(uuid).then(profile -> {
            CraftPlayer craftPlayer = new CraftPlayer(player);
            craftPlayer.getProfile().setProperties(profile.getProperties());
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (player.getUniqueId().equals(p.getUniqueId())) continue;
                        p.hidePlayer(player);
                        p.showPlayer(player);
                    }
                }
            }.runTask(plugin);
            return craftPlayer.getPlayer();
        });
    }

    @NotNull
    public static Player changeSkin(@NotNull Player player, @NotNull UUID uuid) {
        CraftPlayer craftPlayer = new CraftPlayer(player);
        craftPlayer.getProfile().setProperties(getGameProfile(uuid).getProperties());
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId().equals(p.getUniqueId())) continue;
            p.hidePlayer(player);
            p.showPlayer(player);
        }
        return Objects.requireNonNull(craftPlayer.getPlayer());
    }
}
