package xyz.acrylicstyle.minecraft.v1_12_R1;

public abstract class NBTNumber extends NBTBase {
    protected NBTNumber(Object o, String clazz) {
        super(o, clazz);
    }

    protected NBTNumber(String clazz, Object... args) {
        super(clazz, args);
    }

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
