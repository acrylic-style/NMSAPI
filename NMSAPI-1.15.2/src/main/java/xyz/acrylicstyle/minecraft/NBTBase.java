package xyz.acrylicstyle.minecraft;

import java.io.DataOutput;
import java.io.IOException;

public interface NBTBase {
    Object d = null;
    Object e = null;
    Object f = null;
    Object g = null;

    void write(DataOutput paramDataOutput) throws IOException;

    String toString();

    byte getTypeId();

    NBTBase clone();

    default String asString() {
        return toString();
    }

    default Object l() {
        return a("", 0);
    }

    Object a(String paramString, int paramInt); // return type: IChatBaseComponent
}
