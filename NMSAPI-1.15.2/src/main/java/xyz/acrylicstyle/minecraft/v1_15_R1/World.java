package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.craftbukkit.v1_15_R1.CraftServer;
import xyz.acrylicstyle.craftbukkit.v1_15_R1.CraftWorld;
import xyz.acrylicstyle.shared.NMSAPI;

public abstract class World extends NMSAPI implements IBlockAccess {
    public static final Class<?> CLASS = getClassWithoutException("World");

    protected World(String clazz, Object... o) {
        super(clazz, o);
    }

    protected World(Object o, String clazz) {
        super(o, clazz);
    }

    public World(Object o) {
        super(o, "World");
    }

    public CraftWorld getWorld() { return new CraftWorld((org.bukkit.World) getField("world")); }

    public CraftServer getServer() { return new CraftServer(Bukkit.getServer()); }

    public Chunk getChunkIfLoaded(int x, int z) {
        return new Chunk(invoke("getChunkIfLoaded", x, z));
    }

    public boolean isChunkLoaded(int x, int z) {
        return getChunkIfLoaded(x, z) != null;
    }

    @Override
    public TileEntity getTileEntity(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return new TileEntity(method("getTileEntity", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle()));
    }

    @Override
    public IBlockData getType(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return IBlockData.getInstance(method("getType", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle()));
    }

    @Override
    public boolean isEmpty(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return (boolean) method("isEmpty", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle());
    }

    @Override
    public int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection) {
        return (int) method("getBlockPower", BlockPosition.CLASS, EnumDirection.CLASS)
                .invokeObj(getHandle(), blockPosition.getHandle(), enumDirection.getHandle());
    }

    public boolean isClientSide() { return p_(); } // NMSAPI - OBFHELPER
    public boolean p_() { return field("isClientSide"); }

    public MinecraftServer getMinecraftServer() { return getServer().console; }

    public IBlockData i(BlockPosition blockPosition) {
        return IBlockData.getInstance(iRaw(blockPosition));
    }

    public Object iRaw(BlockPosition blockPosition) {
        return method("i", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle());
    }

    public static boolean isValidLocation(BlockPosition blockPosition) { return blockPosition.isValidLocation(); }

    public static boolean isOutsideWorld(BlockPosition blockPosition) { return blockPosition.isInvalidYLocation(); }

    public static boolean b(int i) { return i < 0 || i >= 256; }

    public Chunk getChunkAtWorldCoords(BlockPosition blockPosition) {
        return this.getChunkAt(blockPosition.getX() >> 4, blockPosition.getZ() >> 4);
    }

    public Chunk getChunkAt(int x, int z) {
        return new Chunk(invoke("getChunkat", x, z));
    }

    public Chunk getChunkIfLoadedImmediately(int x, int z) {
        return new Chunk(invoke("getChunkIfLoadedImmediately", x, z));
    }

    // public IBlockData getTypeIfLoaded(BlockPosition blockPosition) {}

    // public Fluid getFluidIfLoaded(BlockPosition blockPosition) {}

    @Deprecated
    public boolean isLoaded(BlockPosition blockPosition) {
        return getChunkIfLoaded(blockPosition.getX() >> 4, blockPosition.getZ() >> 4) != null;
    }

    public boolean isLoadedAndInBounds(BlockPosition blockPosition) {
        return (boolean) method("isLoadedAndInBounds", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle());
    }

    public Chunk getChunkIfLoaded(BlockPosition blockPosition) {
        return new Chunk(method("getChunkIfLoaded", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle()));
    }

    public boolean setTypeAndData(BlockPosition blockPosition, IBlockData iBlockData, int i) {
        return setTypeAndData(blockPosition, iBlockData.getHandle(), i);
    }

    public boolean setTypeAndData(BlockPosition blockPosition, Object iBlockData, int i) {
        return (boolean) method("setTypeAndData", BlockPosition.CLASS, IBlockData.CLASS, int.class)
                .invokeObj(getHandle(), blockPosition.getHandle(), iBlockData, i);
    }

    public boolean setAir(BlockPosition blockPosition) { return this.a(blockPosition, false); }
    public boolean setAir(BlockPosition blockPosition, boolean moved) { return this.a(blockPosition, moved); }
    public boolean a(BlockPosition blockPosition, boolean moved) {
        return (boolean) method("a", BlockPosition.CLASS, boolean.class).invokeObj(getHandle(), blockPosition.getHandle(), moved);
    }

    public boolean a(BlockPosition blockPosition, boolean flag, @Nullable Entity entity) {
        return (boolean) method("a", BlockPosition.CLASS, boolean.class, Entity.CLASS)
                .invokeObj(getHandle(), blockPosition.getHandle(), flag, entity == null ? null : entity.getHandle());
    }

    public boolean setTypeUpdate(BlockPosition blockPosition, IBlockData iBlockData) {
        return this.setTypeUpdate(blockPosition, iBlockData.getHandle());
    }

    public boolean setTypeUpdate(BlockPosition blockPosition, Object iBlockData) {
        return (boolean) method("setTypeUpdate", BlockPosition.CLASS, IBlockData.CLASS)
                .invokeObj(getHandle(), blockPosition.getHandle(), iBlockData);
    }

    public void tickBlockEntities() {
        invoke("tickBlockEntities");
    }

    public void setTileEntity(BlockPosition blockposition, @Nullable TileEntity tileentity) {
        method("setTileEntity", BlockPosition.CLASS, TileEntity.CLASS)
                .invokeObj(blockposition.getHandle(), tileentity == null ? null : tileentity.getHandle());
    }

    public void removeTileEntity(BlockPosition blockposition) {
        method("removeTileEntity", BlockPosition.CLASS).invokeObj(getHandle(), blockposition.getHandle());
    }

    public BlockPosition getSpawn() {
        return new BlockPosition(invoke("getSpawn"));
    }

    public long getSeed() { return (long) invoke("getSeed"); }

    public long getTime() { return (long) invoke("getTime"); }

    public long getDayTime() { return (long) invoke("getDayTime"); }

    public void setDayTime(long i) { invoke("setDayTime", i); }

    @NotNull
    @Contract("_ -> new")
    public static World newInstance(Object o) {
        return new World(o) {};
    }
}
