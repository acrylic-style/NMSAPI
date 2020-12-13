package xyz.acrylicstyle.nmsapi.shared.authlib.properties;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.RefClass;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;

public class Property extends xyz.acrylicstyle.mcutil.mojang.Property {
    public static final RefClass<?> CLASS = NMSAPI.clazz("com.mojang.authlib.properties.Property");

    @SuppressWarnings("deprecation")
    public Property(@NotNull Object o) {
        super((String) CLASS.getMethod("getName").invokeObj(o), (String) CLASS.getMethod("getValue").invokeObj(o), (String) CLASS.getMethod("getSignature").invokeObj(o));
    }

    public Property(@NotNull String name, @NotNull String value) {
        super(name, value);
    }

    public Property(@NotNull String name, @NotNull String value, @Nullable String signature) {
        super(name, value, signature);
    }

    @Contract(pure = true)
    @NotNull
    public Object asNMS() {
        return CLASS.getConstructor(String.class, String.class, String.class).newInstance(name, value, signature);
    }

    @Contract(pure = true)
    @NotNull
    public static Object convertToNMS(@NotNull xyz.acrylicstyle.mcutil.mojang.Property property) {
        return CLASS.getConstructor(String.class, String.class, String.class).newInstance(property.name, property.value, property.signature);
    }

    @Contract(pure = true)
    public static Object translateValue(Object value) {
        return value instanceof xyz.acrylicstyle.mcutil.mojang.Property ? convertToNMS((xyz.acrylicstyle.mcutil.mojang.Property) value) : value;
    }

    @Contract(pure = true)
    public static xyz.acrylicstyle.mcutil.mojang.Property translateToNMS(Object value) {
        return (xyz.acrylicstyle.mcutil.mojang.Property) translateValue(value);
    }
}
