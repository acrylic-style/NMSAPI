package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class NBTTagCompound extends NBTBase implements Cloneable {
    public static final Pattern c = Pattern.compile("[A-Za-z0-9._+-]+");

    // NMSAPI start
    private Object o;

    public NBTTagCompound() {
        try {
            this.o = ReflectionUtil.getNMSClass("NBTTagCompound").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public NBTTagCompound(Object o) {
        this.o = o;
    }

    public Object getNBTTagCompound() {
        if (o.getClass().getCanonicalName().startsWith("net.minecraft.server") && o.getClass().getSimpleName().equals("NBTTagCompound")) return o;
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

    @Override
    public void write(DataOutput paramDataOutput) {
        invoke("write", paramDataOutput);
    }

    public CrashReport a(String paramString, int paramInt, ClassCastException paramClassCastException) {
        return new CrashReport(invoke("a", paramString, paramInt, paramClassCastException));
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
        return 10;
    }

    @Override
    public Object toNMSObject() {
        return getNBTTagCompound();
    }

    @Override
    public NBTBase clone() {
        return (NBTBase) invoke("clone");
    }

    @SuppressWarnings("unchecked")
    public Set<String> c() {
        return (Set<String>) invoke("c");
    }

    public void set(String key, NBTBase nbtBase) {
        invoke("set", key, nbtBase.toNMSObject());
    }

    public void setByte(String key, byte paramByte) {
        invoke("setByte", key, paramByte);
    }

    public void setShort(String key, short paramShort) {
        invoke("setShort", key, paramShort);
    }

    public void setInt(String key, int paramInt) {
        invoke("setInt", key, paramInt);
    }

    public void setLong(String key, long paramLong) {
        invoke("setLong", key, paramLong);
    }

    public void setFloat(String key, float paramFloat) {
        invoke("setFloat", key, paramFloat);
    }

    public void setDouble(String key, double paramDouble) {
        invoke("setDouble", key, paramDouble);
    }

    public void setString(String key, String paramString) {
        invoke("setString", key, paramString);
    }

    public void setByteArray(String key, byte[] bytes) {
        invoke("setByteArray", key, bytes);
    }

    public void setIntArray(String key, int[] intArray) {
        invoke("setIntArray", key, intArray);
    }

    public void setBoolean(String key, boolean paramBoolean) {
        invoke("setBoolean", key, paramBoolean);
    }

    public NBTBase get(String key) {
        return super.getInstance(invoke("get", key));
    }

    public byte b(String paramString) {
        return (byte) invoke("b", paramString);
    }

    public boolean hasKey(String key) {
        return (boolean) invoke("hasKey", key);
    }

    public boolean hasKeyOfType(String key, int paramInt) {
        return (boolean) invoke("hasKeyOfType", key, paramInt);
    }

    public byte getByte(String key) {
        return (byte) invoke("getByte", key);
    }

    public short getShort(String key) {
        return (short) invoke("getShort", key);
    }

    public int getInt(String key) {
        return (int) invoke("getInt", key);
    }

    public long getLong(String key) {
        return (long) invoke("getLong", key);
    }

    public float getFloat(String key) {
        return (float) invoke("getFloat", key);
    }

    public double getDouble(String key) {
        return (double) invoke("getDouble", key);
    }

    public String getString(String key) {
        return (String) invoke("getString", key);
    }

    public byte[] getByteArray(String key) {
        return (byte[]) invoke("getByteArray", key);
    }

    public int[] getIntArray(String key) {
        return (int[]) invoke("getIntArray", key);
    }

    public NBTTagCompound getCompound(String key) {
        return new NBTTagCompound(invoke("key"));
    }

    public NBTTagList getList(String key, int paramInt) {
        return new NBTTagList(invoke("getList", key, paramInt));
    }

    public boolean getBoolean(String key) {
        return (boolean) invoke("getBoolean", key);
    }

    public void remove(String key) {
        invoke("remove", key);
    }

    @Override
    public boolean isEmpty() {
        return (boolean) invoke("isEmpty");
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object paramObject) {
        return (boolean) invoke("equals", paramObject);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public void a(NBTTagCompound nbtTagCompound) {
        invoke("a", nbtTagCompound.getNBTTagCompound());
    }
}
