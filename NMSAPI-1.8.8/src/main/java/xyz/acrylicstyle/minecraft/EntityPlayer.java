package xyz.acrylicstyle.minecraft;

import com.google.common.collect.Lists;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.entity.CraftPlayer;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.CraftUtils;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class EntityPlayer extends Entity implements ICommandListener {
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

    public void setDisplayName(String displayName) {
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
        try {
            return CraftUtils.getHandle(getBukkitEntity().getScoreboard());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
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

    public void updateWeather(float oldRain, float newRain, float oldThunder, float newThunder) {
        invoke("updateWeather", oldRain, newRain, oldThunder, newThunder);
    }

    public void setPlayerWeather(WeatherType type, boolean plugin) {
        invoke("setPlayerWeather", type, plugin);
    }

    public GameProfile getProfile() {
        return new GameProfile(invoke("getProfile"));
    }

    public void die() {
        invoke("die");
    }

    // NMSAPI start
    public void setProfile(GameProfile profile) {
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

    public Object getEntityHuman() {
        return getNMSClass().getClass().getSuperclass().cast(getNMSClass());
    }
    // NMSAPI end

    public String getLocale() {
        return field("locale");
    }

    public int getPing() {
        return field("ping");
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

    public String getDisplayName() {
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

    public CraftPlayer getBukkitEntity() {
        return new CraftPlayer(invoke("getBukkitEntity", getNMSClass()));
    }

    @Override
    public String getName() {
        return getDisplayName();
    }

    @Override
    public IChatBaseComponent getScoreboardDisplayName() {
        return new ChatComponentText(getDisplayName());
    }

    @Override
    public boolean a(int paramInt, String paramString) {
        return (boolean) invoke("a", paramInt, paramString);
    }

    @Override
    public BlockPosition getChunkCoordinates() {
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
        getBukkitEntity().setGameMode(GameMode.getByValue(enumGameMode.getId()));
    }

    public boolean isSpectator() {
        return (boolean) invoke("isSpectator");
    }

    public void resetIdleTimer() {
        invoke("resetIdleTimer");
    }

    public void d(Entity entity) {
        invoke1("d", Entity.CLASS, entity);
    }

    protected void B() {
        invoke("B");
    }

    public Entity C() {
        return new Entity(invoke("C"));
    }

    public void setSpectatorTarget(Entity entity) {
        invoke1("setSpectatorTarget", Entity.CLASS, entity);
    }

    public void attack(Entity entity) {
        invoke1("attack", Entity.CLASS, entity);
    }

    public long D() {
        return (long) invoke("D");
    }

    public IChatBaseComponent getPlayerListName() {
        return new ChatComponentText(invoke("getPlayerListName"));
    }

    public long getPlayerTime() {
        return (long) invoke("getPlayerTime");
    }

    public WeatherType getPlayerWeather() {
        return (WeatherType) invoke("getPlayerWeather");
    }

    public void sendMessage(IChatBaseComponent iChatBaseComponent) {
        this.playerConnection.sendPacket(new PacketPlayOutChat(iChatBaseComponent));
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
