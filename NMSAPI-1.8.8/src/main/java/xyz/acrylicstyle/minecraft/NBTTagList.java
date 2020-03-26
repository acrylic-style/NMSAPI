package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class NBTTagList extends NBTBase {
    // NMSAPI start
    private Object o;

    public NBTTagList() {
        try {
            this.o = ReflectionUtil.getNMSClass("NBTTagList").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public NBTTagList(Object o) {
        this.o = o;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("NBTTagList"), getNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("NBTTagList")
                    .getMethod(method)
                    .invoke(getNMSClass());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("NBTTagList")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

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
        return 9;
    }

    @Override
    public Object getNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("NBTTagList").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    // NMSAPI end

    public void add(NBTBase nbtBase) {
        invoke("add", nbtBase.getNMSClass());
    }

    public NBTTagList addAllString(List<String> list) {
        list.forEach(s -> this.add(new NBTTagString(s)));
        return this;
    }

    public NBTBase a(int i) {
        return super.getInstance(invoke("a", i));
    }

    public boolean isEmpty() {
        return (boolean) invoke("isEmpty");
    }

    public NBTTagCompound get(int i) {
        return new NBTTagCompound(invoke("get", i));
    }

    public int[] c(int i) {
        return (int[]) invoke("c", i);
    }

    public double d(int i) {
        return (double) invoke("d", i);
    }

    public float e(int i) {
        return (int) invoke("e", i);
    }

    public String getString(int i) {
        return (String) invoke("getString", i);
    }

    public NBTBase g(int i) {
        return super.getInstance(invoke("g", i));
    }

    public int size() {
        return (int) invoke("size");
    }

    public NBTBase clone() {
        return super.getInstance(invoke("clone"));
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public int f() {
        return (int) invoke("f");
    }
}
