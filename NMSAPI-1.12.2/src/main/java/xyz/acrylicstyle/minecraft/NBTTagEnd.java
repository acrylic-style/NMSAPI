package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.InvocationTargetException;

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
