package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.jetbrains.annotations.Nullable;
import util.ICollectionList;
import util.reflect.Ref;
import xyz.acrylicstyle.minecraft.v1_15_R1.utils.Paper;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.Set;
import java.util.stream.Stream;

public class Chunk extends NMSAPI implements IChunkAccess {
    public static final Class<?> CLASS = getClassWithoutException("Chunk");
    public static final ChunkSection a = null;
    @Paper
    public static final ChunkSection EMPTY_CHUNK_SECTION = Chunk.a; // Paper - OBFHELPER
    private final ChunkSection[] sections;

    public Chunk(Object o) {
        super(o, "Chunk");
        this.sections = ICollectionList
                .asList((Object[]) getField("sections"))
                .map((s, i) -> s == null ? new ChunkSection(i << 4).setChunk(this) : new ChunkSection(s).setChunk(this))
                .toArray(new ChunkSection[0]);
    }

    @Override
    public @Nullable IBlockData setType(BlockPosition paramBlockPosition, IBlockData paramIBlockData, boolean paramBoolean) {
        return setType(paramBlockPosition, paramIBlockData.getHandle(), paramBoolean);
    }

    public @Nullable IBlockData setType(BlockPosition paramBlockPosition, Object paramRawIBlockData, boolean paramBoolean) {
        return IBlockData.getInstance(Ref
                .getMethod(CLASS, "setType", BlockPosition.CLASS, IBlockData.CLASS, boolean.class)
                .invokeObj(getHandle(), paramBlockPosition.getHandle(), paramRawIBlockData, paramBoolean));
    }

    @Override
    public void setTileEntity(BlockPosition paramBlockPosition, TileEntity paramTileEntity) {
        Ref.getMethod(CLASS, "setTileEntity", BlockPosition.CLASS, TileEntity.CLASS)
                .invokeObj(getHandle(), paramBlockPosition.getHandle(), paramTileEntity.getHandle());
    }

    @Override
    public void a(Entity paramEntity) {
        Ref.getMethod(CLASS, "a", Entity.CLASS).invokeObj(getHandle(), paramEntity.getHandle());
    }

    @Override
    public ChunkSection[] getSections() { return sections; }

    @Override
    @SuppressWarnings("unchecked")
    public Set<BlockPosition> c() {
        return (Set<BlockPosition>) Ref.getMethod(CLASS, "c").invokeObj(getHandle());
    }

    @Override
    public void setLastSaved(long var1) {
        Ref.getMethod(CLASS, "setLastSaved", long.class).invokeObj(getHandle(), var1);
    }

    @Override
    public void setNeedsSaving(boolean var1) {
        Ref.getMethod(CLASS, "setNeedsSaving", boolean.class).invokeObj(getHandle(), var1);
    }

    @Override
    public boolean isNeedsSaving() {
        return (boolean) Ref.getMethod(CLASS, "isNeedsSaving").invokeObj(getHandle());
    }

    @Override
    public void removeTileEntity(BlockPosition blockPosition) {
        Ref.getMethod(CLASS, "removeTileEntity", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle());
    }

    @Override
    public @Nullable NBTTagCompound f(BlockPosition blockPosition) {
        return new NBTTagCompound(Ref.getMethod(CLASS, "f", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle()));
    }

    @Override
    public @Nullable NBTTagCompound i(BlockPosition blockPosition) {
        return new NBTTagCompound(Ref.getMethod(CLASS, "i", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stream<BlockPosition> m() {
        return (Stream<BlockPosition>) Ref.getMethod(CLASS, "m").invokeObj(getHandle());
    }

    @Override
    public void setInhabitedTime(long var1) {
        Ref.getMethod(CLASS, "setInhabitedTime", long.class).invokeObj(getHandle(), var1);
    }

    @Override
    public long getInhabitedTime() {
        return (long) invoke("getInhabitedTime");
    }

    @Override
    public boolean r() {
        return (boolean) invoke("r");
    }

    @Override
    public void b(boolean var1) {
        invoke("b", var1);
    }

    @Override
    public TileEntity getTileEntity(BlockPosition blockPosition) {
        return new TileEntity(method("getTileEntity", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle()));
    }

    @Override
    public IBlockData getType(BlockPosition blockPosition) {
        return IBlockData.getInstance(getTypeRaw(blockPosition));
    }

    public Object getTypeRaw(BlockPosition blockPosition) {
        return method("getType", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle());
    }

    @Override
    public boolean isEmpty(BlockPosition blockPosition) {
        return (boolean) method("isEmpty", BlockPosition.CLASS).invokeObj(getHandle(), blockPosition.getHandle());
    }

    @Override
    public int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection) {
        return (int) method("getBlockPower", BlockPosition.CLASS, EnumDirection.CLASS)
                .invokeObj(getHandle(), blockPosition.getHandle(), enumDirection.getHandle());
    }

    @Override
    public void a(String var1, long var2) {
        invoke("a", var1, var2);
    }
}
