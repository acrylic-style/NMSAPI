package xyz.acrylicstyle.nmsapi.abstracts.craftbukkit.entity;

import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.FluidCollisionMode;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Note;
import org.bukkit.Particle;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Villager;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.authlib.GameProfile;
import xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityPlayer;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CraftPlayer extends CraftEntity implements Player {
    public static final Class<?> CLASS = getClassWithoutException("entity.CraftPlayer");

    private Player player;
    public Object craftPlayer;

    public CraftPlayer(Object o) {
        super(o, "entity.CraftPlayer");
        try {
            if (o.getClass().isAssignableFrom(Player.class)) {
                this.player = (Player) o;
                this.craftPlayer = o;
                return;
            }
            if (o.getClass().isAssignableFrom(xyz.acrylicstyle.craftbukkit.v1_8_R3.entity.CraftPlayer.CLASS)) {
                this.player = (Player) o;
                this.craftPlayer = o;
                return;
            }
            if (o.getClass().isAssignableFrom(EntityPlayer.CLASS)) {
                this.player = (Player) o.getClass().getDeclaredMethod("getBukkitEntity").invoke(o);
                this.craftPlayer = o.getClass().getDeclaredMethod("getBukkitEntity").invoke(o);
                return;
            }
            throw new IllegalArgumentException("Illegal object: " + o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GameProfile getProfile() {
        return getHandle().getProfile();
    }

    public void setHandle(@NotNull EntityPlayer ep) { invoke("setHandle", ep.getHandle()); }

    @NotNull
    public EntityPlayer getHandle() {
        return EntityPlayer.getInstance(this.player);
    }

    @Override
    @NotNull
    public org.bukkit.entity.Player.Spigot spigot() {
        return player.spigot();
    }

    public void swingOffHand() {
        player.swingOffHand();
    }

    public void swingMainHand() {
        player.swingMainHand();
    }

    public void attack(@NotNull Entity entity) {
        player.attack(entity);
    }

    @Override
    public @NotNull String getDisplayName() {
        return player.getDisplayName();
    }

    @Override
    public void setDisplayName(@Nullable String s) {
        player.setDisplayName(s);
    }

    @Override
    public @NotNull String getPlayerListName() {
        return player.getPlayerListName();
    }

    @Override
    public void setPlayerListName(@Nullable String s) {
        player.setPlayerListName(s);
    }

    @Override
    public @Nullable String getPlayerListHeader() {
        return player.getPlayerListHeader();
    }

    @Override
    public @Nullable String getPlayerListFooter() {
        return player.getPlayerListFooter();
    }

    @Override
    public void setPlayerListHeader(@Nullable String s) {
        player.setPlayerListHeader(s);
    }

    @Override
    public void setPlayerListFooter(@Nullable String s) {
        player.setPlayerListFooter(s);
    }

    @Override
    public void setPlayerListHeaderFooter(@Nullable String s, @Nullable String s1) {
        player.setPlayerListHeaderFooter(s, s1);
    }

    @Override
    public void setCompassTarget(@NotNull Location location) {
        player.setCompassTarget(location);
    }

    @Override
    public @NotNull Location getCompassTarget() {
        return player.getCompassTarget();
    }

    @Override
    public @Nullable InetSocketAddress getAddress() {
        return player.getAddress();
    }

    @Override
    public boolean isConversing() {
        return player.isConversing();
    }

    @Override
    public void acceptConversationInput(@NotNull String s) {
        player.acceptConversationInput(s);
    }

    @Override
    public boolean beginConversation(@NotNull Conversation conversation) {
        return player.beginConversation(conversation);
    }

    @Override
    public void abandonConversation(@NotNull Conversation conversation) {
        player.abandonConversation(conversation);
    }

    @Override
    public void abandonConversation(@NotNull Conversation conversation, @NotNull ConversationAbandonedEvent conversationAbandonedEvent) {
        player.abandonConversation(conversation, conversationAbandonedEvent);
    }

    @Override
    public void sendRawMessage(@NotNull String s) {
        player.sendRawMessage(s);
    }

    @Override
    public void kickPlayer(@Nullable String s) {
        player.kickPlayer(s);
    }

    @Override
    public void chat(@NotNull String s) {
        player.chat(s);
    }

    @Override
    public boolean performCommand(@NotNull String s) {
        return player.performCommand(s);
    }

    @Override
    public boolean isSneaking() {
        return player.isSneaking();
    }

    @Override
    public void setSneaking(boolean b) {
        player.setSneaking(b);
    }

    @Override
    public boolean isSprinting() {
        return player.isSprinting();
    }

    @Override
    public void setSprinting(boolean b) {
        player.setSprinting(b);
    }

    @Override
    public void saveData() {
        player.saveData();
    }

    @Override
    public void loadData() {
        player.loadData();
    }

    @Override
    public void setSleepingIgnored(boolean b) {
        player.setSleepingIgnored(b);
    }

    @Override
    public boolean isSleepingIgnored() {
        return player.isSleepingIgnored();
    }

    @Override
    @Deprecated
    public void playNote(@NotNull Location location, byte b, byte b1) {
        player.playNote(location, b, b1);
    }

    @Override
    public void playNote(@NotNull Location location, @NotNull Instrument instrument, @NotNull Note note) {
        player.playNote(location, instrument, note);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull Sound sound, float v, float v1) {
        player.playSound(location, sound, v, v1);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull String s, float v, float v1) {
        player.playSound(location, s, v, v1);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory soundCategory, float v, float v1) {
        player.playSound(location, sound, soundCategory, v, v1);
    }

    @Override
    public void playSound(@NotNull Location location, @NotNull String s, @NotNull SoundCategory soundCategory, float v, float v1) {
        player.playSound(location, s, soundCategory, v, v1);
    }

    @Override
    public void stopSound(@NotNull Sound sound) {
        player.stopSound(sound);
    }

    @Override
    public void stopSound(@NotNull String s) {
        player.stopSound(s);
    }

    @Override
    public void stopSound(@NotNull Sound sound, @Nullable SoundCategory soundCategory) {
        player.stopSound(sound, soundCategory);
    }

    @Override
    public void stopSound(@NotNull String s, @Nullable SoundCategory soundCategory) {
        player.stopSound(s, soundCategory);
    }

    @Override
    @Deprecated
    public void playEffect(@NotNull Location location, @NotNull Effect effect, int i) {
        player.playEffect(location, effect, i);
    }

    @Override
    public <T> void playEffect(@NotNull Location location, @NotNull Effect effect, @Nullable T t) {
        player.playEffect(location, effect, t);
    }

    @Override
    @Deprecated
    public void sendBlockChange(@NotNull Location location, @NotNull Material material, byte b) {
        player.sendBlockChange(location, material, b);
    }

    @Override
    public void sendBlockChange(@NotNull Location location, @NotNull BlockData blockData) {
        player.sendBlockChange(location, blockData);
    }

    @Override
    @Deprecated
    public boolean sendChunkChange(@NotNull Location location, int i, int i1, int i2, @NotNull byte[] bytes) {
        return player.sendChunkChange(location, i, i1, i2, bytes);
    }

    @Override
    public void sendSignChange(@NotNull Location location, @Nullable String[] strings) throws IllegalArgumentException {
        player.sendSignChange(location, strings);
    }

    @Override
    public void sendSignChange(@NotNull Location location, @Nullable String[] strings, @NotNull DyeColor dyeColor) throws IllegalArgumentException {
        player.sendSignChange(location, strings, dyeColor);
    }

    @Override
    public void sendMap(@NotNull MapView mapView) {
        player.sendMap(mapView);
    }

    @Override
    public void updateInventory() {
        player.updateInventory();
    }

    @Override
    public void incrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
        player.incrementStatistic(statistic);
    }

    @Override
    public void decrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
        player.decrementStatistic(statistic);
    }

    @Override
    public void incrementStatistic(@NotNull Statistic statistic, int i) throws IllegalArgumentException {
        player.incrementStatistic(statistic, i);
    }

    @Override
    public void decrementStatistic(@NotNull Statistic statistic, int i) throws IllegalArgumentException {
        player.decrementStatistic(statistic, i);
    }

    @Override
    public void setStatistic(@NotNull Statistic statistic, int i) throws IllegalArgumentException {
        player.setStatistic(statistic, i);
    }

    @Override
    public int getStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
        return player.getStatistic(statistic);
    }

    @Override
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
        player.incrementStatistic(statistic, material);
    }

    @Override
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
        player.decrementStatistic(statistic, material);
    }

    @Override
    public int getStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
        return player.getStatistic(statistic, material);
    }

    @Override
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int i) throws IllegalArgumentException {
        player.incrementStatistic(statistic, material, i);
    }

    @Override
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int i) throws IllegalArgumentException {
        player.decrementStatistic(statistic, material, i);
    }

    @Override
    public void setStatistic(@NotNull Statistic statistic, @NotNull Material material, int i) throws IllegalArgumentException {
        player.setStatistic(statistic, material, i);
    }

    @Override
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
        player.incrementStatistic(statistic, entityType);
    }

    @Override
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
        player.decrementStatistic(statistic, entityType);
    }

    @Override
    public int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
        return player.getStatistic(statistic, entityType);
    }

    @Override
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) throws IllegalArgumentException {
        player.incrementStatistic(statistic, entityType, i);
    }

    @Override
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) {
        player.decrementStatistic(statistic, entityType, i);
    }

    @Override
    public void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) {
        player.setStatistic(statistic, entityType, i);
    }

    @Override
    public void setPlayerTime(long l, boolean b) {
        player.setPlayerTime(l, b);
    }

    @Override
    public long getPlayerTime() {
        return player.getPlayerTime();
    }

    @Override
    public long getPlayerTimeOffset() {
        return player.getPlayerTimeOffset();
    }

    @Override
    public boolean isPlayerTimeRelative() {
        return player.isPlayerTimeRelative();
    }

    @Override
    public void resetPlayerTime() {
        player.resetPlayerTime();
    }

    @Override
    public void setPlayerWeather(@NotNull WeatherType weatherType) {
        player.setPlayerWeather(weatherType);
    }

    @Override
    public @Nullable WeatherType getPlayerWeather() {
        return player.getPlayerWeather();
    }

    @Override
    public void resetPlayerWeather() {
        player.resetPlayerWeather();
    }

    @Override
    public void giveExp(int i) {
        player.giveExp(i);
    }

    @Override
    public void giveExpLevels(int i) {
        player.giveExpLevels(i);
    }

    @Override
    public float getExp() {
        return player.getExp();
    }

    @Override
    public void setExp(float v) {
        player.setExp(v);
    }

    @Override
    public int getLevel() {
        return player.getLevel();
    }

    @Override
    public void setLevel(int i) {
        player.setLevel(i);
    }

    @Override
    public int getTotalExperience() {
        return player.getTotalExperience();
    }

    @Override
    public void setTotalExperience(int i) {
        player.setTotalExperience(i);
    }

    @Override
    public void sendExperienceChange(float progress) {
        player.sendExperienceChange(progress);
    }

    @Override
    public void sendExperienceChange(float progress, int level) {
        player.sendExperienceChange(progress, level);
    }

    @Override
    public float getExhaustion() {
        return player.getExhaustion();
    }

    @Override
    public void setExhaustion(float v) {
        player.setExhaustion(v);
    }

    @Override
    public float getSaturation() {
        return player.getSaturation();
    }

    @Override
    public void setSaturation(float v) {
        player.setSaturation(v);
    }

    @Override
    public int getFoodLevel() {
        return player.getFoodLevel();
    }

    @Override
    public void setFoodLevel(int i) {
        player.setFoodLevel(i);
    }

    @Override
    public boolean getAllowFlight() {
        return player.getAllowFlight();
    }

    @Override
    public void setAllowFlight(boolean b) {
        player.setAllowFlight(b);
    }

    @Override
    @Deprecated
    public void hidePlayer(@NotNull Player player) {
        player.hidePlayer(player);
    }

    @Override
    public void hidePlayer(@NotNull Plugin plugin, @NotNull Player player) {
        player.hidePlayer(plugin, player);
    }

    @Override
    @Deprecated
    public void showPlayer(@NotNull Player player) {
        player.showPlayer(player);
    }

    @Override
    public void showPlayer(@NotNull Plugin plugin, @NotNull Player player) {
        player.showPlayer(plugin, player);
    }

    @Override
    public boolean canSee(@NotNull Player player) {
        return player.canSee(player);
    }

    @Override
    public boolean isFlying() {
        return player.isFlying();
    }

    @Override
    public void setFlying(boolean b) {
        player.setFlying(b);
    }

    @Override
    public void setFlySpeed(float v) throws IllegalArgumentException {
        player.setFlySpeed(v);
    }

    @Override
    public void setWalkSpeed(float v) throws IllegalArgumentException {
        player.setWalkSpeed(v);
    }

    @Override
    public float getFlySpeed() {
        return player.getFlySpeed();
    }

    @Override
    public float getWalkSpeed() {
        return player.getWalkSpeed();
    }

    @Override
    @Deprecated
    public void setTexturePack(@NotNull String s) {
        player.setTexturePack(s);
    }

    @Override
    public void setResourcePack(@NotNull String s) {
        player.setResourcePack(s);
    }

    @Override
    public void setResourcePack(@NotNull String s, @NotNull byte[] bytes) {
        player.setResourcePack(s, bytes);
    }

    @Override
    public @NotNull Scoreboard getScoreboard() {
        return player.getScoreboard();
    }

    @Override
    public void setScoreboard(@NotNull Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        player.setScoreboard(scoreboard);
    }

    @Override
    public boolean isHealthScaled() {
        return player.isHealthScaled();
    }

    @Override
    public void setHealthScaled(boolean b) {
        player.setHealthScaled(b);
    }

    @Override
    public void setHealthScale(double v) throws IllegalArgumentException {
        player.setHealthScale(v);
    }

    @Override
    public double getHealthScale() {
        return player.getHealthScale();
    }

    @Override
    public @Nullable Entity getSpectatorTarget() {
        return player.getSpectatorTarget();
    }

    @Override
    public void setSpectatorTarget(@Nullable Entity entity) {
        player.setSpectatorTarget(entity);
    }

    @Override
    @Deprecated
    public void sendTitle(@Nullable String title, @Nullable String subtitle) {
        player.sendTitle(title, subtitle);
    }

    @Override
    public void sendTitle(@Nullable String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    @Override
    public void resetTitle() {
        player.resetTitle();
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i) {
        player.spawnParticle(particle, location, i);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count) {
        player.spawnParticle(particle, x, y, z, count);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, @Nullable T t) {
        player.spawnParticle(particle, location, i, t);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, @Nullable T t) {
        player.spawnParticle(particle, v, v1, v2, i, t);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double offsetX, double offsetY, double offsetZ) {
        player.spawnParticle(particle, location, i, offsetX, offsetY, offsetZ);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5) {
        player.spawnParticle(particle, v, v1, v2, i, v3, v4, v5);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, @Nullable T t) {
        player.spawnParticle(particle, location, i, v, v1, v2, t);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, @Nullable T t) {
        player.spawnParticle(particle, v, v1, v2, i, v3, v4, v5, t);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, double v3) {
        player.spawnParticle(particle, location, i, v, v1, v2, v3);
    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6) {
        player.spawnParticle(particle, v, v1, v2, i, v3, v4, v5, v6);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, double v3, @Nullable T t) {
        player.spawnParticle(particle, location, i, v, v1, v2, v3, t);
    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, @Nullable T t) {
        player.spawnParticle(particle, v, v1, v2, i, v3, v4, v5, v6, t);
    }

    @Override
    public @NotNull AdvancementProgress getAdvancementProgress(@NotNull Advancement advancement) {
        return player.getAdvancementProgress(advancement);
    }

    @Override
    public int getClientViewDistance() {
        return player.getClientViewDistance();
    }

    @Override
    public @NotNull String getLocale() {
        return player.getLocale();
    }

    @Override
    public void updateCommands() {
        player.updateCommands();
    }

    @Override
    public void openBook(@NotNull ItemStack itemStack) {
        player.openBook(itemStack);
    }

    @Override
    public @NotNull Location getLocation() {
        return player.getLocation();
    }

    @Override
    public @Nullable Location getLocation(@Nullable Location location) {
        return player.getLocation(location);
    }

    @Override
    public void setVelocity(@NotNull Vector vector) {
        player.setVelocity(vector);
    }

    @Override
    public @NotNull Vector getVelocity() {
        return player.getVelocity();
    }

    @Override
    public double getHeight() {
        return player.getHeight();
    }

    @Override
    public double getWidth() {
        return player.getWidth();
    }

    @Override
    public @NotNull BoundingBox getBoundingBox() {
        return player.getBoundingBox();
    }

    @Override
    public boolean isOnGround() {
        return player.isOnGround();
    }

    @Override
    public @NotNull World getWorld() {
        return player.getWorld();
    }

    @Override
    public void setRotation(float yaw, float pitch) {
        player.setRotation(yaw, pitch);
    }

    @Override
    public boolean teleport(@NotNull Location location) {
        return player.teleport(location);
    }

    @Override
    public boolean teleport(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
        return player.teleport(location, teleportCause);
    }

    @Override
    public boolean teleport(@NotNull Entity entity) {
        return player.teleport(entity);
    }

    @Override
    public boolean teleport(@NotNull Entity entity, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
        return player.teleport(entity, teleportCause);
    }

    @Override
    public @NotNull List<Entity> getNearbyEntities(double x, double y, double z) {
        return player.getNearbyEntities(x, y, z);
    }

    @Override
    public int getEntityId() {
        return player.getEntityId();
    }

    @Override
    public int getFireTicks() {
        return player.getFireTicks();
    }

    @Override
    public int getMaxFireTicks() {
        return player.getFireTicks();
    }

    @Override
    public void setFireTicks(int ticks) {
        player.setFireTicks(ticks);
    }

    @Override
    public void remove() {
        player.remove();
    }

    @Override
    public boolean isDead() {
        return player.isDead();
    }

    @Override
    public boolean isValid() {
        return player.isValid();
    }

    @Override
    public void sendMessage(@NotNull String s) {
        player.sendMessage(s);
    }

    @Override
    public void sendMessage(@NotNull String[] message) {
        player.sendMessage(message);
    }

    @Override
    public @NotNull Server getServer() {
        return player.getServer();
    }

    @Override
    public @NotNull List<Entity> getPassengers() {
        return player.getPassengers();
    }

    @Override
    public boolean addPassenger(@NotNull Entity entity) {
        return player.addPassenger(entity);
    }

    @Override
    public boolean removePassenger(@NotNull Entity entity) {
        return player.removePassenger(entity);
    }

    @Override
    public boolean isEmpty() {
        return player.isEmpty();
    }

    @Override
    public boolean eject() {
        return player.eject();
    }

    @Override
    public float getFallDistance() {
        return player.getFallDistance();
    }

    @Override
    public void setFallDistance(float v) {
        player.setFallDistance(v);
    }

    @Override
    public void setLastDamageCause(@Nullable EntityDamageEvent entityDamageEvent) {
        player.setLastDamageCause(entityDamageEvent);
    }

    @Override
    public @Nullable EntityDamageEvent getLastDamageCause() {
        return player.getLastDamageCause();
    }

    @Override
    public @NotNull UUID getUniqueId() {
        return player.getUniqueId();
    }

    @Override
    public int getTicksLived() {
        return player.getTicksLived();
    }

    @Override
    public void setTicksLived(int i) {
        player.setTicksLived(i);
    }

    @Override
    public void playEffect(@NotNull EntityEffect entityEffect) {
        player.playEffect(entityEffect);
    }

    @Override
    public @NotNull EntityType getType() {
        return player.getType();
    }

    @Override
    public boolean isInsideVehicle() {
        return player.isInsideVehicle();
    }

    @Override
    public boolean leaveVehicle() {
        return player.leaveVehicle();
    }

    @Override
    public @Nullable Entity getVehicle() {
        return player.getVehicle();
    }

    @Override
    public void setCustomNameVisible(boolean b) {
        player.setCustomNameVisible(b);
    }

    @Override
    public boolean isCustomNameVisible() {
        return player.isCustomNameVisible();
    }

    @Override
    public void setGlowing(boolean b) {
        player.setGlowing(b);
    }

    @Override
    public boolean isGlowing() {
        return player.isGlowing();
    }

    @Override
    public void setInvulnerable(boolean b) {
        player.setInvulnerable(b);
    }

    @Override
    public boolean isInvulnerable() {
        return player.isInvulnerable();
    }

    @Override
    public boolean isSilent() {
        return player.isSilent();
    }

    @Override
    public void setSilent(boolean b) {
        player.setSilent(b);
    }

    @Override
    public boolean hasGravity() {
        return player.hasGravity();
    }

    @Override
    public void setGravity(boolean b) {
        player.setGravity(b);
    }

    @Override
    public int getPortalCooldown() {
        return player.getPortalCooldown();
    }

    @Override
    public void setPortalCooldown(int i) {
        player.setPortalCooldown(i);
    }

    @Override
    public @NotNull Set<String> getScoreboardTags() {
        return player.getScoreboardTags();
    }

    @Override
    public boolean addScoreboardTag(@NotNull String s) {
        return player.addScoreboardTag(s);
    }

    @Override
    public boolean removeScoreboardTag(@NotNull String s) {
        return player.removeScoreboardTag(s);
    }

    @Override
    public @NotNull PistonMoveReaction getPistonMoveReaction() {
        return player.getPistonMoveReaction();
    }

    @Override
    public @NotNull BlockFace getFacing() {
        return player.getFacing();
    }

    @Override
    public @NotNull Pose getPose() {
        return player.getPose();
    }

    @Override
    public boolean isOnline() {
        return player.isOnline();
    }

    @Override
    public boolean isBanned() {
        return player.isBanned();
    }

    @Override
    public boolean isWhitelisted() {
        return player.isWhitelisted();
    }

    @Override
    public void setWhitelisted(boolean b) {
        player.setWhitelisted(b);
    }

    @Override
    public @Nullable Player getPlayer() {
        return player.getPlayer();
    }

    @Override
    public long getFirstPlayed() {
        return player.getFirstPlayed();
    }

    @Override
    public long getLastPlayed() {
        return player.getLastPlayed();
    }

    @Override
    public boolean hasPlayedBefore() {
        return player.hasPlayedBefore();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return player.serialize();
    }

    @Override
    public @NotNull String getName() {
        return player.getName();
    }

    @Override
    public @NotNull PlayerInventory getInventory() {
        return player.getInventory();
    }

    @Override
    public @NotNull Inventory getEnderChest() {
        return player.getEnderChest();
    }

    @Override
    public @NotNull MainHand getMainHand() {
        return player.getMainHand();
    }

    @Override
    public boolean setWindowProperty(InventoryView.@NotNull Property property, int i) {
        return player.setWindowProperty(property, i);
    }

    @Override
    public @NotNull InventoryView getOpenInventory() {
        return player.getOpenInventory();
    }

    @Override
    public @Nullable InventoryView openInventory(@NotNull Inventory inventory) {
        return player.openInventory(inventory);
    }

    @Override
    public @Nullable InventoryView openWorkbench(@Nullable Location location, boolean b) {
        return player.openWorkbench(location, b);
    }

    @Override
    public @Nullable InventoryView openEnchanting(@Nullable Location location, boolean b) {
        return player.openEnchanting(location, b);
    }

    @Override
    public void openInventory(@NotNull InventoryView inventoryView) {
        player.openInventory(inventoryView);
    }

    @Override
    public @Nullable InventoryView openMerchant(@NotNull Villager villager, boolean b) {
        return player.openMerchant(villager, b);
    }

    @Override
    public @Nullable InventoryView openMerchant(@NotNull Merchant merchant, boolean b) {
        return player.openMerchant(merchant, b);
    }

    @Override
    public void closeInventory() {
        player.closeInventory();
    }

    @Override
    @Deprecated
    public @NotNull ItemStack getItemInHand() {
        return player.getItemInHand();
    }

    @Override
    @Deprecated
    public void setItemInHand(@Nullable ItemStack itemStack) {
        player.setItemInHand(itemStack);
    }

    @Override
    public @NotNull ItemStack getItemOnCursor() {
        return player.getItemOnCursor();
    }

    @Override
    public void setItemOnCursor(@Nullable ItemStack itemStack) {
        player.setItemOnCursor(itemStack);
    }

    @Override
    public boolean hasCooldown(@NotNull Material material) {
        return player.hasCooldown(material);
    }

    @Override
    public int getCooldown(@NotNull Material material) {
        return player.getCooldown(material);
    }

    @Override
    public void setCooldown(@NotNull Material material, int i) {
        player.setCooldown(material, i);
    }

    @Override
    public int getSleepTicks() {
        return player.getSleepTicks();
    }

    @Override
    public @Nullable Location getBedSpawnLocation() {
        return player.getBedSpawnLocation();
    }

    @Override
    public void setBedSpawnLocation(@Nullable Location location) {
        player.setBedSpawnLocation(location);
    }

    @Override
    public void setBedSpawnLocation(@Nullable Location location, boolean b) {
        player.setBedSpawnLocation(location, b);
    }

    @Override
    public boolean sleep(@NotNull Location location, boolean b) {
        return player.sleep(location, b);
    }

    @Override
    public void wakeup(boolean b) {
        player.wakeup(b);
    }

    @Override
    public @NotNull Location getBedLocation() {
        return player.getBedLocation();
    }

    @Override
    public @NotNull GameMode getGameMode() {
        return player.getGameMode();
    }

    @Override
    public void setGameMode(@NotNull GameMode gameMode) {
        player.setGameMode(gameMode);
    }

    @Override
    public boolean isBlocking() {
        return player.isBlocking();
    }

    @Override
    public boolean isHandRaised() {
        return player.isHandRaised();
    }

    @Override
    public int getExpToLevel() {
        return player.getExpToLevel();
    }

    @Override
    public boolean discoverRecipe(@NotNull NamespacedKey namespacedKey) {
        return player.discoverRecipe(namespacedKey);
    }

    @Override
    public int discoverRecipes(@NotNull Collection<NamespacedKey> collection) {
        return player.discoverRecipes(collection);
    }

    @Override
    public boolean undiscoverRecipe(@NotNull NamespacedKey namespacedKey) {
        return player.undiscoverRecipe(namespacedKey);
    }

    @Override
    public int undiscoverRecipes(@NotNull Collection<NamespacedKey> collection) {
        return player.undiscoverRecipes(collection);
    }

    @Override
    @Deprecated
    public @Nullable Entity getShoulderEntityLeft() {
        return player.getShoulderEntityLeft();
    }

    @Override
    @Deprecated
    public void setShoulderEntityLeft(@Nullable Entity entity) {
        player.setShoulderEntityLeft(entity);
    }

    @Override
    @Deprecated
    public @Nullable Entity getShoulderEntityRight() {
        return player.getShoulderEntityRight();
    }

    @Override
    @Deprecated
    public void setShoulderEntityRight(@Nullable Entity entity) {
        player.setShoulderEntityRight(entity);
    }

    @Override
    public double getEyeHeight() {
        return player.getEyeHeight();
    }

    @Override
    public double getEyeHeight(boolean ignorePose) {
        return player.getEyeHeight(ignorePose);
    }

    @Override
    public @NotNull Location getEyeLocation() {
        return player.getEyeLocation();
    }

    @Override
    public @NotNull List<Block> getLineOfSight(@Nullable Set<Material> set, int i) {
        return player.getLineOfSight(set, i);
    }

    @Override
    public @NotNull Block getTargetBlock(@Nullable Set<Material> set, int i) {
        return player.getTargetBlock(set, i);
    }

    @Override
    public @NotNull List<Block> getLastTwoTargetBlocks(@Nullable Set<Material> set, int i) {
        return player.getLastTwoTargetBlocks(set, i);
    }

    @Override
    public @Nullable Block getTargetBlockExact(int maxDistance) {
        return player.getTargetBlockExact(maxDistance);
    }

    @Override
    public @Nullable Block getTargetBlockExact(int maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
        return player.getTargetBlockExact(maxDistance, fluidCollisionMode);
    }

    @Override
    public @Nullable RayTraceResult rayTraceBlocks(double maxDistance) {
        return player.rayTraceBlocks(maxDistance);
    }

    @Override
    public @Nullable RayTraceResult rayTraceBlocks(double maxDistance, @NotNull FluidCollisionMode fluidCollisionMode) {
        return player.rayTraceBlocks(maxDistance, fluidCollisionMode);
    }

    @Override
    public int getRemainingAir() {
        return player.getRemainingAir();
    }

    @Override
    public void setRemainingAir(int ticks) {
        player.setRemainingAir(ticks);
    }

    @Override
    public int getMaximumAir() {
        return player.getMaximumAir();
    }

    @Override
    public void setMaximumAir(int ticks) {
        player.setMaximumAir(ticks);
    }

    @Override
    public int getMaximumNoDamageTicks() {
        return player.getMaximumNoDamageTicks();
    }

    @Override
    public void setMaximumNoDamageTicks(int ticks) {
        player.setMaximumNoDamageTicks(ticks);
    }

    @Override
    public double getLastDamage() {
        return player.getLastDamage();
    }

    @Override
    public void setLastDamage(double damage) {
        player.setLastDamage(damage);
    }

    @Override
    public int getNoDamageTicks() {
        return player.getNoDamageTicks();
    }

    @Override
    public void setNoDamageTicks(int ticks) {
        player.setNoDamageTicks(ticks);
    }

    @Override
    public @Nullable Player getKiller() {
        return player.getKiller();
    }

    @Override
    public boolean addPotionEffect(@NotNull PotionEffect potionEffect) {
        return player.addPotionEffect(potionEffect);
    }

    @Override
    @Deprecated
    public boolean addPotionEffect(@NotNull PotionEffect potionEffect, boolean force) {
        return player.addPotionEffect(potionEffect, force);
    }

    @Override
    public boolean addPotionEffects(@NotNull Collection<PotionEffect> collection) {
        return player.addPotionEffects(collection);
    }

    @Override
    public boolean hasPotionEffect(@NotNull PotionEffectType potionEffectType) {
        return player.hasPotionEffect(potionEffectType);
    }

    @Override
    public @Nullable PotionEffect getPotionEffect(@NotNull PotionEffectType potionEffectType) {
        return player.getPotionEffect(potionEffectType);
    }

    @Override
    public void removePotionEffect(@NotNull PotionEffectType potionEffectType) {
        player.removePotionEffect(potionEffectType);
    }

    @Override
    public @NotNull Collection<PotionEffect> getActivePotionEffects() {
        return player.getActivePotionEffects();
    }

    @Override
    public boolean hasLineOfSight(@NotNull Entity entity) {
        return player.hasLineOfSight(entity);
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        return player.getRemoveWhenFarAway();
    }

    @Override
    public void setRemoveWhenFarAway(boolean b) {
        player.setRemoveWhenFarAway(b);
    }

    @Override
    public @Nullable EntityEquipment getEquipment() {
        return player.getEquipment();
    }

    @Override
    public void setCanPickupItems(boolean b) {
        player.setCanPickupItems(b);
    }

    @Override
    public boolean getCanPickupItems() {
        return player.getCanPickupItems();
    }

    @Override
    public boolean isLeashed() {
        return player.isLeashed();
    }

    @Override
    public @NotNull Entity getLeashHolder() throws IllegalStateException {
        return player.getLeashHolder();
    }

    @Override
    public boolean setLeashHolder(@Nullable Entity entity) {
        return player.setLeashHolder(entity);
    }

    @Override
    public boolean isGliding() {
        return player.isGliding();
    }

    @Override
    public void setGliding(boolean b) {
        player.setGliding(b);
    }

    @Override
    public boolean isSwimming() {
        return player.isSwimming();
    }

    @Override
    public void setSwimming(boolean b) {
        player.setSwimming(b);
    }

    @Override
    public boolean isRiptiding() {
        return player.isRiptiding();
    }

    @Override
    public boolean isSleeping() {
        return player.isSleeping();
    }

    @Override
    public void setAI(boolean b) {
        player.setAI(b);
    }

    @Override
    public boolean hasAI() {
        return player.hasAI();
    }

    @Override
    public void setCollidable(boolean b) {
        player.setCollidable(b);
    }

    @Override
    public boolean isCollidable() {
        return player.isCollidable();
    }

    @Override
    public <T> @Nullable T getMemory(@NotNull MemoryKey<T> memoryKey) {
        return player.getMemory(memoryKey);
    }

    @Override
    public <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @Nullable T t) {
        player.setMemory(memoryKey, t);
    }

    @Override
    public @Nullable AttributeInstance getAttribute(@NotNull Attribute attribute) {
        return player.getAttribute(attribute);
    }

    @Override
    public void damage(double v) {
        player.damage(v);
    }

    @Override
    public void damage(double v, @Nullable Entity entity) {
        player.damage(v, entity);
    }

    @Override
    public double getHealth() {
        return player.getHealth();
    }

    @Override
    public void setHealth(double v) {
        player.setHealth(v);
    }

    @Override
    public double getAbsorptionAmount() {
        return player.getAbsorptionAmount();
    }

    @Override
    public void setAbsorptionAmount(double v) {
        player.setAbsorptionAmount(v);
    }

    @Override
    @Deprecated
    public double getMaxHealth() {
        return player.getMaxHealth();
    }

    @Override
    @Deprecated
    public void setMaxHealth(double v) {
        player.setMaxHealth(v);
    }

    @Override
    @Deprecated
    public void resetMaxHealth() {
        player.resetMaxHealth();
    }

    @Override
    public @Nullable String getCustomName() {
        return player.getCustomName();
    }

    @Override
    public void setCustomName(@Nullable String s) {
        player.setCustomName(s);
    }

    @Override
    public void setMetadata(@NotNull String key, @NotNull MetadataValue value) {
        player.setMetadata(key, value);
    }

    @Override
    public @NotNull List<MetadataValue> getMetadata(@NotNull String key) {
        return player.getMetadata(key);
    }

    @Override
    public boolean hasMetadata(@NotNull String key) {
        return player.hasMetadata(key);
    }

    @Override
    public void removeMetadata(@NotNull String key, @NotNull Plugin plugin) {
        player.removeMetadata(key, plugin);
    }

    @Override
    public boolean isPermissionSet(@NotNull String s) {
        return player.isPermissionSet(s);
    }

    @Override
    public boolean isPermissionSet(@NotNull Permission permission) {
        return player.isPermissionSet(permission);
    }

    @Override
    public boolean hasPermission(@NotNull String s) {
        return player.hasPermission(s);
    }

    @Override
    public boolean hasPermission(@NotNull Permission permission) {
        return player.hasPermission(permission);
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        return player.addAttachment(plugin, name, value);
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        return player.addAttachment(plugin);
    }

    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
        return player.addAttachment(plugin, name, value, ticks);
    }

    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
        return player.addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(@NotNull PermissionAttachment permissionAttachment) {
        player.removeAttachment(permissionAttachment);
    }

    @Override
    public void recalculatePermissions() {
        player.recalculatePermissions();
    }

    @Override
    public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return player.getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return player.isOp();
    }

    @Override
    public void setOp(boolean b) {
        player.setOp(b);
    }

    @Override
    public @NotNull PersistentDataContainer getPersistentDataContainer() {
        return player.getPersistentDataContainer();
    }

    @Override
    public void sendPluginMessage(@NotNull Plugin plugin, @NotNull String channel, @NotNull byte[] message) {
        player.sendPluginMessage(plugin, channel, message);
    }

    @Override
    public @NotNull Set<String> getListeningPluginChannels() {
        return player.getListeningPluginChannels();
    }

    @Override
    public float getAttackCooldown() {
        return player.getAttackCooldown();
    }

    @Override
    public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass) {
        return player.launchProjectile(aClass);
    }

    @Override
    public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass, @Nullable Vector vector) {
        return player.launchProjectile(aClass, vector);
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        return player.equals(o);
    }

    public void removeDisconnectingPlayer(Player player) {
        invoke("removeDisconnectingPlayer", player);
    }

    public CraftPlayer getCraftPlayer() {
        return this;
    }

    public Object getOBCCraftPlayer() {
        return craftPlayer;
    }

    public String toString() {
        return "CraftPlayer{name=" + getName() + "}";
    }
}
