package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.InvocationTargetException;

public class NBTTagByteArray extends NBTBase {
    public NBTTagByteArray() {
        super("NBTTagByteArray");
    }

    @SuppressWarnings("RedundantCast")
    public NBTTagByteArray(byte[] paramArrayOfInt) {
        super("NBTTagByteArray", (Object) paramArrayOfInt);
    }

    public NBTTagByteArray(Object o) {
        super(o, "NBTTagByteArray");
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
        return 7;
    }

    @Override
    public Object toNMSObject() {
        return getHandle();
    }

    @Override
    public NBTBase clone() {
        return super.getInstance(invoke("clone"));
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public byte[] c() {
        return (byte[]) invoke("c");
    }
    // NMSAPI end
}
