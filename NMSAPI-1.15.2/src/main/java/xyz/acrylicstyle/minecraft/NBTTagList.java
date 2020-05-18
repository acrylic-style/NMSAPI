package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.Method;
import java.util.List;

public class NBTTagList extends NBTBase {
    public static final Class<?> CLASS = getClassWithoutException("NBTTagList");

    public NBTTagList() {
        super("NBTTagList");
    }

    public NBTTagList(Object o) {
        super(o, "NBTTagList");
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

    public void add(NBTBase nbtBase) {
        try {
            Method m = ReflectionUtil.getNMSClass("NBTTagList").getMethod("add", ReflectionUtil.getNMSClass("NBTBase"));
            m.setAccessible(true);
            m.invoke(getNMSClass(), nbtBase.getHandle());
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public void a(int i, NBTBase nbtBase) {
        try {
            Method m = ReflectionUtil.getNMSClass("NBTTagList").getMethod("a", int.class, ReflectionUtil.getNMSClass("NBTBase"));
            m.setAccessible(true);
            m.invoke(getNMSClass(), i, nbtBase.getHandle());
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public NBTTagList addAllString(List<String> list) {
        list.forEach(s -> this.add(new NBTTagString(s)));
        return this;
    }

    public NBTBase a(int i) {
        return getInstance(invoke("a", i));
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
        return getInstance(invoke("g", i));
    }

    public int size() {
        return (int) invoke("size");
    }

    public NBTBase clone() {
        return getInstance(invoke("clone"));
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
