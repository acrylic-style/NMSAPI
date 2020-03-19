package xyz.acrylicstyle.minecraft;

public abstract class NBTNumber extends NBTBase {
    public abstract long d();
    public final long asLong() { return d(); }
    public abstract int e();
    public final int asInt() { return e(); }
    public abstract short f();
    public final short asShort() { return f(); }
    public abstract byte g();
    public final byte asByte() { return g(); }
    public abstract double asDouble();
    public abstract float i();
    public final float asFloat() { return i(); }
}