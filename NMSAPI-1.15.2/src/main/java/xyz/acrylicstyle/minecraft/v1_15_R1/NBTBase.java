package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NBTBase extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("NBTBase");

    public static final String[] a = new String[] {
            "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST",
            "COMPOUND", "INT[]" };

    public NBTBase(Object o, String nms) {
        super(o, nms);
    }

    public NBTBase(String nms, Object... args) {
        super(nms, args);
    }

    public NBTBase() {
        super("NBTBase");
    }

    public abstract void write(DataOutput paramDataOutput) throws IOException;

    public abstract void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) throws IOException;

    public abstract String toString();

    public abstract byte getTypeId();

    @Nullable
    public static NBTBase createTag(byte paramByte) {
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

    public abstract NBTBase clone();

    public final NBTBase copy() {
        return this.clone();
    }

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
        public NBTNumber(Object o, String nms) {
            super(o, nms);
        }

        public NBTNumber(Object o) {
            super(o, "NBTNumber");
        }

        public NBTNumber(String nms, Object... args) {
            super(nms, args);
        }

        public abstract long c();

        public abstract int d();

        public abstract short e();

        public abstract byte f();

        public abstract double g();

        public abstract float h();
    }

    // NMSAPI start
    @Nullable
    public static NBTBase getInstance(@NotNull Object o) {
        try {
            if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagCompound"))) {
                return new NBTTagCompound(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagList"))) {
                return new NBTTagList(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagByte"))) {
                return new NBTTagByte(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagByteArray"))) {
                return new NBTTagByteArray(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagString"))) {
                return new NBTTagString(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagShort"))) {
                return new NBTTagShort(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagEnd"))) {
                return new NBTTagEnd(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagFloat"))) {
                return new NBTTagFloat(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagLong"))) {
                return new NBTTagLong(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagInt"))) {
                return new NBTTagInt(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagIntArray"))) {
                return new NBTTagIntArray(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagDouble"))) {
                return new NBTTagDouble(o);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    // NMSAPI end
}
