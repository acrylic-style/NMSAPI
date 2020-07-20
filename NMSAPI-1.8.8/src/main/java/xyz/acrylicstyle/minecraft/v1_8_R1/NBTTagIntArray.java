package xyz.acrylicstyle.minecraft.v1_8_R1;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagIntArray extends NBTBase {
    public static final Class<?> CLASS = getClassWithoutException("NBTTagIntArray");

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
    public NBTBase clone() {
        return getInstance(invoke("clone"));
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
