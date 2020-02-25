package xyz.acrylicstyle.craftbukkit;

import org.bukkit.*;
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
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
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
import xyz.acrylicstyle.minecraft.EntityPlayer;

import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.util.*;

public class CraftPlayer implements Handler<EntityPlayer>, Player, LivingEntity {
    private Player player;

    public CraftPlayer(Player player) {
        this.player = player;
    }

    public Object getProfile() {
        try {
            return getHandle().getClass().getMethod("getProfile").invoke(getHandle());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
    }

    public EntityPlayer getHandle() {
        return EntityPlayer.fromCraftPlayer(this);
    }

    @Override
    @NotNull
    public org.bukkit.entity.Player.Spigot spigot() {
        throw new UnsupportedOperationException();
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
    public void playEffect(@NotNull Location location, @NotNull Effect effect, int i) {
        player.playEffect(location, effect, i);
    }

    @Override
    public <T> void playEffect(@NotNull Location location, @NotNull Effect effect, @Nullable T t) {
        player.playEffect(location, effect, t);
    }

    @Override
    public void sendBlockChange(@NotNull Location location, @NotNull Material material, byte b) {
        player.sendBlockChange(location, material, b);
    }

    @Override
    public void sendBlockChange(@NotNull Location location, @NotNull BlockData blockData) {
        player.sendBlockChange(location, blockData);
    }

    @Override
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

    }

    @Override
    public int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) throws IllegalArgumentException {

    }

