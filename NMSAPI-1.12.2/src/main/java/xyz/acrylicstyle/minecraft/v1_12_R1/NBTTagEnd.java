package xyz.acrylicstyle.minecraft.v1_12_R1;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTTagEnd extends NBTBase {
    public NBTTagEnd() {
        super("NBTTagEnd");
    }

    public NBTTagEnd(Object o) {
        super(o, "NBTTagEnd");
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
        return 0;
    }

    @Override
    public NBTBase clone() {
        return super.getInstance(invoke("clone"));
    }
}
