package xyz.acrylicstyle.api;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import util.JSONAPI;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.authlib.properties.Property;
import xyz.acrylicstyle.authlib.properties.PropertyMap;

import java.util.UUID;

public class MojangAPI {
    private MojangAPI() {}

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
    public static GameProfile getGameProfile(@NotNull String name) {
        UUID uuid = getUniqueId(name);
        return getGameProfile(uuid);
    }

    @NotNull
    public static GameProfile getGameProfile(@NotNull UUID uuid) {
        JSONAPI.Response response = new JSONAPI(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", uuid.toString().replaceAll("-", ""))).call();
        if (response.getResponseCode() != 200) throw new RuntimeException("Response code isn't 200! (" + response.getResponseCode() + ")");
        JSONObject json = response.getResponse();
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
    public static String getSkin(@NotNull UUID uuid) {
        return (String) getProperty(uuid, "value");
    }

    @NotNull
    public static String getSkinSignature(@NotNull UUID uuid) {
        return (String) getProperty(uuid, "signature");
    }

    @NotNull
    public static Object getProperty(@NotNull UUID uuid, @NotNull String s) {
        JSONAPI.Response response = new JSONAPI(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", uuid.toString().replaceAll("-", ""))).call();
        if (response.getResponseCode() != 200) throw new RuntimeException("Response code isn't 200! (" + response.getResponseCode() + ")");
        JSONObject json = response.getResponse();
        JSONArray properties = json.getJSONArray("properties");
        JSONObject property = (JSONObject) properties.get(0);
        return property.getString(s);
    }
}
