package xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflect.RefClass;
import xyz.acrylicstyle.mcutil.mojang.Property;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;
import xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.authlib.properties.PropertyMap;

import java.util.UUID;

public class GameProfile extends xyz.acrylicstyle.mcutil.mojang.GameProfile {
    public static final RefClass<?> CLASS = NMSAPI.clazz("com.mojang.authlib.GameProfile");

    @SuppressWarnings("deprecation")
    public GameProfile(@NotNull Object o) {
        super((UUID) CLASS.getMethod("getId").invokeObj(o), (String) CLASS.getMethod("getName").invokeObj(o), new PropertyMap(CLASS.getMethod("getProperties").invokeObj(o)).values().toArray(new Property[0]));
    }

    public GameProfile(@NotNull UUID id, @NotNull String name, @NotNull Property[] properties) {
        super(id, name, properties);
    }

    @Contract(pure = true)
    @NotNull
    public Object toNMS() {
        Object nms = CLASS.getDeclaredConstructor(UUID.class, String.class).accessible(true).newInstance(id, name);
        CLASS.getDeclaredField("properties").accessible(true).removeFinal().setObj(nms, PropertyMap.arrayToMap(properties).o);
        return nms;
    }
}
