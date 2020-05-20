package xyz.acrylicstyle.minecraft.v1_15_R1;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class TileEntity extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("TileEntity");

    public TileEntity(Object o) {
        super(o, "TileEntity");
    }

    public TileEntity() {
        super("TileEntity");
    }

    public World getWorld() {
        return World.newInstance(invoke("getWorld"));
    }

    public void a(World world) {
        invoke("a", world.getNMSClass());
    }

    public boolean t() {
        return (boolean) invoke("t");
    }

    public void a(xyz.acrylicstyle.minecraft.v1_15_R1.NBTTagCompound nbtTagCompound) {
        invoke("a", nbtTagCompound.getNMSClass());
    }

    public void b(xyz.acrylicstyle.minecraft.v1_15_R1.NBTTagCompound nbtTagCompound) {
        invoke("b", nbtTagCompound.getNMSClass());
    }

    public static TileEntity c(NBTTagCompound nbtTagCompound) {
        return new TileEntity(invokeStatic("TileEntity", null, "c", nbtTagCompound.getHandle()));
    }

    public int u() {
        return (int) invoke("u");
    }

    public void update() {
        invoke("update");
    }

    public xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition getPosition() {
        return new BlockPosition(invoke("getPosition"));
    }

    public void save(NBTTagCompound tag) {
        invoke("save", tag.getHandle());
    }

    // public Block w() {}

    public Packet<?> getUpdatePacket() {
        return Packet.getInstance(invoke("getUpdatePacket"));
    }
}
