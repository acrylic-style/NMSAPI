package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;

public abstract class NBTBase extends NMSAPI {
    protected NBTBase(Object o, String clazz) {
        super(o, clazz);
    }

    protected NBTBase(String clazz, Object... args) {
        super(clazz, args);
    }

    public static final String[] a = new String[] {
            "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST",
            "COMPOUND", "INT[]", "LONG[]" };

    public abstract void write(DataOutput paramDataOutput);

    public abstract void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter);

    public abstract String toString();

    public abstract byte getTypeId();

    @NotNull
    @Contract(pure = true)
    public static String j(int paramInt) {
        switch (paramInt) {
            case 0:
                return "TAG_End";
            case 1:
                return "TAG_Byte";
            case 2:
                return "TAG_Short";
            case 3:
                return "TAG_Int";
            case 4:
                return "TAG_Long";
            case 5:
                return "TAG_Float";
            case 6:
                return "TAG_Double";
            case 7:
                return "TAG_Byte_Array";
            case 11:
                return "TAG_Int_Array";
            case 12:
                return "TAG_Long_Array";
            case 8:
                return "TAG_String";
            case 9:
                return "TAG_List";
            case 10:
                return "TAG_Compound";
            case 99:
                return "Any Numeric Tag";
        }
        return "UNKNOWN";
    }

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
            case 12:
                return new NBTTagLongArray();
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

    public String c_() {
        return toString();
    }

    // NMSAPI start
    @Nullable
    protected final NBTBase getInstance(@NotNull Object o) {
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
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("NBTTagLongArray"))) {
                return new NBTTagLongArray();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    // NMSAPI end
}
