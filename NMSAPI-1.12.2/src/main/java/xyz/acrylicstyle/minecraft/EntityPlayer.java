package xyz.acrylicstyle.minecraft;

import com.google.common.collect.Lists;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.craftbukkit.CraftPlayer;
import xyz.acrylicstyle.craftbukkit.CraftUtils;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@SuppressWarnings("unused")
public class EntityPlayer extends EntityLiving {
    private boolean disposed = false;
    private Plugin plugin = null;
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
            f.set(getEntityPlayer(), profile.getGameProfile());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public EntityPlayer setPlugin(Plugin plugin) {
        this.plugin = plugin;
        return this;
    }

    /**
     * Cancel the polling.
     */
    public void cancelPolling() { disposed = true; }

    public void poll() {
        Validate.notNull(plugin, "Plugin cannot be null");
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    if (disposed) this.cancel();
                    EntityPlayer.this.ping = getPing();
                    EntityPlayer.this.removeQueue = getRemoveQueue();
                    EntityPlayer.this.locale = getLocale();
                    EntityPlayer.this.invulnerableTicks = getInvulnerableTicks();
                    EntityPlayer.this.displayName = getDisplayName();
                    EntityPlayer.this.timeOffset = (long) getField("timeOffset");
                    EntityPlayer.this.relativeTime = getRelativeTime();
                    EntityPlayer.this.pluginRainPosition = getPluginRainPosition();
                    EntityPlayer.this.pluginRainPositionPrevious = getPluginRainPositionPrevious();
                    EntityPlayer.this.compassTarget = getCompassTarget();
                    EntityPlayer.this.viewingCredits = getViewingCredits();
                    EntityPlayer.this.joining = getJoining();
                    EntityPlayer.this.maxHealthCache = getMaxHealthCache();
                    EntityPlayer.this.keepLevel = getKeepLevel();
                    EntityPlayer.this.newExp = (int) getField("newExp");
                    EntityPlayer.this.newLevel = (int) getField("newLevel");
                    EntityPlayer.this.newTotalExp = (int) getField("newTotalExp");
                    EntityPlayer.this.containerCounter = (int) getField("containerCounter");
                } catch (Throwable throwable) {
                    System.out.println("An error occurred while polling data! Cancelling the polling.");
                    throwable.printStackTrace();
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 2);
    }

    public Object getEntityPlayer() {
        try {
            if (o.getClass().getCanonicalName().startsWith("net.minecraft.server") && o.getClass().getCanonicalName().endsWith("EntityPlayer")) return o;
            if (o.getClass().getCanonicalName().startsWith("org.bukkit.craftbukkit") && o.getClass().getCanonicalName().endsWith("CraftPlayer")) return CraftUtils.getHandle(o);
            if (o.getClass().getCanonicalName().equals(CraftPlayer.class.getCanonicalName())) return CraftUtils.getHandle(((CraftPlayer) o).getOBCCraftPlayer());
            return CraftUtils.getHandle(o).getClass().getCanonicalName().startsWith("org.bukkit.craftbukkit") ? CraftUtils.getHandle(o) : null;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getEntityHuman() {
        return getEntityPlayer().getClass().getSuperclass().cast(getEntityPlayer());
    }

    public String getLocale() {
        return (String) getField("locale");
    }

    public int getPing() {
        return (int) getField("ping");
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

    public boolean getViewingCredits() {
        return (boolean) getField("viewingCredits");
    }

    public String getDisplayName() {
        return (String) getField("displayName");
    }

    public Location getCompassTarget() {
        return (Location) getField("compassTarget");
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

    public CraftPlayer getBukkitEntity() {
        return new CraftPlayer(invoke("getBukkitEntity", getEntityPlayer()));
    }
}
