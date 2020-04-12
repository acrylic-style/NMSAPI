package xyz.acrylicstyle.minecraft;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagIntArray extends NBTBase {
    public NBTTagIntArray() {
        super("NBTTagIntArray");
    }

    @SuppressWarnings("RedundantCast")
    public NBTTagIntArray(int[] paramArrayOfInt) {
        super("NBTTagIntArray", (Object) paramArrayOfInt);
    }

    public NBTTagIntArray(Object o) {
        super(o, "NBTTagIntArray");
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
    // NMSAPI end
}
