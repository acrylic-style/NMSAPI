package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;

public class AxisAlignedBB extends NMSAPI {
    public AxisAlignedBB(Object o) {
        super(o, "AxisAlignedBB");
    }

    public AxisAlignedBB(double d1, double d2, double d3, double d4, double d5, double d6) {
        super("AxisAlignedBB", d1, d2, d3, d4, d5, d6);
    }

    public AxisAlignedBB(BlockPosition blockPosition) {
        this(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), blockPosition.getX()+1, blockPosition.getY()+1, blockPosition.getZ()+1);
    }

    public AxisAlignedBB(BlockPosition blockPosition, BlockPosition blockPosition2) {
        this(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), blockPosition2.getX(), blockPosition2.getY(), blockPosition2.getZ());
    }

    public AxisAlignedBB e(double paramDouble) {
        return new AxisAlignedBB(invoke("e", paramDouble));
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public AxisAlignedBB a(double d1, double d2, double d3) {
        return new AxisAlignedBB(invoke("a", d1, d2, d3));
    }

    public AxisAlignedBB b(double d1, double d2, double d3) {
        return new AxisAlignedBB(invoke("b", d1, d2, d3));
    }

    public AxisAlignedBB grow(double d1, double d2, double d3) {
        return new AxisAlignedBB(invoke("grow", d1, d2, d3));
    }

    public AxisAlignedBB g(double d) {
        return grow(d, d, d);
    }

    public AxisAlignedBB a(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(invoke("a", axisAlignedBB.getNMSClass()));
    }

    public AxisAlignedBB b(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(invoke("b", axisAlignedBB.getNMSClass()));
    }

    public AxisAlignedBB d(double d1, double d2, double d3) {
        return new AxisAlignedBB(invoke("d", d1, d2, d3));
    }

    public AxisAlignedBB a(BlockPosition blockPosition) {
        return new AxisAlignedBB(invoke("a", blockPosition.getNMSClass()));
    }

    public AxisAlignedBB a(Vec3D vec3D) {
        return d(vec3D.getX(), vec3D.getY(), vec3D.getZ());
    }

    public double a(AxisAlignedBB axisAlignedBB, double d) {
        return (double) invoke("a", axisAlignedBB.getNMSClass(), d);
    }

    public double b(AxisAlignedBB axisAlignedBB, double d) {
        return (double) invoke("b", axisAlignedBB.getNMSClass(), d);
    }

    public double c(AxisAlignedBB axisAlignedBB, double d) {
        return (double) invoke("c", axisAlignedBB.getNMSClass(), d);
    }

    public boolean c(AxisAlignedBB axisAlignedBB) {
        return (boolean) invoke("c", axisAlignedBB.getNMSClass());
    }

    public boolean a(double d1, double d2, double d3, double d4, double d5, double d6) {
        return (boolean) invoke("a", d1, d2, d3, d4, d5 ,d6);
    }

    public boolean b(Vec3D vec3D) {
        return (boolean) invoke("b", vec3D.getNMSClass());
    }

    public double a() {
        return (double) invoke("a");
    }

    public AxisAlignedBB shrink(double d) {
        return g(-d);
    }

    @Nullable
    public MovingObjectPosition b(Vec3D vec3D, Vec3D vec3D2) {
        return new MovingObjectPosition(invoke("b", vec3D.getNMSClass(), vec3D2.getNMSClass()));
    }

    public boolean a(Vec3D vec3D1, Vec3D vec3D2, Vec3D vec3D3) {
        return (boolean) invoke("a", vec3D1.getNMSClass(), vec3D2.getNMSClass(), vec3D3.getNMSClass());
    }

    public Vec3D a(double d1, Vec3D vec3D1, Vec3D vec3D2) {
        return new Vec3D(invoke("a", d1, vec3D1.getNMSClass(), vec3D2.getNMSClass()));
    }

    public Vec3D b(double d1, Vec3D vec3D1, Vec3D vec3D2) {
        return new Vec3D(invoke("b", d1, vec3D1.getNMSClass(), vec3D2.getNMSClass()));
    }

    public Vec3D c(double d1, Vec3D vec3D1, Vec3D vec3D2) {
        return new Vec3D(invoke("c", d1, vec3D1.getNMSClass(), vec3D2.getNMSClass()));
    }

    public boolean c(Vec3D vec3D) {
        return (boolean) invoke("c", vec3D.getNMSClass());
    }

    public boolean d(Vec3D vec3D) {
        return (boolean) invoke("d", vec3D.getNMSClass());
    }

    public boolean e(Vec3D vec3D) {
        return (boolean) invoke("e", vec3D.getNMSClass());
    }

    public String toString() {
        return (String) invoke("toString");
    }
}
