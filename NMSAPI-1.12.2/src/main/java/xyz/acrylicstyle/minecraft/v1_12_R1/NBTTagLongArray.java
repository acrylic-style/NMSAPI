package xyz.acrylicstyle.minecraft.v1_12_R1;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagLongArray extends NBTBase {
    public NBTTagLongArray() {
        super("NBTTagLongArray");
    }

    @SuppressWarnings("RedundantCast")
    public NBTTagLongArray(long[] paramArrayOfInt) {
        super("NBTTagLongArray", (Object) paramArrayOfInt);
    }

    public NBTTagLongArray(Object o) {
        super(o, "NBTTagLongArray");
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
        return 11;
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

    public int[] c() {
        return (int[]) invoke("c");
    }
}
