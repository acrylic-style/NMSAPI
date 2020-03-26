package xyz.acrylicstyle.craftbukkit.v1_8_R3.util;

import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.CraftUtils;

import java.lang.reflect.InvocationTargetException;

public interface Handler<T> {
    @SuppressWarnings("unchecked")
    default T getHandle() {
        try {
            return (T) CraftUtils.getHandle(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
