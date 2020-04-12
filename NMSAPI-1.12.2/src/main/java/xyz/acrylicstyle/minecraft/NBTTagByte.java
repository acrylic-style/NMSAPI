package xyz.acrylicstyle.minecraft;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagByte extends NBTNumber {
    public NBTTagByte() {
        super("NBTTagByte");
    }

    public NBTTagByte(long data) {
        super("NBTTagByte", data);
    }

    public NBTTagByte(Object o) {
        super(o, "NBTTagByte");
    }

    @Override
    public Object toNMSObject() {
        return getHandle();
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
        return 1;
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

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    @Override
    public long d() {
        return (long) invoke("d");
    }

    @Override
    public int e() {
        return (int) invoke("e");
    }

    @Override
    public short f() {
        return (short) invoke("f");
    }

    @Override
    public byte g() {
        return (byte) invoke("g");
    }

    @Override
    public double asDouble() {
        return (double) invoke("asDouble");
    }

    @Override
    public float i() {
        return (float) invoke("i");
    }
}
