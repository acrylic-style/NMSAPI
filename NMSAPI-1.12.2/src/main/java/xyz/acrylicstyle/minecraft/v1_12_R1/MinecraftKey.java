package xyz.acrylicstyle.minecraft.v1_12_R1;

import com.google.gson.*;
import xyz.acrylicstyle.shared.NMSAPI;

import java.lang.reflect.Type;

public class MinecraftKey extends NMSAPI {
    public MinecraftKey(Object o) {
        super(o, "MinecraftKey");
    }

    public MinecraftKey(int paramInt, String... paramVarArgs) {
        super("MinecraftKey", paramInt, paramVarArgs);
    }

    public MinecraftKey(String paramString) {
        this(0, paramString);
    }

    public MinecraftKey(String paramString1, String paramString2) {
        this(0, paramString1, paramString2);
    }

    public static String[] a(String paramString) {
        String[] arrayOfString = { "minecraft", paramString };
        int i = paramString.indexOf(':');
        if (i >= 0) {
            arrayOfString[1] = paramString.substring(i + 1);
            if (i > 1)
                arrayOfString[0] = paramString.substring(0, i);
        }
        return arrayOfString;
    }

    public String getKey() {
        return (String) getField("b");
    }

    public String b() {
        return (String) getField("a");
    }

    public String toString() {
        return (String) invoke("toString");
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof MinecraftKey) {
            MinecraftKey minecraftKey = (MinecraftKey) o;
            return (b().equalsIgnoreCase(minecraftKey.b()) && getKey().equalsIgnoreCase(minecraftKey.getKey()));
        }
        return false;
    }

    public int hashCode() {
        return 31 * b().hashCode() + getKey().hashCode();
    }

    public int a(MinecraftKey minecraftKey) {
        return (int) invoke("a", minecraftKey.getNMSClass());
    }

    public static class a extends NMSAPI implements JsonDeserializer<MinecraftKey>, JsonSerializer<MinecraftKey> {
        public a() {
            super("MinecraftKey.a");
        }

        @Override
        public MinecraftKey deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return (MinecraftKey) invoke("deserialize", jsonElement, type, jsonDeserializationContext);
        }

        @Override
        public JsonElement serialize(MinecraftKey minecraftKey, Type type, JsonSerializationContext jsonSerializationContext) {
            return (JsonElement) invoke("serialize", minecraftKey, type, jsonSerializationContext);
        }
    }
}
