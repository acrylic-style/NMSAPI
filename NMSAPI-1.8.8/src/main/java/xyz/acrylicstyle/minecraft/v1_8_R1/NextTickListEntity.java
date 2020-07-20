package xyz.acrylicstyle.minecraft.v1_8_R1;

import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.shared.NMSAPI;

public class NextTickListEntity extends NMSAPI implements Comparable<NextTickListEntity> {
    public final BlockPosition a;
    public long b;
    public int c;

    public NextTickListEntity(Object o) {
        super(o, "NextTickListEntity");
        this.a = new BlockPosition(getField("a"));
    }

    public NextTickListEntity(BlockPosition blockPosition, Object block) {
        super("NextTickListEntity", blockPosition.getHandle(), block);
        this.a = blockPosition;
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public int hashCode() {
        return a.hashCode();
    }

    public NextTickListEntity a(long i) {
        this.b = i;
        invoke("a", i);
        return this;
    }

    public void a(int i) {
        this.c = i;
        invoke("a", i);
    }

    public int a(NextTickListEntity nextTickListEntity) {
        return (int) invoke("a", nextTickListEntity.getHandle());
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }


    // todo: create Block
    public Object a() {
        return getField("e");
    }

    @Override
    public int compareTo(@NotNull NextTickListEntity o) {
        return a(o);
    }
}
