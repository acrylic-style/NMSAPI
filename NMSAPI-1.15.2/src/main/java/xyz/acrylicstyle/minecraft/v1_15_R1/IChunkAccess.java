package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.jetbrains.annotations.Nullable;
import util.reflect.Ref;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.Set;
import java.util.stream.Stream;

public interface IChunkAccess extends IBlockAccess, IStructureAccess {
    Class<?> CLASS = NMSAPI.getClassWithoutException("IChunkAccess");

    @Nullable
    IBlockData setType(BlockPosition paramBlockPosition, IBlockData paramIBlockData, boolean paramBoolean);

    void setTileEntity(BlockPosition paramBlockPosition, TileEntity paramTileEntity);

    void a(Entity paramEntity);

    @Nullable
    default ChunkSection a() {
        return new ChunkSection(Ref.getMethod(CLASS, "a").invokeObj(this));
    }

    ChunkSection[] getSections();

    default int b() {
        return (int) Ref.getMethod(CLASS, "b").invokeObj(this);
    }

    Set<BlockPosition> c();

    // todo: create HeightMap and Type
    // Collection<Map.Entry<Type, HeightMap>> f();

    // todo: create Type
    // void a(Type var1, long[] var2);

    // HeightMap a(Type var1);

    //int a(Type var1, int var2, int var3);

    // todo: create ChunkCoordIntPair
    // ChunkCoordIntPair getPos();

    void setLastSaved(long var1);

    // Map<String, StructureStart> h();

    // void a(Map<String, StructureStart>) h();

    default boolean a(int var0, int var1) {
        return (boolean) Ref.getMethod(CLASS, "a", int.class, int.class).invokeObj(this, var0, var1);
    }

    // todo: create BiomeStorage
    // @Nullable
    // BiomeStorage getBiomeIndex();

    void setNeedsSaving(boolean var1);

    boolean isNeedsSaving();

    // todo: create ChunkStatus
    // ChunkStatus getChunkStatus();

    void removeTileEntity(BlockPosition blockPosition);

    default void e(BlockPosition blockPosition) {
        Ref.getMethod(CLASS, "e", BlockPosition.CLASS).invokeObj(this, blockPosition.getHandle());
    }

    // todo: create it.unimi.dsi.fastutil.shorts.ShortList?
    // ShortList[] l();

    default void a(short var0, int var1) {
        Ref.getMethod(CLASS, "a", short.class, int.class).invokeObj(this, var0, var1);
    }

    default void setBlockEntity(NBTTagCompound tag) { this.a(tag); } // NMSAPI - OBFHELPER
    default void a(NBTTagCompound tag) {
        Ref.getMethod(CLASS, "a", NBTTagCompound.CLASS).invokeObj(this, tag.getHandle());
    }

    @Nullable
    NBTTagCompound f(BlockPosition blockPosition);

    @Nullable
    NBTTagCompound i(BlockPosition blockPosition);

    Stream<BlockPosition> m();

    // todo: create TickList
    // TickList<Block> n();

    // TickList<FluidType> o();

    // todo: create Features
    // default BitSet a(Features features) { return (BitSet) Ref.getMethod(CLASS, "a", Features.CLASS).invokeObj(this, features.getHandle()); }

    // todo: create ChunkConverter
    // ChunkConverter p();

    void setInhabitedTime(long var1);

    long getInhabitedTime();

    // static ShortList a(ShortList[] var0, int var1) { return (ShortList) Ref.getMethod(CLASS, "a", ShortList[].class, int.class).invokeObj(this, var0, var1); }

    boolean r();

    void b(boolean var1);
}
