package xyz.acrylicstyle.minecraft.v1_8_R1;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

@SuppressWarnings("unused")
public class PlayerInteractManager extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("PlayerInteractManager");

    public World world;
    public EntityPlayer player;
    public boolean interactResult;
    public boolean firedResult;

    public PlayerInteractManager(Object o) {
        super(o, "PlayerInteractManager");
        this.world = World.newInstance(getField("world"));
        this.firedResult = false;
        this.interactResult = false;
    }

    public PlayerInteractManager(World world) {
        super("PlayerInteractManager", world.getHandle());
        this.interactResult = false;
        this.firedResult = false;
        this.world = world;
    }

    public void setGameMode(WorldSettings.EnumGamemode enumGamemode) {
        invoke("setGameMode", enumGamemode.getHandle());
    }

    public WorldSettings.EnumGamemode getGameMode() {
        return WorldSettings.EnumGamemode.valueOf(invoke("getGameMode"));
    }

    public boolean c() {
        return (boolean) invoke("c");
    }

    public boolean isCreative() {
        return (boolean) invoke("isCreative");
    }

    public void b(WorldSettings.EnumGamemode enumGameMode) {
        invoke("b", enumGameMode.getHandle());
    }

    public void a() {
        invoke("a");
    }

    public void tick() { a(); } // NMSAPI - OBFHelper

    public void a(BlockPosition blockPosition, EnumDirection enumDirection) {
        invoke("a", blockPosition.getHandle(), enumDirection.getHandle());
    }

    public void a(BlockPosition blockPosition) {
        invoke("a", blockPosition.getHandle());
    }

    public void e() {
        invoke("e");
    }

    private boolean c(BlockPosition blockPosition) {
        return (boolean) invoke("c", blockPosition.getHandle());
    }

    public boolean breakBlock(BlockPosition blockPosition) {
        return (boolean) invoke("breakBlock", blockPosition.getHandle());
    }

    public boolean useItem(Object entityHuman, World world, ItemStack itemStack) {
        try {
            return (boolean) ReflectionUtil.getNMSClass("PlayerInteractManager")
                    .getMethod("useItem", ReflectionUtil.getNMSClass("EntityHuman"), World.CLASS, ItemStack.CLASS)
                    .invoke(this.getHandle(), entityHuman, world.getHandle(), itemStack.getHandle());
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean interact(Object entityHuman, World world, ItemStack itemStack, BlockPosition blockPosition, EnumDirection enumDirection, float f, float f1, float f2) {
        try {
            return (boolean) ReflectionUtil.getNMSClass("PlayerInteractManager")
                    .getMethod("interact", ReflectionUtil.getNMSClass("EntityHuman"), World.CLASS, ItemStack.CLASS, BlockPosition.CLASS, EnumDirection.CLASS, float.class, float.class, float.class)
                    .invoke(this.getHandle(), entityHuman, world.getHandle(), itemStack.getHandle(), blockPosition.getHandle(), enumDirection.getHandle(), f, f1, f2);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public void a(WorldServer world) {
        this.world = world;
        invoke("a", world.getHandle());
    }
}
