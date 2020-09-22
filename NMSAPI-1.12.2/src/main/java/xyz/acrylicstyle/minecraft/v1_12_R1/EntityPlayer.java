package xyz.acrylicstyle.minecraft.v1_12_R1;

import com.google.common.collect.Lists;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.Ref;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.craftbukkit.v1_12_R1.CraftUtils;
import xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.nmsapi.abstracts.minecraft.Entity;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@SuppressWarnings("unused")
public class EntityPlayer extends EntityHuman implements xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityPlayer {
    public static final Class<?> CLASS = getClassWithoutException("EntityPlayer");
    public PlayerConnection playerConnection;
    public int ping = -1;
    public final MinecraftServer server;
    public List<Integer> removeQueue = Lists.newLinkedList();
    public String locale = "en_us";
    public int invulnerableTicks = 60;
    public String displayName = "";
    public long timeOffset;
    public boolean relativeTime;
    public float pluginRainPosition;
    public float pluginRainPositionPrevious;
    public Location compassTarget = null;
    public boolean viewingCredits;
    public boolean joining;
    public double maxHealthCache;
    public boolean keepLevel;
    public int newExp = 0;
    public int newLevel = 0;
    public int newTotalExp = 0;
    public int containerCounter;

    public EntityPlayer(Object o) {
        super(o, "EntityPlayer");
        this.playerConnection = new PlayerConnection(this);
        this.server = MinecraftServer.getMinecraftServer(getField("server"));
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

    @SuppressWarnings("deprecation")
    @Override
    public void attack(Entity entity) {
        Ref.getClass(CLASS).getMethod("attack", Entity.CLASS).invokeObj(this.getHandle(), entity.getHandle());
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
    public void updateAbilities() {
        invoke("updateAbilities");
    }

    @Override
    public boolean isSpectator() {
        return (boolean) invoke("isSpectator");
    }

    @Override
    public @NotNull String getIP() {
        return (String) invoke("A");
    }

    @Override
    public void setResourcePack(String url, String hash) {
        invoke("setResourcePack", url, hash);
    }

    @Override
    public void resetIdleTimer() {
        invoke("resetIdleTimer");
    }

    @Override
    public long getLastActiveTime() { return field("cn"); }

    @Override
    public long getPlayerTime() {
        return (long) invoke("getPlayerTime");
    }

    @Override
    public @Nullable WeatherType getPlayerWeather() {
        return (WeatherType) invoke("getPlayerWeather");
    }

    public void setPlayerWeather(WeatherType type, boolean plugin) {
        invoke("setPlayerWeather", type, plugin);
    }

    public @NotNull GameProfile getProfile() {
        return new GameProfile(invoke("getProfile"));
    }

    public void die() {
        invoke("die");
    }

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
            f.set(getHandle(), profile.getGameProfile());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public @NotNull String getLocale() {
        return (String) getField("locale");
    }

    public int getPing() {
        return (int) getField("ping");
    }

    @Override
    public void setPing(int ping) {
        setField("ping", ping);
    }

    @SuppressWarnings("unchecked")
    public List<Integer> getRemoveQueue() {
        return (List<Integer>) getField("removeQueue");
    }

    public int getLastSentExp() {
        return (int) getField("lastSentExp");
    }

    public int getInvulnerableTicks() {
        return (int) getField("invulnerableTicks");
    }

    @Override
    public void setInvulnerableTicks(int ticks) {
        setField("invulnerableTicks", ticks);
    }

    public boolean getViewingCredits() {
        return (boolean) getField("viewingCredits");
    }

    public @NotNull String getDisplayName() {
        return (String) getField("displayName");
    }

    @Override
    public void setDisplayName(@NotNull String displayName) {
        setField("displayName", displayName);
    }

    public Location getCompassTarget() {
        return (Location) getField("compassTarget");
    }

    @Override
    public void setCompassTarget(@Nullable Location location) {
        setField("compassTarget", location);
    }

    public boolean getKeepLevel() {
        return (boolean) getField("keepLevel");
    }

    public double getMaxHealthCache() {
        return (double) getField("maxHealthCache");
    }

    public boolean getJoining() {
        return (boolean) getField("joining");
    }

    public boolean getRelativeTime() {
        return (boolean) getField("relativeTime");
    }

    public float getPluginRainPosition() {
        return (float) getField("pluginRainPosition");
    }

    public float getPluginRainPositionPrevious() {
        return (float) getField("pluginRainPositionPrevious");
    }

    public @NotNull CraftPlayer getBukkitEntity() {
        return new CraftPlayer(invoke("getBukkitEntity", getHandle()));
    }
}