    @Override
    public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) {

    }

    @Override
    public void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) {

    }

    @Override
    public void setPlayerTime(long l, boolean b) {

    }

    @Override
    public long getPlayerTime() {
        return 0;
    }

    @Override
    public long getPlayerTimeOffset() {
        return 0;
    }

    @Override
    public boolean isPlayerTimeRelative() {
        return false;
    }

    @Override
    public void resetPlayerTime() {

    }

    @Override
    public void setPlayerWeather(@NotNull WeatherType weatherType) {

    }

    @Override
    public @Nullable WeatherType getPlayerWeather() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void resetPlayerWeather() {

    }

    @Override
    public void giveExp(int i) {

    }

    @Override
    public void giveExpLevels(int i) {

    }

    @Override
    public float getExp() {
        return 0;
    }

    @Override
    public void setExp(float v) {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void setLevel(int i) {

    }

    @Override
    public int getTotalExperience() {
        return 0;
    }

    @Override
    public void setTotalExperience(int i) {

    }

    @Override
    public void sendExperienceChange(float v) {

    }

    @Override
    public void sendExperienceChange(float v, int i) {

    }

    @Override
    public float getExhaustion() {
        return 0;
    }

    @Override
    public void setExhaustion(float v) {

    }

    @Override
    public float getSaturation() {
        return 0;
    }

    @Override
    public void setSaturation(float v) {

    }

    @Override
    public int getFoodLevel() {
        return 0;
    }

    @Override
    public void setFoodLevel(int i) {

    }

    @Override
    public boolean getAllowFlight() {
        return false;
    }

    @Override
    public void setAllowFlight(boolean b) {

    }

    @Override
    public void hidePlayer(@NotNull Player player) {

    }

    @Override
    public void hidePlayer(@NotNull Plugin plugin, @NotNull Player player) {

    }

    @Override
    public void showPlayer(@NotNull Player player) {

    }

    @Override
    public void showPlayer(@NotNull Plugin plugin, @NotNull Player player) {

    }

    @Override
    public boolean canSee(@NotNull Player player) {
        return false;
    }

    @Override
    public boolean isFlying() {
        return false;
    }

    @Override
    public void setFlying(boolean b) {

    }

    @Override
    public void setFlySpeed(float v) throws IllegalArgumentException {

    }

    @Override
    public void setWalkSpeed(float v) throws IllegalArgumentException {

    }

    @Override
    public float getFlySpeed() {
        return 0;
    }

    @Override
    public float getWalkSpeed() {
        return 0;
    }

    @Override
    public void setTexturePack(@NotNull String s) {

    }

    @Override
    public void setResourcePack(@NotNull String s) {

    }

    @Override
    public void setResourcePack(@NotNull String s, @NotNull byte[] bytes) {

    }

    @Override
    public @NotNull Scoreboard getScoreboard() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setScoreboard(@NotNull Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {

    }

    @Override
    public boolean isHealthScaled() {
        return false;
    }

    @Override
    public void setHealthScaled(boolean b) {

    }

    @Override
    public void setHealthScale(double v) throws IllegalArgumentException {

    }

    @Override
    public double getHealthScale() {
        return 0;
    }

    @Override
    public @Nullable Entity getSpectatorTarget() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSpectatorTarget(@Nullable Entity entity) {

    }

    @Override
    public void sendTitle(@Nullable String s, @Nullable String s1) {

    }

    @Override
    public void sendTitle(@Nullable String s, @Nullable String s1, int i, int i1, int i2) {

    }

    @Override
    public void resetTitle() {

    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i) {

    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i) {

    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, @Nullable T t) {

    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, @Nullable T t) {

    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2) {

    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5) {

    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, @Nullable T t) {

    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, @Nullable T t) {

    }

    @Override
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, double v3) {

    }

    @Override
    public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6) {

    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, double v3, @Nullable T t) {

    }

    @Override
    public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, @Nullable T t) {

    }

    @Override
    public @NotNull AdvancementProgress getAdvancementProgress(@NotNull Advancement advancement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getClientViewDistance() {
        return 0;
    }

    @Override
    public @NotNull String getLocale() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateCommands() {

    }

    @Override
    public void openBook(@NotNull ItemStack itemStack) {

    }

    @Override
    public @NotNull Location getLocation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable Location getLocation(@Nullable Location location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setVelocity(@NotNull Vector vector) {

    }

    @Override
    public @NotNull Vector getVelocity() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public @NotNull BoundingBox getBoundingBox() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isOnGround() {
        return false;
    }

    @Override
    public @NotNull World getWorld() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRotation(float v, float v1) {

    }

    @Override
    public boolean teleport(@NotNull Location location) {
        return false;
    }

    @Override
    public boolean teleport(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
        return false;
    }

    @Override
    public boolean teleport(@NotNull Entity entity) {
        return false;
    }

    @Override
    public boolean teleport(@NotNull Entity entity, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
        return false;
    }

    @Override
    public @NotNull List<Entity> getNearbyEntities(double v, double v1, double v2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getEntityId() {
        return 0;
    }

    @Override
    public int getFireTicks() {
        return 0;
    }

    @Override
    public int getMaxFireTicks() {
        return 0;
    }

    @Override
    public void setFireTicks(int i) {

    }

    @Override
    public void remove() {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void sendMessage(@NotNull String s) {

    }

    @Override
    public void sendMessage(@NotNull String[] strings) {

    }

    @Override
    public @NotNull Server getServer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPersistent() {
        return false;
    }

    @Override
    public void setPersistent(boolean b) {

    }

    @Override
    public @Nullable Entity getPassenger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setPassenger(@NotNull Entity entity) {
        return false;
    }

    @Override
    public @NotNull List<Entity> getPassengers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addPassenger(@NotNull Entity entity) {
        return false;
    }

    @Override
    public boolean removePassenger(@NotNull Entity entity) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean eject() {
        return false;
    }

    @Override
    public float getFallDistance() {
        return 0;
    }

    @Override
    public void setFallDistance(float v) {

    }

    @Override
    public void setLastDamageCause(@Nullable EntityDamageEvent entityDamageEvent) {

    }

    @Override
    public @Nullable EntityDamageEvent getLastDamageCause() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull UUID getUniqueId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getTicksLived() {
        return 0;
    }

    @Override
    public void setTicksLived(int i) {

    }

    @Override
    public void playEffect(@NotNull EntityEffect entityEffect) {

    }

    @Override
    public @NotNull EntityType getType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInsideVehicle() {
        return false;
    }

    @Override
    public boolean leaveVehicle() {
        return false;
    }

    @Override
    public @Nullable Entity getVehicle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCustomNameVisible(boolean b) {

    }

    @Override
    public boolean isCustomNameVisible() {
        return false;
    }

    @Override
    public void setGlowing(boolean b) {

    }

    @Override
    public boolean isGlowing() {
        return false;
    }

    @Override
    public void setInvulnerable(boolean b) {

    }

    @Override
    public boolean isInvulnerable() {
        return false;
    }

    @Override
    public boolean isSilent() {
        return false;
    }

    @Override
    public void setSilent(boolean b) {

    }

    @Override
    public boolean hasGravity() {
        return false;
    }

    @Override
    public void setGravity(boolean b) {

    }

    @Override
    public int getPortalCooldown() {
        return 0;
    }

    @Override
    public void setPortalCooldown(int i) {

    }

    @Override
    public @NotNull Set<String> getScoreboardTags() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addScoreboardTag(@NotNull String s) {
        return false;
    }

    @Override
    public boolean removeScoreboardTag(@NotNull String s) {
        return false;
    }

    @Override
    public @NotNull PistonMoveReaction getPistonMoveReaction() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull BlockFace getFacing() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull Pose getPose() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public boolean isBanned() {
        return false;
    }

    @Override
    public boolean isWhitelisted() {
        return false;
    }

    @Override
    public void setWhitelisted(boolean b) {

    }

    @Override
    public @Nullable Player getPlayer() {
        return player.getPlayer();
    }

    @Override
    public long getFirstPlayed() {
        return 0;
    }

    @Override
    public long getLastPlayed() {
        return 0;
    }

    @Override
    public boolean hasPlayedBefore() {
        return false;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull PlayerInventory getInventory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull Inventory getEnderChest() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull MainHand getMainHand() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setWindowProperty(InventoryView.@NotNull Property property, int i) {
        return false;
    }

    @Override
    public @NotNull InventoryView getOpenInventory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable InventoryView openInventory(@NotNull Inventory inventory) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable InventoryView openWorkbench(@Nullable Location location, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable InventoryView openEnchanting(@Nullable Location location, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void openInventory(@NotNull InventoryView inventoryView) {

    }

    @Override
    public @Nullable InventoryView openMerchant(@NotNull Villager villager, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable InventoryView openMerchant(@NotNull Merchant merchant, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void closeInventory() {

    }

    @Override
    public @NotNull ItemStack getItemInHand() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setItemInHand(@Nullable ItemStack itemStack) {

    }

    @Override
    public @NotNull ItemStack getItemOnCursor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setItemOnCursor(@Nullable ItemStack itemStack) {

    }

    @Override
    public boolean hasCooldown(@NotNull Material material) {
        return false;
    }

    @Override
    public int getCooldown(@NotNull Material material) {
        return 0;
    }

    @Override
    public void setCooldown(@NotNull Material material, int i) {

    }

    @Override
    public int getSleepTicks() {
        return 0;
    }

    @Override
    public @Nullable Location getBedSpawnLocation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setBedSpawnLocation(@Nullable Location location) {

    }

    @Override
    public void setBedSpawnLocation(@Nullable Location location, boolean b) {

    }

    @Override
    public boolean sleep(@NotNull Location location, boolean b) {
        return false;
    }

    @Override
    public void wakeup(boolean b) {

    }

    @Override
    public @NotNull Location getBedLocation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull GameMode getGameMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setGameMode(@NotNull GameMode gameMode) {

    }

    @Override
    public boolean isBlocking() {
        return false;
    }

    @Override
    public boolean isHandRaised() {
        return false;
    }

    @Override
    public int getExpToLevel() {
        return 0;
    }

    @Override
    public boolean discoverRecipe(@NotNull NamespacedKey namespacedKey) {
        return false;
    }

    @Override
    public int discoverRecipes(@NotNull Collection<NamespacedKey> collection) {
        return 0;
    }

    @Override
    public boolean undiscoverRecipe(@NotNull NamespacedKey namespacedKey) {
        return false;
    }

    @Override
    public int undiscoverRecipes(@NotNull Collection<NamespacedKey> collection) {
        return 0;
    }

    @Override
    public @Nullable Entity getShoulderEntityLeft() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setShoulderEntityLeft(@Nullable Entity entity) {

    }

    @Override
    public @Nullable Entity getShoulderEntityRight() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setShoulderEntityRight(@Nullable Entity entity) {

    }

    @Override
    public double getEyeHeight() {
        return 0;
    }

    @Override
    public double getEyeHeight(boolean b) {
        return 0;
    }

    @Override
    public @NotNull Location getEyeLocation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull List<Block> getLineOfSight(@Nullable Set<Material> set, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull Block getTargetBlock(@Nullable Set<Material> set, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull List<Block> getLastTwoTargetBlocks(@Nullable Set<Material> set, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable Block getTargetBlockExact(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable Block getTargetBlockExact(int i, @NotNull FluidCollisionMode fluidCollisionMode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable RayTraceResult rayTraceBlocks(double v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable RayTraceResult rayTraceBlocks(double v, @NotNull FluidCollisionMode fluidCollisionMode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getRemainingAir() {
        return 0;
    }

    @Override
    public void setRemainingAir(int i) {

    }

    @Override
    public int getMaximumAir() {
        return 0;
    }

    @Override
    public void setMaximumAir(int i) {

    }

    @Override
    public int getMaximumNoDamageTicks() {
        return 0;
    }

    @Override
    public void setMaximumNoDamageTicks(int i) {

    }

    @Override
    public double getLastDamage() {
        return 0;
    }

    @Override
    public void setLastDamage(double v) {

    }

    @Override
    public int getNoDamageTicks() {
        return 0;
    }

    @Override
    public void setNoDamageTicks(int i) {

    }

    @Override
    public @Nullable Player getKiller() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addPotionEffect(@NotNull PotionEffect potionEffect) {
        return false;
    }

    @Override
    public boolean addPotionEffect(@NotNull PotionEffect potionEffect, boolean b) {
        return false;
    }

    @Override
    public boolean addPotionEffects(@NotNull Collection<PotionEffect> collection) {
        return false;
    }

    @Override
    public boolean hasPotionEffect(@NotNull PotionEffectType potionEffectType) {
        return false;
    }

    @Override
    public @Nullable PotionEffect getPotionEffect(@NotNull PotionEffectType potionEffectType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removePotionEffect(@NotNull PotionEffectType potionEffectType) {

    }

    @Override
    public @NotNull Collection<PotionEffect> getActivePotionEffects() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasLineOfSight(@NotNull Entity entity) {
        return false;
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        return false;
    }

    @Override
    public void setRemoveWhenFarAway(boolean b) {

    }

    @Override
    public @Nullable EntityEquipment getEquipment() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCanPickupItems(boolean b) {

    }

    @Override
    public boolean getCanPickupItems() {
        return false;
    }

    @Override
    public boolean isLeashed() {
        return false;
    }

    @Override
    public @NotNull Entity getLeashHolder() throws IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setLeashHolder(@Nullable Entity entity) {
        return false;
    }

    @Override
    public boolean isGliding() {
        return false;
    }

    @Override
    public void setGliding(boolean b) {

    }

    @Override
    public boolean isSwimming() {
        return false;
    }

    @Override
    public void setSwimming(boolean b) {

    }

    @Override
    public boolean isRiptiding() {
        return false;
    }

    @Override
    public boolean isSleeping() {
        return false;
    }

    @Override
    public void setAI(boolean b) {

    }

    @Override
    public boolean hasAI() {
        return false;
    }

    @Override
    public void setCollidable(boolean b) {

    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public <T> @Nullable T getMemory(@NotNull MemoryKey<T> memoryKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @Nullable T t) {

    }

    @Override
    public @Nullable AttributeInstance getAttribute(@NotNull Attribute attribute) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void damage(double v) {

    }

    @Override
    public void damage(double v, @Nullable Entity entity) {

    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void setHealth(double v) {

    }

    @Override
    public double getAbsorptionAmount() {
        return 0;
    }

    @Override
    public void setAbsorptionAmount(double v) {

    }

    @Override
    public double getMaxHealth() {
        return 0;
    }

    @Override
    public void setMaxHealth(double v) {

    }

    @Override
    public void resetMaxHealth() {

    }

    @Override
    public @Nullable String getCustomName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCustomName(@Nullable String s) {

    }

    @Override
    public void setMetadata(@NotNull String s, @NotNull MetadataValue metadataValue) {

    }

    @Override
    public @NotNull List<MetadataValue> getMetadata(@NotNull String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasMetadata(@NotNull String s) {
        return false;
    }

    @Override
    public void removeMetadata(@NotNull String s, @NotNull Plugin plugin) {

    }

    @Override
    public boolean isPermissionSet(@NotNull String s) {
        return false;
    }

    @Override
    public boolean isPermissionSet(@NotNull Permission permission) {
        return false;
    }

    @Override
    public boolean hasPermission(@NotNull String s) {
        return false;
    }

    @Override
    public boolean hasPermission(@NotNull Permission permission) {
        return false;
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String s, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String s, boolean b, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAttachment(@NotNull PermissionAttachment permissionAttachment) {

    }

    @Override
    public void recalculatePermissions() {

    }

    @Override
    public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isOp() {
        return false;
    }

    @Override
    public void setOp(boolean b) {

    }

    @Override
    public @NotNull PersistentDataContainer getPersistentDataContainer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendPluginMessage(@NotNull Plugin plugin, @NotNull String s, @NotNull byte[] bytes) {

    }

    @Override
    public @NotNull Set<String> getListeningPluginChannels() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass, @Nullable Vector vector) {
        throw new UnsupportedOperationException();
    }
}
