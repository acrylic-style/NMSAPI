package xyz.acrylicstyle.minecraft.v1_12_R1;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagString extends NBTBase {
    public NBTTagString() {
        super("NBTTagString");
    }

    public NBTTagString(String data) {
        super("NBTTagString", data);
    }

    public NBTTagString(Object o) {
        super(o, "NBTTagString");
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
        return 8;
    }

    @Override
    public NBTBase clone() {
        return super.getInstance(invoke("clone"));
    }

    @Override
    public String a_() {
        return (String) invoke("a_");
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object paramObject) {
        return (boolean) invoke("equals", paramObject);
    }

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public String get() { return a_(); }
}
