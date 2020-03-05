package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NBTBase {
    public static final String[] a = new String[] {
            "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST",
            "COMPOUND", "INT[]" };

    public abstract void write(DataOutput paramDataOutput) throws IOException;

    public abstract void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) throws IOException;

    public abstract String toString();

    public abstract byte getTypeId();

    protected static NBTBase createTag(byte paramByte) {
        switch (paramByte) {
            case 0:
                return new NBTTagEnd();
            case 1:
                return new NBTTagByte();
            case 2:
                return new NBTTagShort();
            case 3:
                return new NBTTagInt();
            case 4:
                return new NBTTagLong();
            case 5:
                return new NBTTagFloat();
            case 6:
                return new NBTTagDouble();
            case 7:
                return new NBTTagByteArray();
            case 8:
                return new NBTTagString();
            case 9:
                return new NBTTagList();
            case 10:
                return new NBTTagCompound();
            case 11:
                return new NBTTagIntArray();
        }
        return null;
    }

    public abstract Object toNMSObject(); // NMSAPI

    public abstract NBTBase clone();

    public boolean isEmpty() {
        return false;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof NBTBase))
            return false;
        NBTBase nBTBase = (NBTBase)paramObject;
        return getTypeId() == nBTBase.getTypeId();
    }

    public int hashCode() {
        return getTypeId();
    }

    protected String a_() {
        return toString();
    }

    public static abstract class NBTNumber extends NBTBase {
        public abstract long c();

        public abstract int d();

        public abstract short e();

        public abstract byte f();

        public abstract double g();

        public abstract float h();
    }

    // NMSAPI start
    protected final NBTBase getInstance(Object o) {
        try {
            if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagCompound"))) {
                return new NBTTagCompound(o);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    // NMSAPI end
}