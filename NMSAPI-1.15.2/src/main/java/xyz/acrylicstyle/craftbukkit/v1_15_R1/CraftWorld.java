package xyz.acrylicstyle.craftbukkit.v1_15_R1;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.DragonBattle;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Consumer;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.TypedOBCAPI;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

public class CraftWorld extends TypedOBCAPI<World> implements World {
    public CraftWorld(World world) {
        super(world, "CraftWorld");
    }

    @Override
    public @NotNull Block getBlockAt(int x, int y, int z) {
        return t.getBlockAt(x, y, z);
    }

    @Override
    public @NotNull Block getBlockAt(@NotNull Location location) {
        return t.getBlockAt(location);
    }

    @Override
    public int getHighestBlockYAt(int x, int z) {
        return t.getHighestBlockYAt(x, z);
    }

    @Override
    public int getHighestBlockYAt(@NotNull Location location) {
        return t.getHighestBlockYAt(location);
    }

    @Override
    public @NotNull Block getHighestBlockAt(int x, int z) {
        return t.getHighestBlockAt(x, z);
    }

    @Override
    public @NotNull Block getHighestBlockAt(@NotNull Location location) {
        return t.getHighestBlockAt(location);
    }

    @Override
    public int getHighestBlockYAt(int x, int z, @NotNull HeightMap heightMap) {
        return t.getHighestBlockYAt(x, z, heightMap);
    }

    @Override
    public int getHighestBlockYAt(@NotNull Location location, @NotNull HeightMap heightMap) {
        return t.getHighestBlockYAt(location, heightMap);
    }

    @Override
    public @NotNull Block getHighestBlockAt(int x, int z, @NotNull HeightMap heightMap) {
        return t.getHighestBlockAt(x, z, heightMap);
    }

    @Override
    public @NotNull Block getHighestBlockAt(@NotNull Location location, @NotNull HeightMap heightMap) {
        return t.getHighestBlockAt(location, heightMap);
    }

    @Override
    public @NotNull Chunk getChunkAt(int x, int z) {
        return t.getChunkAt(x, z);
    }

    public @NotNull CraftChunk getCraftChunkAt(int x, int z) {
        return new CraftChunk(this.getChunkAt(x, z));
    }

    public @NotNull xyz.acrylicstyle.minecraft.v1_15_R1.Chunk getMinecraftChunkAt(int x, int z) {
        return this.getCraftChunkAt(x, z).getHandle();
    }

    @Override
    public @NotNull Chunk getChunkAt(@NotNull Location location) {
        return t.getChunkAt(location);
    }

    public @NotNull CraftChunk getCraftChunkAt(@NotNull Location location) {
        return new CraftChunk(this.getChunkAt(location));
    }

    public @NotNull xyz.acrylicstyle.minecraft.v1_15_R1.Chunk getMinecraftChunkAt(@NotNull Location location) {
        return this.getCraftChunkAt(location).getHandle();
    }

    @Override
    public @NotNull Chunk getChunkAt(@NotNull Block block) {
        return t.getChunkAt(block);
    }

    @Override
    public boolean isChunkLoaded(@NotNull Chunk chunk) {
        return t.isChunkLoaded(chunk);
    }

    @Override
    public @NotNull Chunk[] getLoadedChunks() {
        return t.getLoadedChunks();
    }

    @Override
    public void loadChunk(@NotNull Chunk chunk) {
        t.loadChunk(chunk);
    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        return t.isChunkLoaded(x, z);
    }

    @Override
    public boolean isChunkGenerated(int x, int z) {
        return t.isChunkGenerated(x, z);
    }

    @Override
    @Deprecated
    public boolean isChunkInUse(int x, int z) {
        return t.isChunkInUse(x, z);
    }

    @Override
    public void loadChunk(int x, int z) {
        t.loadChunk(x, z);
    }

    @Override
    public boolean loadChunk(int x, int z, boolean generate) {
        return t.loadChunk(x, z, generate);
    }

    @Override
    public boolean unloadChunk(@NotNull Chunk chunk) {
        return t.unloadChunk(chunk);
    }

