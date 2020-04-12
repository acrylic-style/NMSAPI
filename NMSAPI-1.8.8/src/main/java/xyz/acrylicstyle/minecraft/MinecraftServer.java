package xyz.acrylicstyle.minecraft;

import com.google.gson.JsonElement;
import org.bukkit.WorldType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.CraftUtils;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.Proxy;
import java.nio.file.Path;
import java.security.KeyPair;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;

@SuppressWarnings("unused")
public class MinecraftServer extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("MinecraftServer");

    public void convertWorld(String s) {
        invoke("convertWorld", s);
    }

    public void a(String s, String s1, long i, WorldType worldtype, JsonElement jsonelement) {
        invoke("a", s, s1, i, worldtype, jsonelement);
    }

    public void close() {
        invoke("close");
    }

    public boolean hasStopped() {
        return (boolean) invoke("hasStopped");
    }

    public void stop() {
        invoke("stop");
    }

    /**
     * @implNote Original Method name: MinecraftServer#b(String)
     */
    public void setServerIp(String s) {
        try {
            ReflectionHelper.setField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), "serverIp", s);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning() {
        return getIsRunning();
    }

    public void safeShutdown(boolean flag) {
        invoke("safeShutdown", flag);
    }

    public static double calcTps(double avg, double exp, double tps) {
        return avg * exp + tps * (1.0D - exp);
    }

    public void run() {
        invoke("run");
    }

    public boolean canSleepForTick() {
        return (boolean) invoke("canSleepForTick");
    }

    public void executeModerately() {
        invoke("executeModerately");
    }

    public void sleepForTick() {
        invoke("sleepForTick");
    }

    /**
     * @implNote Actual type is TickTask.
     */
    public Object postToMainThread(Runnable runnable) {
        return invoke("postToMainThread", runnable);
    }

    public boolean executeNext() {
        return (boolean) invoke("executeNext");
    }

    public boolean ba() {
        return (boolean) invoke("ba");
    }

    public File z() {
        return (File) invoke("z");
    }

    public void exit() {
        invoke("exit");
    }

    public void a(BooleanSupplier booleanSupplier) {
        invoke("a", booleanSupplier);
    }

    public void b(BooleanSupplier booleanSupplier) {
        invoke("b", booleanSupplier);
    }

    public boolean getAllowNether() {
        return (boolean) invoke("getAllowNether");
    }

    public void b(Runnable runnable) {
        invoke("b", runnable);
    }

    public static void main() {
        main(null);
    }

    public static void main(Object optionSet) {
        try {
            ReflectionUtil
                    .getNMSClass("MinecraftServer")
                    .getMethod("main", Class.forName("joptsimple.OptionSet"))
                    .invoke(null, optionSet);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void c(String s) {
        try {
            ReflectionHelper.setField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), "ax", s);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setForceUpgrade(boolean flag) {
        try {
            ReflectionHelper.setField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), "forceUpgrade", flag);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setEraseCache(boolean flag) {
        try {
            ReflectionHelper.setField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), "eraseCache", flag);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startServerThread() {
        invoke("startServerThread");
    }

    public File d(String s) {
        return (File) invoke("d", s);
    }

    public void info(String s) {
        invoke("info", s);
    }

    public void warning(String s) {
        invoke("warning", s);
    }

    public String getVersion() {
        return (String) invoke("getVersion");
    }

    public int getPlayerCount() {
        return (int) invoke("getPlayerCount");
    }

    public int getMaxPlayers() {
        return (int) invoke("getMaxPlayers");
    }

    public String[] getPlayers() {
        return (String[]) invoke("getPlayers");
    }

    public boolean isDebugging() {
        return (boolean) invoke("isDebugging");
    }

    public void g(String s) {
        invoke("g", s);
    }

    public void error(String s) {
        g(s);
    }

    public void h(String s) {
        invoke("h", s);
    }

    public String getServerModName() {
        return (String) invoke("getServerModName");
    }

    public int getPort() {
        return getServerPort();
    }

    public void setPort(int i) {
        try {
            ReflectionHelper.setField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), "serverPort", i);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getSinglePlayerName() {
        return getJ();
    }

    public void i(String s) {
        try {
            ReflectionHelper.setField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), "J", s);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isEmbeddedServer() {
        return (getJ() != null);
    }

    public String getWorld() {
        return getK();
    }

    public void a(KeyPair keyPair) {
        try {
            ReflectionHelper.setField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), "I", keyPair);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void d(boolean flag) {
        invoke("d", flag);
    }

    public void a(EntityPlayer entityPlayer) {
        invoke("a", entityPlayer.getNMSClass());
    }

    public boolean getSpawnMonsters() {
        return (boolean) invoke("getSpawnMonsters");
    }

    public boolean isDemoMode() {
        return demoMode();
    }

    public void e(boolean flag) {
        invoke("e", flag);
    }

    public void f(boolean flag) {
        invoke("f", flag);
    }

    public void setDemoMode(boolean flag) {
        e(flag);
    }

    public void setBonusChest(boolean flag) {
        f(flag);
    }

    public String getResourcePack() {
        return getO();
    }

    public String getResourcePackHash() {
        return getP();
    }

    public void setResourcePack(String url, String hash) {
        invoke("setResourcePack", url, hash);
    }

    public boolean getOnlineMode() {
        return isOnlineMode();
    }

    public boolean Y() {
        return getA();
    }

    public void h(boolean flag) {
        invoke("h", flag);
    }

    public boolean getSpawnAnimals() {
        return (boolean) getField("spawnAnimals");
    }

    public void setOnlineMode(boolean flag) {
        invoke("setOnlineMode", flag);
    }

    public void setSpawnAnimals(boolean flag) {
        invoke("setSpawnAnimals", flag);
    }

    public boolean getSpawnNPCs() {
        return (boolean) getField("spawnNPCs");
    }

    public void setSpawnNPCs(boolean flag) {
        invoke("setSpawnNPCs", flag);
    }

    public boolean getPVP() {
        return getPvPMode();
    }

    public void setPVP(boolean flag) {
        invoke("setPVP", flag);
    }

    public boolean getAllowFlight() {
        return (boolean) getField("allowFlight");
    }

    public void setAllowFlight(boolean flag) {
        invoke("setAllowFlight", flag);
    }

    @Nullable
    public String getMotd() {
        return (String) getField("motd");
    }

    public void setMotd(String s) {
        invoke("setMotd", s);
    }

    public int getMaxBuildHeight() {
        return getG();
    }

    public void b(int i) {
        invoke("b", i);
    }

    public boolean isStopped() {
        return (boolean) getField("isStopped");
    }

    /**
     * @implNote Actual return type is PlayerList.
     */
    public Object getPlayerList() {
        return invoke("getPlayerList");
    }

    public void a(Object playerList) {
        try {
            ReflectionUtil
                    .getNMSClass("MinecraftServer")
                    .getMethod("playerList", ReflectionUtil.getNMSClass("PlayerList"))
                    .invoke(o, playerList);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setPlayerList(Object playerList) { a(playerList); }

    public void setGamemode(EnumGamemode enumGamemode) {
        try {
            ReflectionUtil
                    .getNMSClass("MinecraftServer")
                    .getMethod("setGamemode", ReflectionUtil.getNMSClass("EnumGamemode"))
                    .invoke(o, enumGamemode.toNMSEnumGamemode());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public Object getServerConnection() {
        return invoke("getServerConnection");
    }

    public boolean aj() {
        return (boolean) invoke("aj");
    }

    public int ak() {
        return getTicks();
    }

    public void al() {
        invoke("al");
    }

    public int getSpawnProtection() {
        return (int) invoke("getSpawnProtection");
    }

    public void setForceGamemode(boolean flag) {
        invoke("setForceGamemode", flag);
    }

    public boolean getForceGamemode() {
        return getU();
    }

    public int getIdleTimeout() {
        return getH();
    }

    public void setIdleTimeout(int i) {
        invoke("setIdleTimeout", i);
    }

    public Object getMinecraftSessionService() {
        return invoke("getMinecraftSessionService");
    }

    public Object getGameProfileRepository() {
        return getField("gameProfileRepository");
    }

    public Object getUserCache() {
        return getField("userCache");
    }

    public Object getServerPing() {
        return getField("serverPing");
    }

    public void invalidatePingSample() {
        invoke("invalidatePingSample");
    }

    public int ax() {
        return (int) invoke("ax");
    }

    public boolean isNotMainThread() {
        return (boolean) invoke("isNotMainThread");
    }

    public Thread getThread() {
        return getServerThread();
    }

    public int aA() {
        return (int) invoke("aA");
    }

    public long aB() {
        return getNextTick();
    }

    public Object aC() {
        return getField("dataConverterManager");
    }

    /**
     * @apiNote Original method name: MinecraftServer#a(WorldServer)
     */
    public int getSpawnRadius(@Nullable Object worldServer) {
        try {
            return (int) ReflectionUtil
                    .getNMSClass("MinecraftServer")
                    .getMethod("a", ReflectionUtil.getNMSClass("WorldServer"))
                    .invoke(o, worldServer);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Object getAdvancementData() {
        return getField("advancementDataWorld");
    }

    public Object getFunctionData() {
        return getField("customFunctionData");
    }

    public void reload() {
        invoke("reload");
    }

    public void b(Object worldData) {
        try {
            ReflectionUtil
                    .getNMSClass("MinecraftServer")
                    .getMethod("b", ReflectionUtil.getNMSClass("WorldData"))
                    .invoke(o, worldData);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @apiNote Original method name: MinecraftServer#a(CommandListenerWrapper)
     */
    public void checkWhitelist(Object commandListenerWrapper) {
        try {
            ReflectionUtil
                    .getNMSClass("MinecraftServer")
                    .getMethod("a", ReflectionUtil.getNMSClass("CommandListenerWrapper"))
                    .invoke(o, commandListenerWrapper);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object getResourceManager() {
        return getField("ae");
    }

    // public ResourcePackRepository<ResourcePackLoader> getResourcePackRepository()

    public Object getCommandDispatcher() {
        return getField("commandDispatcher");
    }

    /**
     * @implNote Actual return type is nms.CommandListenerWrapper
     */
    public Object getServerCommandListener() {
        return invoke("getServerCommandListener");
    }

    public boolean shouldSendSuccess() {
        return (boolean) invoke("shouldSendSuccess");
    }

    public boolean shouldSendFailure() {
        return (boolean) invoke("shouldSendFailure");
    }

    /**
     * @implNote Actual return type is nms.CraftingManager
     */
    public Object getCraftingManager() {
        return getField("getCraftingManager");
    }

    /**
     * @implNote Actual return type is nms.TagRegistry
     */
    public Object getTagRegistry() {
        return getField("tagRegistry");
    }

    /**
     * @implNote Actual return type is nms.ScoreboardServer
     */
    public Object getScoreboard() {
        return getField("scoreboardServer");
    }

    /**
     * @implNote Actual return type is PersistentCommandStorage
     */
    public Object aO() {
        return invoke("aO");
    }

    /**
     * Alias for {@link MinecraftServer#aO()}.
     */
    public Object getPersistentCommandStorage() {
        return aO();
    }

    /**
     * @implNote Actual return type is LootTableRegistry
     */
    public Object getLootTableRegistry() {
        return getField("lootTableRegistry");
    }

    /**
     * @implNote Actual return type is LootPredicateManager
     */
    public Object aQ() {
        return getField("lootPredicateManager");
    }

    /**
     * Alias for {@link MinecraftServer#aQ()}.
     */
    public Object getLootPredicateManager() {
        return aQ();
    }

    /**
     * @implNote Actual return type is nms.GameRules (not x.a.m.GameRules)
     */
    public Object getGameRules() {
        return invoke("getGameRules");
    }

    /**
     * @implNote Actual return type is nms.BossBattleCustomData
     */
    public Object getBossBattleCustomData() {
        return getField("bossBattleCustomData");
    }

    public boolean aT() {
        return getAs();
    }

    public void n(boolean flag) {
        invoke("n", flag);
    }

    public float aU() {
        return getAv();
    }

    public int b(GameProfile gameProfile) {
        return (int) invoke("b", gameProfile.getGameProfile());
    }

    /**
     * @implNote Actual return type is nms.GameProfiler
     */
    public Object getMethodProfiler() {
        return getField("methodProfiler");
    }

    public Executor aX() {
        return getExecutorService();
    }

    public void a(Path java_nio_file_path) {
        invoke("a", java_nio_file_path);
    }

    public void b(Path java_nio_file_path) {
        invoke("b", java_nio_file_path);
    }

    public void c(Path java_nio_file_path) {
        invoke("c", java_nio_file_path);
    }

    public void d(Path java_nio_file_path) {
        invoke("d", java_nio_file_path);
    }

    public void e(Path java_nio_file_path) {
        invoke("e", java_nio_file_path);
    }

    public void f(Path java_nio_file_path) {
        invoke("f", java_nio_file_path);
    }

    public void bb() {
        invoke("bb");
    }

    public boolean isMainThread() {
        return (boolean) invoke("isMainThread");
    }

    public MinecraftServer(Object o) {
        super(o, "MinecraftServer");
    }

    public CollectionList<String> getPlayersList() {
        return ICollectionList.asList(getPlayers());
    }

    public int getServerPort() {
        return (int) getField("serverPort");
    }

    public boolean isOnlineMode() {
        return (boolean) getField("onlineMode");
    }

    public boolean getA() {
        return (boolean) getField("A");
    }

    public boolean getPvPMode() {
        return (boolean) getField("pvpMode");
    }

    public int getTicks() {
        return (int) getField("ticks");
    }

    public boolean getIsRunning() {
        return (boolean) getField("isRunning");
    }

    public String getServerIp() {
        return (String) getField("serverIp");
    }

    public Random getQ() {
        return (Random) getField("q");
    }

    public Proxy getProxy() {
        return (Proxy) getField("proxy");
    }

    public int getG() {
        return (int) getField("G");
    }

    public int getH() {
        return (int) getField("H");
    }

    public long[] getF() {
        return (long[]) getField("f");
    }

    @Nullable
    public KeyPair getI() {
        return (KeyPair) getField("I");
    }

    @Nullable
    public String getJ() {
        return (String) getField("J");
    }

    public String getK() {
        return (String) getField("K");
    }

    public boolean demoMode() {
        return (boolean) getField("demoMode");
    }

    public boolean bonusChest() {
        return (boolean) getField("bonusChest");
    }

    public String getO() {
        return (String) getField("O");
    }

    public String getP() {
        return (String) getField("P");
    }

    public boolean hasTicked() {
        return (boolean) getField("hasTicked");
    }

    public long getLastOverloadTime() {
        return (long) getField("lastOverloadTime");
    }

    /**
     * @implNote Actual type is IChatBaseComponent.
     */
    public Object getS() {
        return getField("S");
    }

    public boolean getT() {
        return (boolean) getField("T");
    }

    public boolean getU() {
        return (boolean) getField("U");
    }

    public long getZ() {
        return (long) getField("Z");
    }

    public Thread getServerThread() {
        return (Thread) getField("serverThread");
    }

    public long getNextTick() {
        return (long) getField("nextTick");
    }

    public long getAb() {
        return (long) getField("ab");
    }

    public boolean getAc() {
        return (boolean) getField("ac");
    }

    public boolean getAs() {
        return (boolean) getField("as");
    }

    public boolean getForceUpgrade() {
        return (boolean) getField("forceUpgrade");
    }

    public boolean getEraseCache() {
        return (boolean) getField("eraseCache");
    }

    public float getAv() {
        return (float) getField("av");
    }

    public Executor getExecutorService() {
        return (Executor) getField("executorService");
    }

    @Nullable
    public String getAx() {
        return (String) getField("ax");
    }

    /**
     * @implNote Actual type is CraftServer.
     */
    public Object getServer() {
        return getField("server");
    }

    public ConsoleCommandSender getConsole() {
        return (ConsoleCommandSender) getField("console");
    }

    public RemoteConsoleCommandSender getRemoteConsole() {
        return (RemoteConsoleCommandSender) getField("remoteConsole");
    }

    public static int currentTick = (int) (System.currentTimeMillis() / 50L);

    @SuppressWarnings("unchecked")
    public Queue<Runnable> getProcessQueue() {
        return (Queue<Runnable>) getField("processQueue");
    }

    public int getAutosavePeriod() {
        return (int) getField("autosavePeriod");
    }

    public File getBukkitDataPackFolder() {
        return (File) getField("bukkitDataPackFolder");
    }

    /**
     * @implNote Actual type is CommandDispatcher.
     */
    public Object getVanillaCommandDispatcher() {
        return getField("vanillaCommandDispatcher");
    }

    /**
     * @return usercache.json file
     */
    public File getB() {
        return (File) getField("b");
    }

    public boolean getForceTicks() {
        return (boolean) getField("forceTicks");
    }

    public static final int TPS = 20;
    public static final int TICK_TIME = 50000000;
    private static final int SAMPLE_INTERVAL = 100;

    public double[] getRecentTps() {
        return (double[]) getField("recentTps");
    }

    public boolean getHasStopped() {
        return (boolean) getField("hasStopped");
    }

    public Object stopLock() {
        return getField("stopLock");
    }

    public static MinecraftServer getMinecraftServer(Object o) {
        return new MinecraftServer(o);
    }

    public Object getMinecraftServer() {
        if (o.getClass().getSimpleName().equals("MinecraftServer") || o.getClass().getSimpleName().equals("DedicatedServer")) return o;
        try {
            return CraftUtils.getHandle(o);
        } catch (NoSuchMethodException e1) {
            try {
                return o.getClass().getDeclaredField("minecraftServer").get(o);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                try {
                    return o.getClass().getDeclaredField("server").get(o);
                } catch (IllegalAccessException | NoSuchFieldException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
        } catch (InvocationTargetException | IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("MinecraftServer"), getMinecraftServer(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("MinecraftServer")
                    .getMethod(method)
                    .invoke(getMinecraftServer());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("MinecraftServer")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getMinecraftServer(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
