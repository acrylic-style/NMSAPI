package xyz.acrylicstyle.craftbukkit.v1_15_R1;

import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.loot.LootTable;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.craftbukkit.v1_15_R1.util.CraftIconCache;
import xyz.acrylicstyle.craftbukkit.v1_15_R1.util.Versioning;
import xyz.acrylicstyle.minecraft.v1_15_R1.EntityPlayer;
import xyz.acrylicstyle.minecraft.v1_15_R1.ICommandListener;
import xyz.acrylicstyle.minecraft.v1_15_R1.MinecraftServer;
import xyz.acrylicstyle.minecraft.v1_15_R1.ServerCommand;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.shared.OBCAPI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.function.Consumer;
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
    public @NotNull String getName() {
        return "CraftBukkit";
    }

    @Override
    public @NotNull String getVersion() {
        return this.serverVersion + " (MC: " + this.console.getVersion() + ")";
    }

    @Override
    public @NotNull String getBukkitVersion() {
        return this.bukkitVersion;
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Collection<? extends Player> getOnlinePlayers() {
        return (Collection<? extends Player>) invoke("getOnlinePlayers");
    }

    @Override
    public Player getPlayer(@NotNull String name) {
        return (Player) invoke("getPlayer", name);
    }

    @Override
    public Player getPlayerExact(@NotNull String name) {
        return (Player) invoke("getPlayerExact", name);
    }

    @Override
    public int getMaxPlayers() {
        return (int) invoke("getMaxPlayers");
    }

    @Override
    public int broadcastMessage(@NotNull String message) {
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
    public @NotNull String getIp() {
        return (String) invoke("getIp");
    }

    @Override
    public @NotNull String getWorldType() {
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
    public @NotNull Set<OfflinePlayer> getWhitelistedPlayers() {
        return (Set<OfflinePlayer>) invoke("getWhitelistedPlayers");
    }

    @Override
    public void reloadWhitelist() {
        invoke("reloadWhitelist");
    }

    @Override
    public @NotNull String getUpdateFolder() {
        return (String) invoke("getUpdateFolder");
    }

    @Override
    public @NotNull File getUpdateFolderFile() {
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
    public int getTicksPerWaterSpawns() {
        return (int) invoke("getTicksPerWaterSpawns");
    }

    @Override
    public int getTicksPerAmbientSpawns() {
        return (int) invoke("getTicksPerAmbientSpawns");
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull List<Player> matchPlayer(@NotNull String partialName) {
        return (List<Player>) invoke("matchPlayer", partialName);
    }

    @Override
    public Player getPlayer(@NotNull UUID uuid) {
        return (Player) invoke("getPlayer");
    }

    @Override
    public @NotNull PluginManager getPluginManager() {
        return (PluginManager) invoke("getPluginManager");
    }

    @Override
    public @NotNull BukkitScheduler getScheduler() {
        return (BukkitScheduler) invoke("getScheduler");
    }

    @Override
    public @NotNull ServicesManager getServicesManager() {
        return (ServicesManager) invoke("getServicesManager");
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull List<World> getWorlds() {
        return (List<World>) invoke("getWorlds");
    }

    @Override
    public World createWorld(@NotNull WorldCreator creator) {
        return (World) invoke("createWorld", creator);
    }

    public boolean dispatchServerCommand(CommandSender sender, ServerCommand serverCommand) {
        return (boolean) invoke("dispatchServerCommand", sender, serverCommand.getNMSClass());
    }

    @Override
    public boolean dispatchCommand(@NotNull CommandSender sender, @NotNull String commandLine) {
        return (boolean) invoke("dispatchCommand", sender, commandLine);
    }

    public NMSAPI getHandle() { // todo: create PlayerList
        return NMSAPI.getEmptyNMSAPI(invoke("getHandle"), "CraftServer");
    }

    @Override
    public boolean unloadWorld(@NotNull String name, boolean save) {
        return (boolean) invoke("unloadWorld", name, save);
    }

    @Override
    public boolean unloadWorld(@NotNull World world, boolean save) {
        return (boolean) invoke("unloadWorld", world, save);
    }

    @Override
    public void reload() {
        invoke("reload");
    }

    @Override
    public void reloadData() {
        invoke("reloadData");
    }

    @Override
    public World getWorld(@NotNull String name) {
        return (World) invoke("getWorld", name);
    }

    @Override
    public World getWorld(@NotNull UUID uid) {
        return (World) invoke("getWorld", uid);
    }

    @Override
    public @Nullable MapView getMap(int i) {
        return (MapView) invoke("getMap", i);
    }

    @Override
    public @NotNull MapView createMap(@NotNull World world) {
        return (MapView) invoke("createMap", world);
    }

    @Override
    public @NotNull ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType) {
        return (ItemStack) invoke("createExplorerMap", world, location, structureType);
    }

    @Override
    public @NotNull ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType, int i, boolean b) {
        return (ItemStack) invoke("createExplorerMap", world, location, structureType, i, b);
    }

    @Override
    public @NotNull Logger getLogger() {
        return (Logger) invoke("getLogger");
    }

    @Override
    public PluginCommand getPluginCommand(@NotNull String name) {
        return (PluginCommand) invoke("getPluginCommand", name);
    }

    @Override
    public void savePlayers() {
        invoke("savePlayers");
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return (boolean) invoke("addRecipe", recipe);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull List<Recipe> getRecipesFor(@NotNull ItemStack result) {
        return (List<Recipe>) invoke("getRecipesFor", result);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Iterator<Recipe> recipeIterator() {
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

    @Override
    public boolean removeRecipe(@NotNull NamespacedKey namespacedKey) {
        return (boolean) invoke("removeRecipe", namespacedKey);
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
    public @NotNull Map<String, String[]> getCommandAliases() {
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
    public void shutdown() {
        invoke("shutdown");
    }

    @Override
    public int broadcast(@NotNull String message, @NotNull String permission) {
        return (int) invoke("message", permission);
    }

    @Override
    @Deprecated
    public @NotNull OfflinePlayer getOfflinePlayer(@NotNull String name) {
        return (OfflinePlayer) invoke("getOfflinePlayer", name);
    }

    @Override
    public @NotNull OfflinePlayer getOfflinePlayer(@NotNull UUID id) {
        return (OfflinePlayer) invoke("getOfflinePlayer", id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Set<String> getIPBans() {
        return (Set<String>) invoke("getIPBans");
    }

    @Override
    public void banIP(@NotNull String address) {
        invoke("banIP", address);
    }

    @Override
    public void unbanIP(@NotNull String address) {
        invoke("unbanIP", address);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Set<OfflinePlayer> getBannedPlayers() {
        return (Set<OfflinePlayer>) invoke("getBannedPlayers");
    }

    @Override
    public @NotNull BanList getBanList(BanList.@NotNull Type type) {
        return (BanList) invoke("getBanList", type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Set<OfflinePlayer> getOperators() {
        return (Set<OfflinePlayer>) invoke("getOperators");
    }

    @Override
    public @NotNull GameMode getDefaultGameMode() {
        return (GameMode) invoke("getDefaultGameMode");
    }

    @Override
    public void setDefaultGameMode(@NotNull GameMode mode) {
        invoke("setDefaultGameMode", mode);
    }

    @Override
    public @NotNull ConsoleCommandSender getConsoleSender() {
        return (ConsoleCommandSender) invoke("getCommandSender");
    }

    public ChunkGenerator getGenerator(String world) {
        return (ChunkGenerator) invoke("getGenerator", world);
    }

    @Override
    public @NotNull File getWorldContainer() {
        return (File) invoke("getWorldContainer");
    }

    @Override
    public OfflinePlayer[] getOfflinePlayers() {
        return (OfflinePlayer[]) invoke("getOfflinePlayers");
    }

    @Override
    public @NotNull Messenger getMessenger() {
        return (Messenger) invoke("getMessenger");
    }

    @Override
    public @NotNull HelpMap getHelpMap() {
        return (HelpMap) invoke("getHelpMap");
    }

    @Override
    public @NotNull Inventory createInventory(InventoryHolder owner, @NotNull InventoryType type) {
        return (Inventory) invoke("createInventory", owner, type);
    }

    @Override
    public @NotNull Inventory createInventory(InventoryHolder owner, @NotNull InventoryType type, @NotNull String title) {
        return (Inventory) invoke("createInventory", owner, type, title);
    }

    @Override
    public @NotNull Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        return (Inventory) invoke("createInventory", owner, size);
    }

    @Override
    public @NotNull Inventory createInventory(InventoryHolder owner, int size, @NotNull String title) throws IllegalArgumentException {
        return (Inventory) invoke("createInventory", owner, size, title);
    }

    @Override
    public @NotNull Merchant createMerchant(@Nullable String s) {
        return (Merchant) invoke("createMerchant", s);
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
    public @NotNull String getMotd() {
        return (String) invoke("getMotd");
    }

    @Override
    public String getShutdownMessage() {
        return (String) invoke("getShutdownMessage");
    }

    @Override
    public Warning.@NotNull WarningState getWarningState() {
        return (Warning.WarningState) invoke("getWarningState");
    }

    @Override
    public @NotNull ItemFactory getItemFactory() {
        return (ItemFactory) invoke("getItemFactory");
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        return (ScoreboardManager) invoke("getScoreboardManager");
    }

    @Override
    public @NotNull CachedServerIcon loadServerIcon(@NotNull File file) {
        return (CachedServerIcon) invoke("loadServerIcon", file);
    }

    @Override
    public @NotNull CachedServerIcon loadServerIcon(@NotNull BufferedImage image) {
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
    public ChunkGenerator.@NotNull ChunkData createChunkData(@NotNull World world) {
        return (ChunkGenerator.ChunkData) invoke("createChunkData", world);
    }

    @Override
    public @NotNull BossBar createBossBar(@Nullable String s, @NotNull BarColor barColor, @NotNull BarStyle barStyle, @NotNull BarFlag... barFlags) {
        return (BossBar) invoke("createBossBar", s, barColor, barStyle, barFlags);
    }

    @Override
    public @NotNull KeyedBossBar createBossBar(@NotNull NamespacedKey namespacedKey, @Nullable String s, @NotNull BarColor barColor, @NotNull BarStyle barStyle, @NotNull BarFlag... barFlags) {
        return (KeyedBossBar) invoke("createBossBar", namespacedKey, s, barColor, barStyle, barFlags);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Iterator<KeyedBossBar> getBossBars() {
        return (Iterator<KeyedBossBar>) invoke("getBossBars");
    }

    @Override
    public @Nullable KeyedBossBar getBossBar(@NotNull NamespacedKey namespacedKey) {
        return (KeyedBossBar) invoke("getBossBar", namespacedKey);
    }

    @Override
    public boolean removeBossBar(@NotNull NamespacedKey namespacedKey) {
        return (boolean) invoke("removeBossBar", namespacedKey);
    }

    @Override
    public @Nullable Entity getEntity(@NotNull UUID uuid) {
        return (Entity) invoke("getEntity", uuid);
    }

    @Override
    public @Nullable Advancement getAdvancement(@NotNull NamespacedKey namespacedKey) {
        return (Advancement) invoke("getAdvancement", namespacedKey);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Iterator<Advancement> advancementIterator() {
        return (Iterator<Advancement>) invoke("advancementIterator");
    }

    @Override
    public @NotNull BlockData createBlockData(@NotNull Material material) {
        return (BlockData) invoke("createBlockData", material);
    }

    @Override
    public @NotNull BlockData createBlockData(@NotNull Material material, @Nullable Consumer<BlockData> consumer) {
        return (BlockData) invoke("createBlockData", material, consumer);
    }

    @Override
    public @NotNull BlockData createBlockData(@NotNull String s) throws IllegalArgumentException {
        return (BlockData) invoke("createBlockData", s);
    }

    @Override
    public @NotNull BlockData createBlockData(@Nullable Material material, @Nullable String s) throws IllegalArgumentException {
        return (BlockData) invoke("createBlockData", material, s);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @Nullable <T extends Keyed> Tag<T> getTag(@NotNull String s, @NotNull NamespacedKey namespacedKey, @NotNull Class<T> aClass) {
        return (Tag<T>) invoke("getTag", s, namespacedKey, aClass);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull <T extends Keyed> Iterable<Tag<T>> getTags(@NotNull String s, @NotNull Class<T> aClass) {
        return (Iterable<Tag<T>>) invoke("getTags", s, aClass);
    }

    @Override
    public @Nullable LootTable getLootTable(@NotNull NamespacedKey namespacedKey) {
        return (LootTable) invoke("getLootTable", namespacedKey);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull List<Entity> selectEntities(@NotNull CommandSender commandSender, @NotNull String s) throws IllegalArgumentException {
        return (List<Entity>) invoke("selectEntities", commandSender, s);
    }

    @Override
    @Deprecated
    public @NotNull UnsafeValues getUnsafe() {
        return (UnsafeValues) invoke("getUnsafe");
    }

    @Override
    public @NotNull Spigot spigot() {
        return (Spigot) invoke("spigot");
    }

    @Override
    public void sendPluginMessage(@NotNull Plugin source, @NotNull String channel, byte[] message) {
        invoke("sendPluginManager", source, channel, message);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull Set<String> getListeningPluginChannels() {
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
