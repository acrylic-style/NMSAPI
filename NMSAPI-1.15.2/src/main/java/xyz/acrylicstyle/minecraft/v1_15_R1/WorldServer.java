package xyz.acrylicstyle.minecraft.v1_15_R1;

import com.google.common.util.concurrent.ListenableFuture;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.generator.ChunkGenerator;
import util.ICollectionList;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public class WorldServer extends World implements IAsyncTaskHandler {
    public static final Class<?> CLASS = getClassWithoutException("WorldServer");

    public WorldServer(Object o) {
        super(o, "WorldServer");
        this.server = xyz.acrylicstyle.minecraft.v1_15_R1.MinecraftServer.newInstance(getField("server"));
    }

    public final xyz.acrylicstyle.minecraft.v1_15_R1.MinecraftServer server;

    public Object chunkProviderServer; // todo: create ChunkProviderServer

    public final int dimension = field("dimension");

    public WorldServer(xyz.acrylicstyle.minecraft.v1_15_R1.MinecraftServer minecraftServer, IDataManager iDataManager, WorldData worldData, int i, MethodProfiler methodProfiler, org.bukkit.World.Environment environment, ChunkGenerator gen) {
        super("WorldServer", minecraftServer.getHandle(), iDataManager.getHandle(), worldData.getHandle(), i, methodProfiler.getHandle(), environment, gen);
        this.server = minecraftServer;
    }

    public World b() {
        return World.newInstance(invoke("b"));
    }

    public TileEntity getTileEntity(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition pos) {
        return new TileEntity(invoke("getTileEntity", pos.getHandle()));
    }

    @Override
    public IBlockData getType(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        throw new UnsupportedOperationException();
        // return invoke("getType", blockPosition.getHandle());
    }

    @Override
    public boolean isEmpty(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBlockPower(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition, EnumDirection enumDirection) {
        throw new UnsupportedOperationException();
    }

    public void doTick() {
        invoke("doTick");
    }

    // todo: create EnumCreatureType
    // todo: create BiomeBase (BiomeBase.BiomeMeta)
    public Object a(Object paramEnumCreatureType, xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return invoke("a", paramEnumCreatureType, blockPosition.getHandle());
    }

    public boolean a(Object paramEnumCreatureType, Object biomeMeta, xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition pos) {
        return (boolean) invoke("a", paramEnumCreatureType, biomeMeta, pos.getHandle());
    }

    public void everyoneSleeping() {
        invoke("everyoneSleeping");
    }

    protected void e() {
        invoke("e");
    }

    public void ag() {
        invoke("ag");
    }

    public boolean everyoneDeeplySleeping() {
        return (boolean) invoke("everyoneDeeplySleeping");
    }

    protected void h() {
        invoke("h");
    }

    protected xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition a(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return new xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition(invoke("a", blockPosition.getHandle()));
    }

    // todo: create Block
    public boolean a(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition, Object block) {
        return (boolean) invoke("a", blockPosition.getHandle(), block);
    }

    public void a(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition, Object block, int i) {
        invoke("a", blockPosition.getHandle(), block, i);
    }

    public void a(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition, Object block, int i, int j) {
        invoke("a", blockPosition.getHandle(), block, i, j);
    }

    public void b(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition, Object block, int i, int j) {
        invoke("b", blockPosition.getHandle(), block, i, j);
    }

    public void tickEntities() {
        invoke("tickEntities");
    }

    public void j() {
        invoke("j");
    }

    public boolean a(boolean flag) {
        return (boolean) method("a", boolean.class).invokeObj(getHandle(), flag);
    }

    // todo: create Chunk
    @SuppressWarnings("Convert2MethodRef")
    public List<xyz.acrylicstyle.minecraft.v1_15_R1.NextTickListEntity> a(Object chunk, boolean flag) {
        return ICollectionList.asList((List<?>) invoke("a", chunk, flag)).map(o -> new xyz.acrylicstyle.minecraft.v1_15_R1.NextTickListEntity(o));
    }

    // todo: create Chunk
    @SuppressWarnings("Convert2MethodRef")
    public List<xyz.acrylicstyle.minecraft.v1_15_R1.NextTickListEntity> a2(Object structureBoundingBox, boolean flag) {
        return ICollectionList.asList((List<?>) invoke("a", structureBoundingBox, flag)).map(o -> new NextTickListEntity(o));
    }

    // todo: create IChunkProvider
    protected Object k() {
        return invoke("k");
    }

    public List<TileEntity> getTileEntities(int i, int k, int j, int l, int i1, int j1) {
        return ICollectionList.asList((List<?>) invoke("getTileEntities", i, k, j, l, i1, j1)).map(TileEntity::new);
    }

    public boolean a2(Object entityHuman, xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return (boolean) invoke("a", entityHuman, blockPosition.getHandle());
    }

    public void a(WorldSettings worldSettings) {
        invoke("a", worldSettings.getHandle());
    }

    protected void l() {
        invoke("l");
    }

    public xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition getDimensionSpawn() {
        return new xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition(invoke("getDimensionSpawn"));
    }

    public void save(boolean flag, Object paramIProgressUpdate) {
        invoke("flag", paramIProgressUpdate);
    }

    public void flushSave() {
        invoke("flushSave");
    }

    protected void a() {
        invoke("a");
    }

    protected void b(xyz.acrylicstyle.minecraft.v1_15_R1.Entity entity) {
        method("b", xyz.acrylicstyle.minecraft.v1_15_R1.Entity.CLASS).invokeObj(getHandle(), entity.getHandle());
    }

    public boolean strikeLightning(xyz.acrylicstyle.minecraft.v1_15_R1.Entity entity) {
        return (boolean) method("strikeLightning", xyz.acrylicstyle.minecraft.v1_15_R1.Entity.CLASS).invokeObj(getHandle(), entity.getHandle());
    }

    public void broadcastEntityEffect(xyz.acrylicstyle.minecraft.v1_15_R1.Entity entity, byte b0) {
        method("broadcastEntityEffect", xyz.acrylicstyle.minecraft.v1_15_R1.Entity.CLASS, byte.class).invokeObj(getHandle(), entity.getHandle(), b0);
    }

    public Object createExplosion(xyz.acrylicstyle.minecraft.v1_15_R1.Entity entity, double d0, double d1, double d2, float f, boolean flag, boolean flag1) {
        throw new NotImplementedException(); // todo: create Explosion class
    }

    public void playBlockAction(BlockPosition blockPosition, Object block, int i, int j) {
        invoke("playBlockAction", blockPosition, block, i, j);
    }

    private void ak() {
        invoke("ak");
    }

    public void saveLevel() {
        invoke("saveLevel");
    }

    protected void p() {
        invoke("p");
    }

    protected int q() {
        return (int) invoke("q");
    }

    public xyz.acrylicstyle.minecraft.v1_15_R1.MinecraftServer getMinecraftServer() {
        return MinecraftServer.newInstance(getField("server"));
    }

    // todo: create EntityTracker
    public Object getTracker() {
        return getField("tracker");
    }

    // todo: create PlayerChunkMap
    public Object getPlayerChunkMap() {
        return getField("manager");
    }

    // todo: create PortalTravelAgent
    public Object getTravelAgent() {
        return getField("Q");
    }

    public void a(Object enumParticle, double d0, double d1, double d2, int i, double d3, double d4, double d5, double d6, int... aInt) {
        invoke("a", enumParticle, d0, d1, d2, i, d3, d4, d5, d6, aInt);
    }

    public void a(Object enumParticle, boolean flag, double d0, double d1, double d2, int i, double d3, double d4, double d5, double d6, int... aInt) {
        invoke("a", enumParticle, flag, d0, d1, d2, i, d3, d4, d5, d6, aInt);
    }

    public void sendParticles(EntityPlayer sender, Object enumParticle, boolean flag, double d0, double d1, double d2, int i, double d3, double d4, double d5, double d6, int... aInt) {
        invoke("sendParticles", sender.getHandle(), enumParticle, flag, d0, d1, d2, i, d3, d4, d5, d6, aInt);
    }

    public xyz.acrylicstyle.minecraft.v1_15_R1.Entity getEntity(UUID uuid) {
        return new Entity(invoke("getEntity", uuid));
    }

    @SuppressWarnings("unchecked")
    public ListenableFuture<Object> postToMainThread(Runnable runnable) {
        return (ListenableFuture<Object>) invoke("postToMainThread", runnable);
    }

    public boolean isMainThread() {
        return server.isMainThread();
    }

    /*
    static class BlockActionDataList extends ArrayList<BlockActionData> {
        private BlockActionDataList() {}

        BlockActionDataList(Object object) {
            this();
        }
    }
     */
}
