package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.InvocationTargetException;

public class NBTTagString extends NBTBase {
    // NMSAPI start
    private Object o;

    public NBTTagString() {
        try {
            this.o = ReflectionUtil.getNMSClass("NBTTagString").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public NBTTagString(String data) {
        try {
            this.o = ReflectionUtil.getNMSClass("NBTTagString").getConstructor(String.class).newInstance(data);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public NBTTagString(Object o) {
        this.o = o;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("NBTTagString"), getNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("NBTTagString")
                    .getMethod(method)
                    .invoke(getNMSClass());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("NBTTagShort").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("NBTTagString")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end

    @Override
    public void write(DataOutput paramDataOutput) {
        invoke("write", paramDataOutput);
    }

    @Override
    public void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) {
        invoke("load", paramDataInput, paramInt, paramNBTReadLimiter);
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    @Override
    public byte getTypeId() {
        return 8;
    }

    @Override
    public NBTBase clone() {
        return super.getInstance(invoke("clone"));
    }

    @Override
    public String a_() {
        return (String) invoke("a_");
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object paramObject) {
        return (boolean) invoke("equals", paramObject);
    }

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public String get() { return a_(); }
}