    @Override
    public boolean unloadChunk(int x, int z) {
        return t.unloadChunk(x, z);
    }

    @Override
    public boolean unloadChunk(int x, int z, boolean save) {
        return t.unloadChunk(x, z, save);
    }

    @Override
    public boolean unloadChunkRequest(int x, int z) {
        return t.unloadChunkRequest(x, z);
    }

    @Override
    @Deprecated
    public boolean regenerateChunk(int x, int z) {
        return t.regenerateChunk(x, z);
    }

    @Override
    @Deprecated
    public boolean refreshChunk(int x, int z) {
        return t.refreshChunk(x, z);
    }

    @Override
    public boolean isChunkForceLoaded(int x, int z) {
        return t.isChunkForceLoaded(x, z);
    }

    @Override
    public void setChunkForceLoaded(int x, int z, boolean forced) {
        t.setChunkForceLoaded(x, z, forced);
    }

    @Override
    public @NotNull Collection<Chunk> getForceLoadedChunks() {
        return t.getForceLoadedChunks();
    }

    @Override
    public boolean addPluginChunkTicket(int x, int z, @NotNull Plugin plugin) {
        return t.addPluginChunkTicket(x, z, plugin);
    }

    @Override
    public boolean removePluginChunkTicket(int x, int z, @NotNull Plugin plugin) {
        return t.removePluginChunkTicket(x, z, plugin);
    }

    @Override
    public void removePluginChunkTickets(@NotNull Plugin plugin) {
        t.removePluginChunkTickets(plugin);
    }

    @Override
    public @NotNull Collection<Plugin> getPluginChunkTickets(int x, int z) {
        return t.getPluginChunkTickets(x, z);
    }

    @Override
    public @NotNull Map<Plugin, Collection<Chunk>> getPluginChunkTickets() {
        return t.getPluginChunkTickets();
    }

    @Override
    public @NotNull Item dropItem(@NotNull Location location, @NotNull ItemStack item) {
        return t.dropItem(location, item);
    }

    @Override
    public @NotNull Item dropItemNaturally(@NotNull Location location, @NotNull ItemStack item) {
        return t.dropItemNaturally(location, item);
    }

    @Override
    public @NotNull Arrow spawnArrow(@NotNull Location location, @NotNull Vector direction, float speed, float spread) {
        return t.spawnArrow(location, direction, speed, spread);
    }

    @Override
    public <T extends AbstractArrow> @NotNull T spawnArrow(@NotNull Location location, @NotNull Vector direction, float speed, float spread, @NotNull Class<T> clazz) {
        return t.spawnArrow(location, direction, speed, spread, clazz);
    }

    @Override
    public boolean generateTree(@NotNull Location location, @NotNull TreeType type) {
        return t.generateTree(location, type);
    }

    @Override
    public boolean generateTree(@NotNull Location loc, @NotNull TreeType type, @NotNull BlockChangeDelegate delegate) {
        return t.generateTree(loc, type, delegate);
    }

    @Override
    public @NotNull Entity spawnEntity(@NotNull Location loc, @NotNull EntityType type) {
        return t.spawnEntity(loc, type);
    }

    @Override
    public @NotNull LightningStrike strikeLightning(@NotNull Location loc) {
        return t.strikeLightning(loc);
    }

    @Override
    public @NotNull LightningStrike strikeLightningEffect(@NotNull Location loc) {
        return t.strikeLightning(loc);
    }

    @Override
    public @NotNull List<Entity> getEntities() {
        return t.getEntities();
    }

    @Override
    public @NotNull List<LivingEntity> getLivingEntities() {
        return t.getLivingEntities();
    }

    @SafeVarargs
    @Deprecated
    @Override
    @NotNull
    public final <T extends Entity> Collection<T> getEntitiesByClass(@NotNull Class<T>... classes) {
        return t.getEntitiesByClass(classes);
    }

    @Override
    public @NotNull <T extends Entity> Collection<T> getEntitiesByClass(@NotNull Class<T> cls) {
        return t.getEntitiesByClass(cls);
    }

