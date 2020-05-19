package xyz.acrylicstyle.minecraft.v1_15_R1;

import xyz.acrylicstyle.shared.NMSAPI;

import java.io.DataInput;

public interface NBTTagType<T extends NBTBase> {
    Class<?> CLASS = NMSAPI.getClassWithoutException("NBTTagType");

    T b(DataInput paramDataInput, int paramInt, NBTReadLimiter nbtReadLimiter);
}
