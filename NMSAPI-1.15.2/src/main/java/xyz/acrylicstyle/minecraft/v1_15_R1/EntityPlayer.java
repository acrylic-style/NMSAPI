package xyz.acrylicstyle.minecraft.v1_15_R1;

import com.google.common.collect.Lists;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.jetbrains.annotations.NotNull;
import util.reflect.Ref;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.abstracts.utils.CraftUtils;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class EntityPlayer extends EntityHuman implements ICommandListener, xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityPlayer {
    public static final Class<?> CLASS = getClassWithoutException("EntityPlayer");

    Object __playerConnection;
    public PlayerConnection playerConnection = null;
    public int ping = field("ping");
    public final MinecraftServer server;
    public final PlayerInteractManager playerInteractManager;
    public List<Integer> removeQueue = Lists.newLinkedList();
    public String locale = field("locale");
    public int invulnerableTicks = field("invulnerableTicks");
    public String displayName = field("displayName");
    public Location compassTarget = field("compassTarget");

    public void setCompassTarget(Location compassTarget) {
        setField("compassTarget", compassTarget);
    }

    public void setDisplayName(@NotNull String displayName) {
        setField("displayName", displayName);
    }

    public void setInvulnerableTicks(int ticks) {
        setField("invulnerableTicks", ticks);
    }

    public EntityPlayer(Object o) {
        super(Objects.requireNonNull(o), "EntityPlayer");
        this.__playerConnection = getField("playerConnection");
        if (__playerConnection != null) {
            this.playerConnection = new PlayerConnection(this);
        } else System.err.println("playerConnection field is null.");
        this.playerInteractManager = new PlayerInteractManager(getField("playerInteractManager"));
        this.server = MinecraftServer.getMinecraftServer(getField("server"));
    }

    private static Object call(MinecraftServer minecraftServer, WorldServer worldServer, GameProfile gameProfile, PlayerInteractManager playerInteractManager) {
        try {
            return EntityPlayer.CLASS
                    .getConstructor(MinecraftServer.CLASS, WorldServer.CLASS, Class.forName("com.mojang.authlib.GameProfile"), PlayerInteractManager.CLASS)
                    .newInstance(minecraftServer.getHandle(), worldServer.getHandle(), gameProfile.getHandle(), playerInteractManager.getHandle());
        } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
    }

    public EntityPlayer(MinecraftServer minecraftServer, WorldServer worldServer, GameProfile gameProfile, PlayerInteractManager playerInteractManager) {
        super(call(minecraftServer, worldServer, gameProfile, playerInteractManager), "EntityPlayer");
        if (checkState()) throw new RuntimeException();
        this.__playerConnection = getField("playerConnection");
        if (__playerConnection != null) this.playerConnection = new PlayerConnection(this);
        this.playerInteractManager = new PlayerInteractManager(getField("playerInteractManager"));
        this.server = minecraftServer;
    }

    public void reset() {
        invoke("reset");
    }

    public Object getScoreboard() {
        return CraftUtils.getHandle(getBukkitEntity().getScoreboard());
    }

    public boolean isFrozen() {
        return (boolean) invoke("isFrozen");
    }

    public void resetPlayerWeather() {
        invoke("resetPlayerWeather");
    }

    public void tickWeather() {
        invoke("tickWeather");
    }

    @SuppressWarnings("deprecation")
    @Override
    public void attack(xyz.acrylicstyle.nmsapi.abstracts.minecraft.Entity entity) {
        Ref.getClass(CLASS).getMethod("attach", Entity.CLASS).invokeObj(null, entity.getHandle());
    }

    @Override
    public xyz.acrylicstyle.nmsapi.abstracts.minecraft.@NotNull PlayerConnection getPlayerConnection() {
        return playerConnection;
    }

    public void updateWeather(float oldRain, float newRain, float oldThunder, float newThunder) {
        invoke("updateWeather", oldRain, newRain, oldThunder, newThunder);
    }

    @Override
    public void playerTick() {
        invoke("playerTick");
    }

    @Override
    public boolean canPvP() {
        return (boolean) invoke("canPvP");
    }

    @Override
    public void closeInventory() {
        invoke("closeInventory");
    }

    @Override
    public void setPlayerWeather(WeatherType type, boolean plugin) {
        invoke("setPlayerWeather", type, plugin);
    }

    @Override
    public @NotNull GameProfile getProfile() {
        return new GameProfile(invoke("getProfile"));
    }

    @Override
    public void die() {
        invoke("die");
    }

    @Override
    public void setProfile(@NotNull GameProfile profile) {
        Field f;
        try {
            f = ReflectionUtil.getNMSClass("EntityPlayer").getSuperclass().getDeclaredField("bH");
        } catch (NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        f.setAccessible(true);
        try {
            f.set(getNMSClass(), profile.getGameProfile());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public @NotNull String getLocale() {
        return field("locale");
    }

    public int getPing() {
        return field("ping");
    }

    @Override
    public void setPing(int ping) {
        setField("ping", ping);
    }

    public List<Integer> getRemoveQueue() {
        return field("removeQueue");
    }

    public int getLastSentExp() {
        return field("lastSentExp");
    }

    public int getInvulnerableTicks() {
        return field("invulnerableTicks");
    }

    public boolean getViewingCredits() {
        return field("viewingCredits");
    }

    public @NotNull String getDisplayName() {
        return field("displayName");
    }

    public Location getCompassTarget() {
        return field("compassTarget");
    }

    public boolean getKeepLevel() {
        return field("keepLevel");
    }

    public double getMaxHealthCache() {
        return field("maxHealthCache");
    }

    public boolean getJoining() {
        return field("joining");
    }

    public boolean getRelativeTime() {
        return field("relativeTime");
    }

    public float getPluginRainPosition() {
        return field("pluginRainPosition");
    }

    public float getPluginRainPositionPrevious() {
        return field("pluginRainPositionPrevious");
    }

    public @NotNull CraftPlayer getBukkitEntity() {
        return new CraftPlayer(invoke("getBukkitEntity", getNMSClass()));
    }

    @Override
    public @NotNull String getName() {
        return getDisplayName();
    }

    @Override
    public IChatBaseComponent getScoreboardDisplayName() {
        return new xyz.acrylicstyle.minecraft.v1_15_R1.ChatComponentText(getDisplayName());
    }

    @Override
    public boolean a(int paramInt, String paramString) {
        return (boolean) invoke("a", paramInt, paramString);
    }

    @Override
    public xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition getChunkCoordinates() {
        return new BlockPosition(invoke("getChunkCoordinates"));
    }

    @Override
    public Vec3D d() {
        return new Vec3D(invoke("d"));
    }

    @Override
    public World getWorld() {
        return World.newInstance(invoke("getWorld"));
    }

    @Override
    public Entity f() {
        return new Entity(invoke("f"));
    }

    @Override
    public boolean getSendCommandFeedback() {
        return (boolean) invoke("getSendCommandFeedback");
    }

    @Override
    public void a(Object paramEnumCommandResult, int paramInt) {
        invoke("a", paramEnumCommandResult, paramInt);
    }

    public void updateAbilities() {
        invoke("updateAbilities");
    }

    public WorldServer u() {
        return new WorldServer(invoke("u"));
    }

    @SuppressWarnings("deprecation")
    public void a(WorldSettings.EnumGamemode enumGameMode) {
        getBukkitEntity().setGameMode(Objects.requireNonNull(GameMode.getByValue(enumGameMode.getId())));
    }

    public boolean isSpectator() {
        return (boolean) invoke("isSpectator");
    }

    @Override
    public @NotNull String getIP() {
        return (String) invoke("v");
    }

    @Override
    public void setResourcePack(String url, String hash) {
        invoke("setResourcePack", url, hash);
    }

    public void resetIdleTimer() {
        invoke("resetIdleTimer");
    }

    @SuppressWarnings("deprecation")
    public void d(Entity entity) {
        method("d", Entity.CLASS).invokeObj(getHandle(), entity);
    }

    protected void B() {
        invoke("B");
    }

    public Entity C() {
        return new Entity(invoke("C"));
    }

    @SuppressWarnings("deprecation")
    public void setSpectatorTarget(Entity entity) {
        method("setSpectatorTarget", Entity.CLASS).invokeObj(getHandle(), entity);
    }

    public long D() {
        return (long) invoke("D");
    }

    public IChatBaseComponent getPlayerListName() {
        return new ChatComponentText(invoke("getPlayerListName"));
    }

    @Override
    public long getPlayerTime() {
        return (long) invoke("getPlayerTime");
    }

    @Override
    public WeatherType getPlayerWeather() {
        return (WeatherType) invoke("getPlayerWeather");
    }

    public void sendMessage(IChatBaseComponent[] iChatBaseComponents) {
        IChatBaseComponent[] arrayOfIChatBaseComponent;
        int i;
        byte b;
        for (i = (arrayOfIChatBaseComponent = iChatBaseComponents).length, b = 0; b < i; ) {
            IChatBaseComponent component = arrayOfIChatBaseComponent[b];
            sendMessage(component);
            b++;
        }
    }
}
