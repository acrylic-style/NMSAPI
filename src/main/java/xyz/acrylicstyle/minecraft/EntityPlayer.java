package xyz.acrylicstyle.minecraft;

import com.google.common.collect.Lists;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.craftbukkit.CraftPlayer;
import xyz.acrylicstyle.craftbukkit.CraftUtils;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@SuppressWarnings("unused")
public class EntityPlayer {
    private static boolean doPolling = false;
    private boolean disposed = false;
    private Plugin plugin = null;
    private Object o;
    public PlayerConnection playerConnection;
    public int ping = -1;
    public final MinecraftServer server = MinecraftServer.getMinecraftServer(getField("server"));
    public List<Integer> removeQueue = Lists.newLinkedList();
    public String locale = "en_us";
    public int invulnerableTicks = 60;
    public String displayName = "";
    public long timeOffset;
    public boolean relativeTime;
    public float pluginRainPosition;
    public float pluginRainPositionPrevious;
    public Location compassTarget = null;
    public Integer clientViewDistance = 0;
    public boolean viewingCredits;
    public boolean sentListPacket;
    public boolean joining;
    public double maxHealthCache;
    public boolean keepLevel;
    public int newExp = 0;
    public int newLevel = 0;
    public int newTotalExp = 0;
    public boolean e;
    public int containerCounter;
    public int cp;
    public boolean cq;
    public boolean cm;
    public boolean ci = true;

    public EntityPlayer(Object o) {
        this.o = o;
        this.playerConnection = new PlayerConnection(this);
    }

    public void reset() {
        invoke("reset");
    }

    /**
     * @implNote Original method name: getScoreboard()
     */
    public Object getPlayerScoreboard() {
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
        return new GameProfile(invoke("bT"));
    }

    // NMSAPI start
    public EntityPlayer setPlugin(Plugin plugin) {
        this.plugin = plugin;
        return this;
    }

    public static EntityPlayer fromCraftPlayer(CraftPlayer player) {
        return new EntityPlayer(player);
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
                    EntityPlayer.this.clientViewDistance = getClientViewDistance();
                    EntityPlayer.this.viewingCredits = getViewingCredits();
                    EntityPlayer.this.sentListPacket = getSentListPacket();
                    EntityPlayer.this.joining = getJoining();
                    EntityPlayer.this.maxHealthCache = getMaxHealthCache();
                    EntityPlayer.this.keepLevel = getKeepLevel();
                    EntityPlayer.this.newExp = (int) getField("newExp");
                    EntityPlayer.this.newLevel = (int) getField("newLevel");
                    EntityPlayer.this.newTotalExp = (int) getField("newTotalExp");
                    EntityPlayer.this.e = getE();
                    EntityPlayer.this.containerCounter = (int) getField("containerCounter");
                    EntityPlayer.this.cp = (int) getField("cp");
                    EntityPlayer.this.cq = (boolean) getField("cq");
                    EntityPlayer.this.cm = (boolean) getField("cm");
                    EntityPlayer.this.ci = (boolean) getField("ci");
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
            return CraftUtils.getHandle(o).getClass().getCanonicalName().startsWith("org.bukkit.craftbukkit") ? CraftUtils.getHandle(o) : null;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
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

    public boolean getE() {
        return (boolean) getField("e");
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

    public boolean getSentListPacket() {
        return (boolean) getField("sentListPacket");
    }

    public Integer getClientViewDistance() {
        return (Integer) getField("clientViewDistance");
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

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("EntityPlayer"), getEntityPlayer(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("EntityPlayer")
                    .getMethod(method)
                    .invoke(getEntityPlayer());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("EntityPlayer")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getEntityPlayer(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end

    public CraftPlayer getBukkitEntity() {
        try {
            return new CraftPlayer(invoke("getBukkitEntity", getEntityPlayer()));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
