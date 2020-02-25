package xyz.acrylicstyle.minecraft;

import org.bukkit.Location;
import org.bukkit.WeatherType;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.CraftPlayer;
import xyz.acrylicstyle.craftbukkit.CraftUtils;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@SuppressWarnings("unused")
public class EntityPlayer extends CraftPlayer {
    private CraftPlayer player;
    public PlayerConnection playerConnection;

    public EntityPlayer(CraftPlayer player) {
        super(player);
        this.player = player;
        this.playerConnection = new PlayerConnection(this);
    }

    public static EntityPlayer fromCraftPlayer(CraftPlayer player) {
        return new EntityPlayer(player);
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

    // NMSAPI start
    public Object getEntityPlayer() {
        try {
            return CraftUtils.getHandle(player.getPlayer());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLocaleField() {
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

    public String getDisplayNameField() {
        return (String) getField("displayName");
    }

    public Location getCompassTargetField() {
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

    public Integer getClientViewDistanceField() {
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
        return player;
    }
}
