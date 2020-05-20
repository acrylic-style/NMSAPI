package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.bukkit.Material;
import org.jetbrains.annotations.Contract;
import util.reflect.Ref;
import xyz.acrylicstyle.minecraft.v1_15_R1.utils.Paper;
import xyz.acrylicstyle.shared.NMSAPI;

public class ChunkSection extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("ChunkSection");
    private Chunk chunk = null;

    private static Object callConstructor(int i, IChunkAccess chunk, World world, boolean initializeBlocks) {
        return Ref
                .getClass(CLASS)
                .getConstructor(int.class, IChunkAccess.CLASS, World.CLASS, boolean.class)
                .newInstance(i, chunk, world, initializeBlocks);
    }

    private static Object callConstructor(int i, short short0, short short1, short short2, IChunkAccess chunk, World world, boolean initializeBlocks) {
        return Ref
                .getClass(CLASS)
                .getConstructor(int.class, short.class, short.class, short.class, IChunkAccess.CLASS, World.CLASS, boolean.class)
                .newInstance(i, short0, short1, short2, chunk, world, initializeBlocks);
    }

    public ChunkSection(Object o) {
        super(o, "ChunkSection");
    }

    //@Deprecated
    public ChunkSection(int i) {
        super("ChunkSection", i);
    }

    @Paper
    public ChunkSection(int i, IChunkAccess chunk, World world, boolean initializeBlocks) {
        super(callConstructor(i, chunk, world, initializeBlocks), "ChunkSection");
    }

    //@Deprecated
    public ChunkSection(int i, short short0, short short1, short short2) {
        super("ChunkSection", i, short0, short1, short2);
    }

    @Paper
    public ChunkSection(int i, short short0, short short1, short short2, IChunkAccess chunk, World world, boolean initializeBlocks) {
        super(callConstructor(i, short0, short1, short2, chunk, world, initializeBlocks), "ChunkSection");
    }

    ChunkSection setChunk(Chunk chunk) { this.chunk = chunk; return this; }

    public Chunk getChunk() { return chunk; }

    @Contract("_, _, _, _ -> null")
    public IBlockData setType(int i, int j, int k, IBlockData iBlockData) {
        return this.setType(i, j, k, iBlockData, true);
    }

    @Contract("_, _, _, _, _ -> null")
    public IBlockData setType(int i, int j, int k, IBlockData iBlockData, boolean applyPhysics) {
        return IBlockData.getInstance(method("setType", int.class, int.class, int.class, IBlockData.CLASS, boolean.class).invokeObj(getHandle(), i, j, k, iBlockData.getHandle(), applyPhysics));
    }

    @Contract("_, _, _, _ -> null")
    public IBlockData setType(int i, int j, int k, Object o) {
        return this.setType(i, j, k, o, true);
    }

    @Contract("_, _, _, _, _ -> null")
    public IBlockData setType(int i, int j, int k, Object iBlockData, boolean applyPhysics) {
        return IBlockData.getInstance(method("setType", int.class, int.class, int.class, IBlockData.CLASS, boolean.class).invokeObj(getHandle(), i, j, k, iBlockData, applyPhysics));
    }

    @Contract("_, _, _, _, _ -> null")
    public IBlockData setType(int i, int j, int k, Material material, boolean applyPhysics) {
        return IBlockData.getInstance(method("setType", int.class, int.class, int.class, IBlockData.CLASS, boolean.class).invokeObj(getHandle(), i, j, k, Block.getByCombinedIdRaw(material, (byte) 0), applyPhysics));
    }
}
