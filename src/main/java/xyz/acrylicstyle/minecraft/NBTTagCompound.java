package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

public class NBTTagCompound {
    public static final Pattern c = Pattern.compile("[A-Za-z0-9._+-]+");

    // NMSAPI start
    private Object o;

    public Object getNBTTagCompound() {
        if (o.getClass().getSimpleName().equals("NBTTagCompound")) return o;
        try {
            return o.getClass().getField("tag").get(o);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("NBTTagCompound"), getNBTTagCompound(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("NBTTagCompound")
                    .getMethod(method)
                    .invoke(getNBTTagCompound());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("NBTTagCompound")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNBTTagCompound(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
