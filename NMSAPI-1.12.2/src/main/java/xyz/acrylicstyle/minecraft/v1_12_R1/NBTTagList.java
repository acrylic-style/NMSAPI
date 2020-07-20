package xyz.acrylicstyle.minecraft.v1_12_R1;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagList extends NBTBase {
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

    @Override
    public Object toNMSObject() {
        return getHandle();
    }

    public NBTBase a(int i) {
        return super.getInstance(invoke("a", i));
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
        return super.getInstance(invoke("g", i));
    }

    public int size() {
        return (int) invoke("size");
    }

    public NBTBase clone() {
        return super.getInstance(invoke("clone"));
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
