package xyz.acrylicstyle.minecraft;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagByteArray extends NBTBase {
    public static final Class<?> CLASS = getClassWithoutException("NBTTagByteArray");

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
}
