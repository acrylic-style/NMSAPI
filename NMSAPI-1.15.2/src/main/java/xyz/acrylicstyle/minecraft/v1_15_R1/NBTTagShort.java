package xyz.acrylicstyle.minecraft.v1_15_R1;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagShort extends NBTBase.NBTNumber {
    public static final Class<?> CLASS = getClassWithoutException("NBTTagShort");

    public NBTTagShort() {
        super("NBTTagShort");
    }

    public NBTTagShort(short data) {
        super("NBTTagShort", data);
    }

    public NBTTagShort(Object o) {
        super(o, "NBTTagShort");
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
        return 2;
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

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    @Override
    public long c() {
        return (long) invoke("c");
    }

    @Override
    public int d() {
        return (int) invoke("d");
    }

    @Override
    public short e() {
        return (short) invoke("e");
    }

    @Override
    public byte f() {
        return (byte) invoke("f");
    }

    @Override
    public double g() {
        return (double) invoke("g");
    }

    @Override
    public float h() {
        return (float) invoke("h");
    }
}
