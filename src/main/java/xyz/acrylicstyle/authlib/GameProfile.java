package xyz.acrylicstyle.authlib;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.authlib.properties.PropertyMap;
import xyz.acrylicstyle.craftbukkit.CraftUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@SuppressWarnings("unused")
public class GameProfile {
    public UUID getId() {
        return (UUID) getField("id");
    }

    public String getName() {
        return (String) getField("name");
    }

    public PropertyMap getProperties() {
        return new PropertyMap(getField("properties"));
    }

    public void setProperties(PropertyMap properties) { setField("properties", properties.getPropertyMap()); }

    public boolean isComplete() {
        return (boolean) invoke("isComplete");
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public String toString() {
        return (String) invoke("toString");
    }

    public boolean isLegacy() {
        return (boolean) getField("legacy");
    }

    // NMSAPI start
    private Object o;

    public GameProfile(Object o) {
        this.o = o;
    }

    public Object getGameProfile() {
        if (o.getClass().getCanonicalName().equals("com.mojang.authlib.GameProfile")) return o;
        try {
            return CraftUtils.getProfile(o);
        } catch (NoSuchMethodException e1) {
            try {
                return CraftUtils.getProfile(CraftUtils.getHandle(o));
            } catch (Exception e) {
                return null;
            }
        } catch (InvocationTargetException | IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(Class.forName("com.mojang.authlib.GameProfile"), getGameProfile(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(String field, Object value) {
        try {
            Field f = Class.forName("com.mojang.authlib.GameProfile").getDeclaredField(field);
            f.setAccessible(true);
            f.set(getGameProfile(), value);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public Object invoke(String method) {
        try {
            return Class.forName("com.mojang.authlib.GameProfile")
                    .getMethod(method)
                    .invoke(getGameProfile());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return Class.forName("com.mojang.authlib.GameProfile")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getGameProfile(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
