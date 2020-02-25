package xyz.acrylicstyle.authlib.properties;

import com.google.common.collect.Multimap;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.CraftUtils;

import java.lang.reflect.InvocationTargetException;

public class PropertyMap {
    @SuppressWarnings("rawtypes")
    public Multimap delegate() {
        return (Multimap) invoke("delegate");
    }

    // NMSAPI start
    private Object o;

    public PropertyMap(Object o) {
        this.o = o;
    }

    public Object getPropertyMap() {
        if (o.getClass().getCanonicalName().equals("com.mojang.authlib.properties.PropertyMap")) return o;
        try {
            return CraftUtils.getProfile(o).getClass().getMethod("getProperties").invoke(o);
        } catch (NoSuchMethodException e1) {
            try {
                return CraftUtils.getProfile(CraftUtils.getHandle(o)).getClass().getMethod("getProperties").invoke(o);
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
            return ReflectionHelper.getField(Class.forName("org.mojang.authlib.properties.PropertyMap"), getPropertyMap(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return Class.forName("org.mojang.authlib.properties.PropertyMap")
                    .getMethod(method)
                    .invoke(getPropertyMap());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return Class.forName("org.mojang.authlib.properties.PropertyMap")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getPropertyMap(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
