package xyz.acrylicstyle.minecraft;

import com.google.common.util.concurrent.ListenableFuture;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.generator.ChunkGenerator;
import util.ICollectionList;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public class WorldServer extends World implements IAsyncTaskHandler {
    public WorldServer(Object o) {
        super(o, "WorldServer");
        this.server = new MinecraftServer(getField("server"));
    }

    public final MinecraftServer server;

    public Object chunkProviderServer; // todo: create ChunkProviderServer

    public final int dimension = field("dimension");

    public WorldServer(MinecraftServer minecraftServer, IDataManager iDataManager, WorldData worldData, int i, MethodProfiler methodProfiler, org.bukkit.World.Environment environment, ChunkGenerator gen) {
        super("WorldServer", minecraftServer.getHandle(), iDataManager.getHandle(), worldData.getHandle(), i, methodProfiler.getHandle(), environment, gen);
        this.server = minecraftServer;
    }

    public World b() {
        return World.newInstance(invoke("b"));
    }

    public TileEntity getTileEntity(BlockPosition pos) {
        return new TileEntity(invoke("getTileEntity", pos.getHandle()));
    }

    @Override
    public IBlockData getType(BlockPosition blockPosition) {
        throw new UnsupportedOperationException();
        // return invoke("getType", blockPosition.getHandle());
    }

    @Override
    public boolean isEmpty(BlockPosition blockPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection) {
        throw new UnsupportedOperationException();
    }

    public void doTick() {
        invoke("doTick");
    }

    // todo: create EnumCreatureType
    // todo: create BiomeBase (BiomeBase.BiomeMeta)
    public Object a(Object paramEnumCreatureType, BlockPosition blockPosition) {
        return invoke("a", paramEnumCreatureType, blockPosition.getHandle());
    }

    public boolean a(Object paramEnumCreatureType, Object biomeMeta, BlockPosition pos) {
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

    protected BlockPosition a(BlockPosition blockPosition) {
        return new BlockPosition(invoke("a", blockPosition.getHandle()));
    }

    // todo: create Block
    public boolean a(BlockPosition blockPosition, Object block) {
        return (boolean) invoke("a", blockPosition.getHandle(), block);
    }

    public void a(BlockPosition blockPosition, Object block, int i) {
        invoke("a", blockPosition.getHandle(), block, i);
    }

    public void a(BlockPosition blockPosition, Object block, int i, int j) {
        invoke("a", blockPosition.getHandle(), block, i, j);
    }

    public void b(BlockPosition blockPosition, Object block, int i, int j) {
        invoke("b", blockPosition.getHandle(), block, i, j);
    }

    public void tickEntities() {
        invoke("tickEntities");
    }

    public void j() {
        invoke("j");
    }

    public boolean a(boolean flag) {
        return (boolean) invoke1("a", boolean.class, flag);
    }

    // todo: create Chunk
    @SuppressWarnings("Convert2MethodRef")
    public List<NextTickListEntity> a(Object chunk, boolean flag) {
        return ICollectionList.asList((List<?>) invoke("a", chunk, flag)).map(o -> new NextTickListEntity(o));
    }

    // todo: create Chunk
    @SuppressWarnings("Convert2MethodRef")
    public List<NextTickListEntity> a2(Object structureBoundingBox, boolean flag) {
        return ICollectionList.asList((List<?>) invoke("a", structureBoundingBox, flag)).map(o -> new NextTickListEntity(o));
    }

    // todo: create IChunkProvider
    protected Object k() {
        return invoke("k");
    }

    public List<TileEntity> getTileEntities(int i, int k, int j, int l, int i1, int j1) {
        return ICollectionList.asList((List<?>) invoke("getTileEntities", i, k, j, l, i1, j1)).map(TileEntity::new);
    }

    public boolean a2(Object entityHuman, BlockPosition blockPosition) {
        return (boolean) invoke("a", entityHuman, blockPosition.getHandle());
    }

    public void a(WorldSettings worldSettings) {
        invoke("a", worldSettings.getHandle());
    }

    protected void l() {
        invoke("l");
    }

    public BlockPosition getDimensionSpawn() {
        return new BlockPosition(invoke("getDimensionSpawn"));
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

    protected void b(Entity entity) {
        invoke1("b", Entity.CLASS, entity.getHandle());
    }

    public boolean strikeLightning(Entity entity) {
        return (boolean) invoke1("strikeLightning", Entity.CLASS, entity.getHandle());
    }

    public void broadcastEntityEffect(Entity entity, byte b0) {
        invoke1("broadcastEntityEffect", Entity.CLASS, byte.class, entity.getHandle(), b0);
    }

    public Object createExplosion(Entity entity, double d0, double d1, double d2, float f, boolean flag, boolean flag1) {
        throw new NotImplementedException(); // todo
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

    public MinecraftServer getMinecraftServer() {
        return new MinecraftServer(getField("server"));
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

    public Entity getEntity(UUID uuid) {
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
