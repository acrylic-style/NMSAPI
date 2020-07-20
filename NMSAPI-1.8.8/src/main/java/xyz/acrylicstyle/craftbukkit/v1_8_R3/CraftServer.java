package xyz.acrylicstyle.craftbukkit.v1_8_R3;

import com.avaje.ebean.config.ServerConfig;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.CraftIconCache;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.Versioning;
import xyz.acrylicstyle.minecraft.v1_8_R1.EntityPlayer;
import xyz.acrylicstyle.minecraft.v1_8_R1.ICommandListener;
import xyz.acrylicstyle.minecraft.v1_8_R1.MinecraftServer;
import xyz.acrylicstyle.minecraft.v1_8_R1.ServerCommand;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.shared.OBCAPI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class CraftServer extends OBCAPI implements Server {
    public static final Class<?> CLASS = getClassWithoutException("CraftServer");

    public static final Player[] EMPTY_PLAYER_ARRAY = new Player[0];

    public final String serverName = "CraftBukkit";

    public final String serverVersion;

    public final String bukkitVersion = Versioning.getBukkitVersion();

    public final MinecraftServer console;

    public static final class BooleanWrapper {
        public boolean value = true;
    }

    public CraftServer() {
        super("CraftServer");
        this.serverVersion = (String) getField("serverVersion");
        this.console = MinecraftServer.newInstance(getField("console"));
    }

    public CraftServer(Object o) {
        super(o, "CraftServer");
        this.serverVersion = (String) getField("serverVersion");
        this.console = MinecraftServer.newInstance(getField("console"));
    }

    public CraftServer(MinecraftServer console, Object playerList) {
        super("CraftServer", console, playerList);
        this.serverVersion = (String) getField("serverVersion");
        this.console = MinecraftServer.newInstance(getField("console"));
    }

    public File getConfigFile() {
        return (File) invoke("getConfigFile");
    }

    public File getCommandsConfigFile() {
        return (File) invoke("getCommandsConfigFile");
    }

    public void saveConfig() {
        invoke("saveConfig");
    }

    public void saveCommandsConfig() {
        invoke("saveCommandsConfig");
    }

    public void loadPlugins() {
        invoke("loadPlugins");
    }

    public void enablePlugins(PluginLoadOrder type) {
        invoke("enablePlugins", type);
    }

    public void disablePlugins() {
        invoke("disablePlugins");
    }

    public void setVanillaCommands(boolean first) {
        invoke("setVanillaCommands", first);
    }

    public void loadPlugin(Plugin plugin) {
        invoke("loadPlugin", plugin);
    }

    @Override
    public String getName() {
        return "CraftBukkit";
    }

    @Override
    public String getVersion() {
        return this.serverVersion + " (MC: " + this.console.getVersion() + ")";
    }

    @Override
    public String getBukkitVersion() {
        return this.bukkitVersion;
    }

    @Override
    public Player[] _INVALID_getOnlinePlayers() {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<? extends Player> getOnlinePlayers() {
        return (Collection<? extends Player>) invoke("getOnlinePlayers");
    }

    @Override
    public Player getPlayer(String name) {
        return (Player) invoke("getPlayer", name);
    }

    @Override
    public Player getPlayerExact(String name) {
        return (Player) invoke("getPlayerExact", name);
    }

    @Override
    public int getMaxPlayers() {
        return (int) invoke("getMaxPlayers");
    }

    @Override
    public int broadcastMessage(String message) {
        return broadcast(message, "bukkit.broadcast.user");
    }

    public Player getPlayer(EntityPlayer player) {
        return player.getBukkitEntity();
    }

    @Override
    public int getPort() {
        return (int) invoke("getPort");
    }

    @Override
    public int getViewDistance() {
        return (int) invoke("getViewDistance");
    }

    @Override
    public String getIp() {
        return (String) invoke("getIp");
    }

    @Override
    public String getServerName() {
        return (String) invoke("getServerName");
    }

    @Override
    public String getServerId() {
        return (String) invoke("getServerId");
    }

    @Override
    public String getWorldType() {
        return (String) invoke("getWorldType");
    }

    @Override
    public boolean getGenerateStructures() {
        return (boolean) invoke("getGenerateStructures");
    }

    @Override
    public boolean getAllowEnd() {
        return (boolean) invoke("getAllowEnd");
    }

    @Override
    public boolean getAllowNether() {
        return (boolean) invoke("getAllowNether");
    }

    @Override
    public boolean hasWhitelist() {
        return (boolean) invoke("hasWhitelist");
    }

    @Override
    public void setWhitelist(boolean value) {
        invoke("setWhitelist", value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<OfflinePlayer> getWhitelistedPlayers() {
        return (Set<OfflinePlayer>) invoke("getWhitelistedPlayers");
    }

    @Override
    public void reloadWhitelist() {
        invoke("reloadWhitelist");
    }

    @Override
    public String getUpdateFolder() {
        return (String) invoke("getUpdateFolder");
    }

    @Override
    public File getUpdateFolderFile() {
        return (File) invoke("getUpdateFolderFile");
    }

    @Override
    public long getConnectionThrottle() {
        return (long) invoke("getConnectionThrottle");
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        return (int) invoke("getTicksPerAnimalSpawns");
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        return (int) invoke("getTicksPerMonsterSpawns");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Player> matchPlayer(String partialName) {
        return (List<Player>) invoke("matchPlayer", partialName);
    }

    @Override
    public Player getPlayer(UUID uuid) {
        return (Player) invoke("getPlayer");
    }

    @Override
    public PluginManager getPluginManager() {
        return (PluginManager) invoke("getPluginManager");
    }

    @Override
    public BukkitScheduler getScheduler() {
        return (BukkitScheduler) invoke("getScheduler");
    }

    @Override
    public ServicesManager getServicesManager() {
        return (ServicesManager) invoke("getServicesManager");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<World> getWorlds() {
        return (List<World>) invoke("getWorlds");
    }

    @Override
    public World createWorld(WorldCreator creator) {
        return (World) invoke("createWorld", creator);
    }

    public boolean dispatchServerCommand(CommandSender sender, ServerCommand serverCommand) {
        return (boolean) invoke("dispatchServerCommand", sender, serverCommand.getNMSClass());
    }

    @Override
    public boolean dispatchCommand(CommandSender sender, String commandLine) {
        return (boolean) invoke("dispatchCommand", sender, commandLine);
    }

    /**
     * This will always throw ClassCastException.
     */
    public NMSAPI getHandle() {
        return (NMSAPI) invoke("getHandle");
    }

    @Override
    public boolean unloadWorld(String name, boolean save) {
        return (boolean) invoke("unloadWorld", name, save);
    }

    @Override
    public boolean unloadWorld(World world, boolean save) {
        return (boolean) invoke("unloadWorld", world, save);
    }

    @Override
    public void reload() {
        invoke("reload");
    }

    @Override
    public World getWorld(String name) {
        return (World) invoke("getWorld", name);
    }

    @Override
    public World getWorld(UUID uid) {
        return (World) invoke("getWorld", uid);
    }

    @Override
    public MapView getMap(short id) {
        return (MapView) invoke("getMap", id);
    }

    @Override
    public MapView createMap(World world) {
        return (MapView) invoke("createMap", world);
    }

    @Override
    public Logger getLogger() {
        return (Logger) invoke("getLogger");
    }

    @Override
    public PluginCommand getPluginCommand(String name) {
        return (PluginCommand) invoke("getPluginCommand", name);
    }

    @Override
    public void savePlayers() {
        invoke("savePlayers");
    }

    @Override
    public void configureDbConfig(ServerConfig config) {
        invoke("configureDbConfig", config);
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return (boolean) invoke("addRecipe", recipe);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Recipe> getRecipesFor(ItemStack result) {
        return (List<Recipe>) invoke("getRecipesFor", result);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<Recipe> recipeIterator() {
        return (Iterator<Recipe>) invoke("recipeIterator");
    }

    @Override
    public void clearRecipes() {
        invoke("clearRecipes");
    }

    @Override
    public void resetRecipes() {
        invoke("resetRecipes");
    }

    public void loadIcon() {
        invoke("loadIcon");
    }

    public boolean getCommandBlockOverride(String command) {
        return (boolean) invoke("getCommandBlockOverride", command);
    }

    public void loadCustomPermissions() {
        invoke("loadCustomPermissions");
    }

    @Override
    public String toString() {
        return "CraftServer{serverName=CraftBukkit,serverVersion=" + this.serverVersion + ",minecraftVersion=" + this.console.getVersion() + "}";
    }

    public World createWorld(String name, World.Environment environment) {
        return (World) invoke("createWorld", name, environment);
    }

    public World createWorld(String name, World.Environment environment, long seed) {
        return (World) invoke("createWorld", name, environment, seed);
    }

    public World createWorld(String name, World.Environment environment, ChunkGenerator generator) {
        return (World) invoke("createWorld", name, environment, generator);
    }

    public World createWorld(String name, World.Environment environment, long seed, ChunkGenerator generator) {
        return (World) invoke("createWorld", name, environment, seed, generator);
    }

    public MinecraftServer getServer() {
        return this.console;
    }

    public void addWorld(World world) {
        invoke("addWorld", world);
    }

    public Object getReader() {
        return invoke("getReader");
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, String[]> getCommandAliases() {
        return (Map<String, String[]>) invoke("getCommandAliases");
    }

    @Override
    public int getSpawnRadius() {
        return (int) invoke("getSpawnRadius");
    }

    @Override
    public void setSpawnRadius(int value) {
        invoke("setSpawnRadius", value);
    }

    @Override
    public boolean getOnlineMode() {
        return (boolean) invoke("getOnlineMode");
    }

    @Override
    public boolean getAllowFlight() {
        return (boolean) invoke("getAllowFlight");
    }

    @Override
    public boolean isHardcore() {
        return (boolean) invoke("isHardcore");
    }

    @Override
    public boolean useExactLoginLocation() {
        return (boolean) invoke("useExactLoginLocation");
    }

    @Override
    public void shutdown() {
        invoke("shutdown");
    }

    @Override
    public int broadcast(String message, String permission) {
        return (int) invoke("message", permission);
    }

    @Override
    @Deprecated
    public OfflinePlayer getOfflinePlayer(String name) {
        return (OfflinePlayer) invoke("getOfflinePlayer", name);
    }

    @Override
    public OfflinePlayer getOfflinePlayer(UUID id) {
        return (OfflinePlayer) invoke("getOfflinePlayer", id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<String> getIPBans() {
        return (Set<String>) invoke("getIPBans");
    }

    @Override
    public void banIP(String address) {
        invoke("banIP", address);
    }

    @Override
    public void unbanIP(String address) {
        invoke("unbanIP", address);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<OfflinePlayer> getBannedPlayers() {
        return (Set<OfflinePlayer>) invoke("getBannedPlayers");
    }

    @Override
    public BanList getBanList(BanList.Type type) {
        return (BanList) invoke("getBanList", type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<OfflinePlayer> getOperators() {
        return (Set<OfflinePlayer>) invoke("getOperators");
    }

    @Override
    public GameMode getDefaultGameMode() {
        return (GameMode) invoke("getDefaultGameMode");
    }

    @Override
    public void setDefaultGameMode(GameMode mode) {
        invoke("setDefaultGameMode", mode);
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        return (ConsoleCommandSender) invoke("getCommandSender");
    }

    public ChunkGenerator getGenerator(String world) {
        return (ChunkGenerator) invoke("getGenerator", world);
    }

    @Override
    public File getWorldContainer() {
        return (File) invoke("getWorldContainer");
    }

    @Override
    public OfflinePlayer[] getOfflinePlayers() {
        return (OfflinePlayer[]) invoke("getOfflinePlayers");
    }

    @Override
    public Messenger getMessenger() {
        return (Messenger) invoke("getMessenger");
    }

    @Override
    public HelpMap getHelpMap() {
        return (HelpMap) invoke("getHelpMap");
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        return (Inventory) invoke("createInventory", owner, type);
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        return (Inventory) invoke("createInventory", owner, type, title);
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        return (Inventory) invoke("createInventory", owner, size);
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
        return (Inventory) invoke("createInventory", owner, size, title);
    }

    @Override
    public int getMonsterSpawnLimit() {
        return (int) invoke("getMonsterSpawnLimit");
    }

    @Override
    public int getAnimalSpawnLimit() {
        return (int) invoke("getAnimalSpawnLimit");
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        return (int) invoke("getWaterAnimalSpawnLimit");
    }

    @Override
    public int getAmbientSpawnLimit() {
        return (int) invoke("getAmbientSpawnLimit");
    }

    @Override
    public boolean isPrimaryThread() {
        return (boolean) invoke("isPrimaryThread");
    }

    @Override
    public String getMotd() {
        return (String) invoke("getMotd");
    }

    @Override
    public String getShutdownMessage() {
        return (String) invoke("getShutdownMessage");
    }

    @Override
    public Warning.WarningState getWarningState() {
        return (Warning.WarningState) invoke("getWarningState");
    }

    @Override
    public ItemFactory getItemFactory() {
        return (ItemFactory) invoke("getItemFactory");
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        return (ScoreboardManager) invoke("getScoreboardManager");
    }

    @Override
    public CachedServerIcon loadServerIcon(File file) {
        return (CachedServerIcon) invoke("loadServerIcon", file);
    }

    @Override
    public CachedServerIcon loadServerIcon(BufferedImage image) {
        return (CachedServerIcon) invoke("loadServerIcon", image);
    }

    @Override
    public void setIdleTimeout(int threshold) {
        invoke("setIdleTimeout", threshold);
    }

    @Override
    public int getIdleTimeout() {
        return (int) invoke("getIdleTimeout");
    }

    @Override
    public ChunkGenerator.ChunkData createChunkData(World world) {
        return (ChunkGenerator.ChunkData) invoke("createChunkData", world);
    }

    @Override
    @Deprecated
    public UnsafeValues getUnsafe() {
        return (UnsafeValues) invoke("getUnsafe");
    }

    @Override
    public Spigot spigot() {
        return (Spigot) invoke("spigot");
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        invoke("sendPluginManager", source, channel, message);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<String> getListeningPluginChannels() {
        return (Set<String>) invoke("getListeningPluginChannels");
    }

    @SuppressWarnings("unchecked")
    public List<String> tabComplete(ICommandListener sender, String message) {
        return (List<String>) invoke("tabComplete", sender.getNMSClass(), message);
    }

    @SuppressWarnings("unchecked")
    public List<String> tabCompleteCommand(Player player, String message) {
        return (List<String>) invoke("tabCompleteCommand", player, message);
    }

    @SuppressWarnings("unchecked")
    public List<String> tabCompleteChat(Player player, String message) {
        return (List<String>) invoke("tabCompleteChat", player, message);
    }

    public void checkSaveState() {
        invoke("checkSaveState");
    }

    @Override
    public CraftIconCache getServerIcon() {
        return new CraftIconCache(invoke("getServerIcon"));
    }

    public Object getWorldMetadata() {
        return invoke("getWorldMetadata");
    }

    public int getBukkitSpawnRadius() {
        return (int) invoke("getBukkitSpawnRadius");
    }

    public void removeBukkitSpawnRadius() {
        invoke("removeBukkitSpawnRadius");
    }

    public Object getPlayerMetadata() {
        return invoke("getPlayerMetadata");
    }

    public Object getEntityMetadata() {
        return invoke("getEntityMetadata");
    }
}