    @Override
    public @NotNull Collection<Entity> getEntitiesByClasses(@NotNull Class<?>... classes) {
        return t.getEntitiesByClasses(classes);
    }

    @Override
    public @NotNull List<Player> getPlayers() {
        return t.getPlayers();
    }

    @Override
    public @NotNull Collection<Entity> getNearbyEntities(@NotNull Location location, double x, double y, double z) {
        return t.getNearbyEntities(location, x, y, z);
    }

    @Override
    public @NotNull Collection<Entity> getNearbyEntities(@NotNull Location location, double x, double y, double z, @Nullable Predicate<Entity> filter) {
        return t.getNearbyEntities(location, x, y, z, filter);
    }

    @Override
    public @NotNull Collection<Entity> getNearbyEntities(@NotNull BoundingBox boundingBox) {
        return t.getNearbyEntities(boundingBox);
    }

    @Override
    public @NotNull Collection<Entity> getNearbyEntities(@NotNull BoundingBox boundingBox, @Nullable Predicate<Entity> filter) {
        return t.getNearbyEntities(boundingBox, filter);
    }

    @Override
    public @Nullable RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance) {
        return t.rayTraceEntities(start, direction, maxDistance);
    }

    @Override
    public @Nullable RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, double raySize) {
        return t.rayTraceEntities(start, direction, maxDistance, raySize);
    }

    @Override
    public @Nullable RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, @Nullable Predicate<Entity> filter) {
        return t.rayTraceEntities(start, direction, maxDistance, filter);
    }

    @Override
    public @Nullable RayTraceResult rayTraceEntities(@NotNull Location start, @NotNull Vector direction, double maxDistance, double raySize, @Nullable Predicate<Entity> filter) {
        return t.rayTraceEntities(start, direction, maxDistance, raySize, filter);
    }

    @Override
    public @Nullable RayTraceResult rayTraceBlocks(@NotNull Location start, @NotNull Vector direction, double maxDistance) {
        return t.rayTraceBlocks(start, direction, maxDistance);
    }

    @Override
    public @Nullable RayTraceResult rayTraceBlocks(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
        return t.rayTraceBlocks(start, direction, maxDistance, fluidCollisionMode);
    }

    @Override
    public @Nullable RayTraceResult rayTraceBlocks(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks) {
        return t.rayTraceBlocks(start, direction, maxDistance, fluidCollisionMode, ignorePassableBlocks);
    }

    @Override
    public @Nullable RayTraceResult rayTrace(@NotNull Location start, @NotNull Vector direction, double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks, double raySize, @Nullable Predicate<Entity> filter) {
        return t.rayTrace(start, direction, maxDistance, fluidCollisionMode, ignorePassableBlocks, raySize, filter);
    }

    @Override
    public @NotNull String getName() {
        return t.getName();
    }

    @Override
    public @NotNull UUID getUID() {
        return t.getUID();
    }

    @Override
    public @NotNull Location getSpawnLocation() {
        return t.getSpawnLocation();
    }

    @Override
    public boolean setSpawnLocation(@NotNull Location location) {
        return t.setSpawnLocation(location);
    }

    @Override
    public boolean setSpawnLocation(int x, int y, int z) {
        return t.setSpawnLocation(x, y, z);
    }

    @Override
    public long getTime() {
        return t.getTime();
    }

    @Override
    public void setTime(long time) {
        t.setTime(time);
    }

    @Override
    public long getFullTime() {
        return t.getFullTime();
    }

    @Override
    public void setFullTime(long time) {
        t.setFullTime(time);
    }

    @Override
    public boolean hasStorm() {
        return t.hasStorm();
    }

    @Override
    public void setStorm(boolean hasStorm) {
        t.setStorm(hasStorm);
    }

    @Override
    public int getWeatherDuration() {
        return t.getWeatherDuration();
    }

    @Override
    public void setWeatherDuration(int duration) {
        t.setWeatherDuration(duration);
    }

    @Override
    public boolean isThundering() {
        return t.isThundering();
    }

    @Override
    public void setThundering(boolean thundering) {
        t.setThundering(thundering);
    }

    @Override
    public int getThunderDuration() {
        return t.getThunderDuration();
    }

    @Override
    public void setThunderDuration(int duration) {
        t.setThunderDuration(duration);
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power) {
        return t.createExplosion(x, y, z, power);
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
        return t.createExplosion(x, y, z, power, setFire);
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
        return t.createExplosion(x, y, z, power, setFire, breakBlocks);
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks, @Nullable Entity source) {
        return t.createExplosion(x, y, z, power, setFire, breakBlocks, source);
    }

    @Override
    public boolean createExplosion(@NotNull Location loc, float power) {
        return t.createExplosion(loc, power);
    }

    @Override
    public boolean createExplosion(@NotNull Location loc, float power, boolean setFire) {
        return t.createExplosion(loc, power, setFire);
    }

    @Override
    public boolean createExplosion(@NotNull Location loc, float power, boolean setFire, boolean breakBlocks) {
        return t.createExplosion(loc, power, setFire, breakBlocks);
    }

    @Override
    public boolean createExplosion(@NotNull Location loc, float power, boolean setFire, boolean breakBlocks, @Nullable Entity source) {
        return t.createExplosion(loc, power, setFire, breakBlocks, source);
    }

    @Override
    public @NotNull Environment getEnvironment() {
        return t.getEnvironment();
    }

    @Override
    public long getSeed() {
        return t.getSeed();
    }

    @Override
    public boolean getPVP() {
        return t.getPVP();
    }

    @Override
    public void setPVP(boolean pvp) {
        t.setPVP(pvp);
    }

    @Override
    public @Nullable ChunkGenerator getGenerator() {
        return t.getGenerator();
    }

    @Override
    public void save() {
        t.save();
    }

    @Override
    public @NotNull List<BlockPopulator> getPopulators() {
        return t.getPopulators();
    }

    @Override
    public <T extends Entity> @NotNull T spawn(@NotNull Location location, @NotNull Class<T> clazz) throws IllegalArgumentException {
        return t.spawn(location, clazz);
    }

    @Override
    public <T extends Entity> @NotNull T spawn(@NotNull Location location, @NotNull Class<T> clazz, @Nullable Consumer<T> function) throws IllegalArgumentException {
        return t.spawn(location, clazz, function);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull FallingBlock spawnFallingBlock(@NotNull Location location, @NotNull MaterialData data) throws IllegalArgumentException {
        return t.spawnFallingBlock(location, data);
    }

    @Override
    public @NotNull FallingBlock spawnFallingBlock(@NotNull Location location, @NotNull BlockData data) throws IllegalArgumentException {
        return t.spawnFallingBlock(location, data);
    }

    @Override
    @Deprecated
    public @NotNull FallingBlock spawnFallingBlock(@NotNull Location location, @NotNull Material material, byte data) throws IllegalArgumentException {
        return t.spawnFallingBlock(location, material, data);
    }

    @Override
    public void playEffect(@NotNull Location location, @NotNull Effect effect, int data) {
        t.playEffect(location, effect, data);
    }

    @Override
    public void playEffect(@NotNull Location location, @NotNull Effect effect, int data, int radius) {
        t.playEffect(location, effect, data, radius);
    }

    @Override
    public <T> void playEffect(@NotNull Location location, @NotNull Effect effect, @Nullable T data) {
        t.playEffect(location, effect, data);
    }

    @Override
    public <T> void playEffect(@NotNull Location location, @NotNull Effect effect, @Nullable T data, int radius) {
        t.playEffect(location, effect, data, radius);
    }

    @Override
    public @NotNull ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTemp) {
        return t.getEmptyChunkSnapshot(x, z, includeBiome, includeBiomeTemp);
    }

    @Override
    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
        t.setSpawnFlags(allowMonsters, allowAnimals);
    }

    @Override
    public boolean getAllowAnimals() {
        return t.getAllowAnimals();
    }

    @Override
    public boolean getAllowMonsters() {
        return t.getAllowMonsters();
    }

    @Override
    @Deprecated
    public @NotNull Biome getBiome(int x, int z) {
        return t.getBiome(x, z);
    }

    @Override
    public @NotNull Biome getBiome(int x, int y, int z) {
        return t.getBiome(x, y, z);
    }

    @Override
    @Deprecated
    public void setBiome(int x, int z, @NotNull Biome bio) {
        t.setBiome(x, z, bio);
    }

    @Override
    public void setBiome(int x, int y, int z, @NotNull Biome bio) {
        t.setBiome(x, y, z, bio);
    }

    @Override
    @Deprecated
    public double getTemperature(int x, int z) {
        return t.getTemperature(x, z);
    }

    @Override
    public double getTemperature(int x, int y, int z) {
        return t.getTemperature(x, y, z);
    }

    @Override
    @Deprecated
    public double getHumidity(int x, int z) {
        return t.getHumidity(x, z);
    }

    @Override
    public double getHumidity(int x, int y, int z) {
        return t.getHumidity(x, y, z);
    }

    @Override
    public int getMaxHeight() {
        return t.getMaxHeight();
    }

    @Override
    public int getSeaLevel() {
        return t.getSeaLevel();
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        return t.getKeepSpawnInMemory();
    }

    @Override
    public void setKeepSpawnInMemory(boolean keepLoaded) {
        t.setKeepSpawnInMemory(keepLoaded);
    }

    @Override
    public boolean isAutoSave() {
        return t.isAutoSave();
    }

    @Override
    public void setAutoSave(boolean value) {
        t.setAutoSave(value);
    }

    @Override
    public void setDifficulty(@NotNull Difficulty difficulty) {
        t.setDifficulty(difficulty);
    }

    @Override
    public @NotNull Difficulty getDifficulty() {
        return t.getDifficulty();
    }

    @Override
    public @NotNull File getWorldFolder() {
        return t.getWorldFolder();
    }

    @Override
    public @Nullable WorldType getWorldType() {
        return t.getWorldType();
    }

    @Override
    public boolean canGenerateStructures() {
        return t.canGenerateStructures();
    }

    @Override
    public boolean isHardcore() {
        return t.isHardcore();
    }

    @Override
    public void setHardcore(boolean hardcore) {
        t.setHardcore(hardcore);
    }

    @Override
    public long getTicksPerAnimalSpawns() {
        return t.getTicksPerAnimalSpawns();
    }

    @Override
    public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
        t.setTicksPerAnimalSpawns(ticksPerAnimalSpawns);
    }

    @Override
    public long getTicksPerMonsterSpawns() {
        return t.getTicksPerMonsterSpawns();
    }

    @Override
    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
        t.setTicksPerMonsterSpawns(ticksPerMonsterSpawns);
    }

    @Override
    public long getTicksPerWaterSpawns() {
        return t.getTicksPerWaterSpawns();
    }

    @Override
    public void setTicksPerWaterSpawns(int ticksPerWaterSpawns) {
        t.setTicksPerWaterSpawns(ticksPerWaterSpawns);
    }

    @Override
    public long getTicksPerAmbientSpawns() {
        return t.getTicksPerAmbientSpawns();
    }

    @Override
    public void setTicksPerAmbientSpawns(int ticksPerAmbientSpawns) {
        t.setTicksPerAmbientSpawns(ticksPerAmbientSpawns);
    }

    @Override
    public int getMonsterSpawnLimit() {
        return t.getMonsterSpawnLimit();
    }

    @Override
    public void setMonsterSpawnLimit(int limit) {
        t.setMonsterSpawnLimit(limit);
    }

    @Override
    public int getAnimalSpawnLimit() {
        return t.getAnimalSpawnLimit();
    }

    @Override
    public void setAnimalSpawnLimit(int limit) {
        t.setAnimalSpawnLimit(limit);
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        return t.getWaterAnimalSpawnLimit();
    }

    @Override
    public void setWaterAnimalSpawnLimit(int limit) {
        t.setWaterAnimalSpawnLimit(limit);
    }

    @Override
    public int getAmbientSpawnLimit() {
        return t.getAmbientSpawnLimit();
    }

    @Override
    public void setAmbientSpawnLimit(int limit) {
        t.setAmbientSpawnLimit(limit);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull Sound sound, float volume, float pitch) {
        t.playSound(location, sound, volume, pitch);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull String sound, float volume, float pitch) {
        t.playSound(location, sound, volume, pitch);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch) {
        t.playSound(location, sound, category, volume, pitch);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch) {
        t.playSound(location, sound, category, volume, pitch);
    }

    @Override
    public @NotNull String[] getGameRules() {
        return t.getGameRules();
    }

    @Override
    @Deprecated
    public @Nullable String getGameRuleValue(@Nullable String rule) {
        return t.getGameRuleValue(rule);
    }

    @Override
    @Deprecated
    public boolean setGameRuleValue(@NotNull String rule, @NotNull String value) {
        return t.setGameRuleValue(rule, value);
    }

    @Override
    public boolean isGameRule(@NotNull String rule) {
        return t.isGameRule(rule);
    }

    @Override
    public <T> @Nullable T getGameRuleValue(@NotNull GameRule<T> rule) {
        return t.getGameRuleValue(rule);
    }

    @Override
    public <T> @Nullable T getGameRuleDefault(@NotNull GameRule<T> rule) {
        return t.getGameRuleDefault(rule);
    }

    @Override
    public <T> boolean setGameRule(@NotNull GameRule<T> rule, @NotNull T newValue) {
        return t.setGameRule(rule, newValue);
    }

    @Override
    public @NotNull WorldBorder getWorldBorder() {
        return t.getWorldBorder();
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count) {
        t.spawnParticle(particle, location, count);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count) {
        t.spawnParticle(particle, x, y, z, count);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, @Nullable T data) {
        t.spawnParticle(particle, location, count, data);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, @Nullable T data) {
        t.spawnParticle(particle, x, y, z, count, data);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ) {
        t.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {
        t.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data) {
        t.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, data);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data) {
        t.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, data);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        t.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        t.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data) {
        t.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data) {
        t.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data, boolean force) {
        t.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data, force);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data, boolean force) {
        t.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data, force);
    }

    @Override
    public @Nullable Location locateNearestStructure(@NotNull Location origin, @NotNull StructureType structureType, int radius, boolean findUnexplored) {
        return t.locateNearestStructure(origin, structureType, radius, findUnexplored);
    }

    @Override
    public int getViewDistance() {
        return t.getViewDistance();
    }

    @Override
    public @NotNull Spigot spigot() {
        return t.spigot();
    }

    @Override
    public @Nullable Raid locateNearestRaid(@NotNull Location location, int radius) {
        return t.locateNearestRaid(location, radius);
    }

    @Override
    public @NotNull List<Raid> getRaids() {
        return t.getRaids();
    }

    @Override
    public @Nullable DragonBattle getEnderDragonBattle() {
        return t.getEnderDragonBattle();
    }

    @Override
    public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {
        t.setMetadata(metadataKey, newMetadataValue);
    }

    @Override
    public @NotNull List<MetadataValue> getMetadata(@NotNull String metadataKey) {
        return t.getMetadata(metadataKey);
    }

    @Override
    public boolean hasMetadata(@NotNull String metadataKey) {
        return t.hasMetadata(metadataKey);
    }

    @Override
    public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin) {
        t.removeMetadata(metadataKey, owningPlugin);
    }

    @Override
    public void sendPluginMessage(@NotNull Plugin source, @NotNull String channel, @NotNull byte[] message) {
        t.sendPluginMessage(source, channel, message);
    }

    @Override
    public @NotNull Set<String> getListeningPluginChannels() {
        return t.getListeningPluginChannels();
    }

    @Override
    public xyz.acrylicstyle.minecraft.v1_15_R1.World getHandle() {
        return xyz.acrylicstyle.minecraft.v1_15_R1.World.newInstance(invoke("getHandle"));
    }
}
