package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class TileEntity extends NMSAPI {
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

    public void a(NBTTagCompound nbtTagCompound) {
        invoke("a", nbtTagCompound.getNBTTagCompound());
    }

    public void b(NBTTagCompound nbtTagCompound) {
        invoke("b", nbtTagCompound.getNBTTagCompound());
    }

    public static TileEntity c(NBTTagCompound nbtTagCompound) {
        try {
            return new TileEntity(ReflectionUtil
                    .getNMSClass("TileEntity")
                    .getMethod("c", ReflectionUtil.getNMSClass("NBTTagCompound"))
                    .invoke(null, nbtTagCompound.getNBTTagCompound()));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int u() {
        return (int) invoke("u");
    }

    public void update() {
        invoke("update");
    }

    public BlockPosition getPosition() {
        return new BlockPosition(invoke("getPosition"));
    }

    // public Block w() {}

    public Packet getUpdatePacket() {
        return null; // TODO: wip
    }
}
