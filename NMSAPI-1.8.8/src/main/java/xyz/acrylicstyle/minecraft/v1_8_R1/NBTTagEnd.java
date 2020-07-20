package xyz.acrylicstyle.minecraft.v1_8_R1;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagEnd extends NBTBase {
    public static final Class<?> CLASS = getClassWithoutException("NBTTagEnd");

    public NBTTagEnd() {
        super("NBTTagEnd");
    }

    public NBTTagEnd(Object o) {
        super(o, "NBTTagEnd");
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
        return 0;
    }

    @Override
    public NBTBase clone() {
        return getInstance(invoke("clone"));
    }
}
