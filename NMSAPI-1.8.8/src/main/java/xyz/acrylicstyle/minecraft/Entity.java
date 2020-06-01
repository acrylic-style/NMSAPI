package xyz.acrylicstyle.minecraft;

import org.bukkit.Location;
import org.bukkit.projectiles.ProjectileSource;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.spigotmc.CustomTimingsHandler;
import util.ICollectionList;
import util.SneakyThrow;
import util.reflect.Ref;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.entity.CraftEntity;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.Random;
import java.util.UUID;
import java.util.function.Function;

@SuppressWarnings("unused")
public class Entity extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("Entity");

    public Entity(String clazz) {
        super(clazz);
    }

    public Entity(Object o, String clazz) {
        super(o, clazz);
    }

    public Entity(String clazz, Object... args) {
        super(clazz, args);
    }

    public Entity(Object o) {
        super(o, "Entity");
    }

    public static boolean isLevelAtLeast(NBTTagCompound tag, int level) {
        return (tag.hasKey("Bukkit.updateLevel") && tag.getInt("Bukkit.updateLevel") >= level);
    }

    public static final int CURRENT_LEVEL = 2;

    public int id() {
        try {
            return (int) Ref.getField(CLASS, "id").getField().get(getHandle());
        } catch (IllegalAccessException e) {
            SneakyThrow.sneaky(e);
            return 0; // unreachable
        }
    }
    public double j() { return field("j"); }
    public boolean k() { return field("k"); }
    public Entity passenger() { return new Entity(getField("passenger")); }
    public Entity vehicle() { return new Entity(getField("vehicle")); }
    public boolean attachedToPlayer() { return field("attachedToPlayer"); }
    public World world() { return World.newInstance(getField("world")); }
    public double lastX() { return field("lastX"); }
    public double lastY() { return field("lastY"); }
    public double lastZ() { return field("lastZ"); }
    public double locX() { return field("locX"); }
    public double locY() { return field("locY"); }
    public double locZ() { return field("locZ"); }
    public double motX() { return field("motX"); }
    public double motY() { return field("motY"); }
    public double motZ() { return field("motZ"); }
    public float yaw() { return field("yaw"); }
    public float pitch() { return field("pitch"); }
    public float lastYaw() { return field("lastYaw"); }
    public float lastPitch() { return field("lastPitch"); }
    public boolean onGround() { return field("onGround"); }
    public boolean positionChanged() { return field("positionChanged"); }
    public boolean E() { return field("E"); }
    public boolean F() { return field("F"); }
    public boolean velocityChanged() { return field("velocityChanged"); }
    public boolean H() { return field("H"); }
    public boolean g() { return field("g"); }
    public boolean dead() { return field("dead"); }
    public float width() { return field("width"); }
    public float length() { return field("length"); }
    public float getL() { return field("L"); }
    public float M() { return field("M"); }
    public float N() { return field("N"); }
    public float fallDistance() { return field("fallDistance"); }
    public int getH() { return field("h"); }
    public double getP() { return field("P"); }
    public double getQ() { return field("Q"); }
    public double getR() { return field("R"); }
    public float S() { return field("S"); }
    public boolean noclip() { return field("noclip"); }
    public float getU() { return field("U"); }
    public Random random() { return field("random"); }
    public int ticksLived() { return field("ticksLived"); }
    public int maxFireTicks() { return field("maxFireTicks"); }
    public int fireTicks() { return field("fireTicks"); }
    public boolean inWater() { return field("inWater"); }
    public int noDamageTicks() { return field("noDamageTicks"); }
    public boolean justCreated() { return field("justCreated"); }
    public boolean fireProof() { return field("fireProof"); }
    public double ar() { return field("ar"); }
    public double as() { return field("as"); }
    public boolean isAd() { return field("ad"); }
    public int getAe() { return field("ae"); }
    public int getAf() { return field("af"); }
    public int getAg() { return field("ag"); }
    public boolean getAh() { return field("ah"); }
    public boolean ai() { return field("ai"); }
    public int portalCooldown() { return field("portalCooldown"); }
    public boolean isAk() { return field("ak"); }
    public int getAl() { return field("al"); }
    public int dimension() { return field("dimension"); }
    public BlockPosition getAn() { return new BlockPosition(getField("an")); }
    public Vec3D getAo() { return new Vec3D(getField("ao")); }
    public EnumDirection getAp() { return EnumDirection.valueOf(((Enum<?>) getField("ap")).name()); }
    public boolean invulnerable() { return field("invulnerable"); }
    public UUID uniqueID() { return field("uniqueID"); }
    public boolean valid() { return field("valid"); }
    public ProjectileSource projectileSource() { return field("projectileSource"); }
    public boolean forceExplosionKnockback() { return field("forceExplosionKnockback"); }

    public boolean isAddedToChunk() {
        return ad();
    }

    public CustomTimingsHandler tickTimer() { return field("tickTimer"); }
    public final byte activationType() { return field("activationType"); }
    public final boolean defaultActivationState() { return field("defaultActivationState"); }
    public long activatedTick() { return field("activatedTick"); }
    public boolean fromMobSpawner() { return field("fromMobSpawner"); }
    public int numCollisions() { return field("numCollisions"); }

    public void inactiveTick() { invoke("inactiveTick"); }

    public int getId() {
        return this.id();
    }

    public void d(int i) {
        invoke("d", i);
    }

    public void G() {
        invoke("G");
    }

    public boolean equals(Object o) {
        return (o instanceof Entity) && ((((Entity) o).id() == this.id()));
    }

    public int hashCode() {
        return this.id();
    }

    public void die() {
        invoke("die");
    }

    public void setSize(float f, float f1) {
        invoke("setSize", f, f1);
    }

    public void setYawPitch(float f, float f1) {
        invoke("setYawPitch", f, f1);
    }

    public void setPosition(double d0, double d1, double d2) {
        invoke("setPosition", d0, d1, d2);
    }

    public void T_() {
        invoke("T_");
    }

    public void K() {
        invoke("K");
    }

    public int L() {
        return (int) invoke("L");
    }

    public void burnFromLava() {
        invoke("burnFromLava");
    }

    public void setOnFire(int i) {
        invoke("setOnFire", i);
    }

    public void extinguish() {
        invoke("extinguish");
    }

    public void O() {
        invoke("O");
    }

    public boolean c(double d0, double d1, double d2) {
        return (boolean) invoke("c", d0, d1, d2);
    }

    public void move(double d0, double d1, double d2) {
        invoke("move", d0, d1, d2);
    }

    public String P() {
        return (String) invoke("P");
    }

    public void checkBlockCollisions() {
        invoke("checkBlockCollisions");
    }

    // public void a(BlockPosition blockPosition, Block block) {}

    public void makeSound(String s, float f, float f1) {
        invoke("makeSound", s, f, f1);
    }

    public boolean R() {
        return (boolean) invoke("R");
    }

    public void b(boolean flag) {
        invoke("b", flag);
    }

    public boolean s_() {
        return (boolean) invoke("s_");
    }

    // public void a(double d0, boolean flag, Block block, BlockPosition blockPosition) {}

    // public AxisAlignedBB S() {}

    public void burn(float i) {
        invoke("burn", i);
    }

    public boolean isFireProof() {
        return field("fireProof");
    }

    public void e(float f, float f1) {
        invoke("e", f, f1);
    }

    public boolean U() {
        return (boolean) invoke("U");
    }

    public boolean V() {
        return field("inWater");
    }

    public boolean W() {
        return (boolean) invoke("W");
    }

    public void X() {
        invoke("X");
    }

    public void Y() {
        invoke("Y");
    }

    public void Z() {
        invoke("Z");
    }

    public String aa() {
        return (String) invoke("aa");
    }

    // public boolean a(Material material) {}

    public boolean ab() {
        return (boolean) invoke("ab");
    }

    public void a(float f, float f1, float f2) {
        invoke("a", f, f1, f2);
    }

    public float c(float f) {
        return (float) invoke("c", f);
    }

    public void spawnIn(World world) {
        invoke("spawnIn", world.getHandle());
    }

    public void setLocation(double x, double y, double z, float yaw, float pitch) {
        invoke("setLocation", x, y, z, yaw, pitch);
    }

    public void setPositionRotation(BlockPosition blockPosition, float yaw, float pitch) {
        invoke("setPositionRotation", blockPosition.getHandle(), yaw, pitch);
    }

    public void setPositionRotation(double x, double y, double z, float yaw, float pitch) {
        invoke("setPositionRotation", x, y, z, yaw, pitch);
    }

    public float g(Entity entity) {
        return (float) invoke("g", entity.getHandle());
    }

    public double e(double d0, double d1, double d2) {
        return (double) invoke("e", d0, d1, d2);
    }

    public double b(BlockPosition blockPosition) {
        return (double) invoke("b", blockPosition.getHandle());
    }

    public double c(BlockPosition blockPosition) {
        return (double) invoke("c", blockPosition.getHandle());
    }

    public double f(double d0, double d1, double d2) {
        return (double) invoke("f", d0, d1, d2);
    }

    public double h(Entity entity) {
        return (double) invoke("h", entity.getHandle());
    }

    // public void d(EntityHuman entityHuman) {}

    public Entity(World world) {
        super("Entity", world.getHandle());
    }

    public void collide(Entity entity) {
        invoke("collide", entity.getHandle());
    }

    public void g(double d0, double d1, double d2) {
        invoke("g", d0, d1, d2);
    }

    public void ac() {
        setField("velocityChanged", true);
    }

    // public boolean damageEntity(DamageSource damageSource, float f) {}

    public Vec3D d(float f) {
        return new Vec3D(invoke("d", f));
    }

    public Vec3D f(float f, float f1) {
        return new Vec3D(invoke("f", f, f1));
    }

    public boolean ad() {
        return (boolean) invoke("ad");
    }

    public boolean ae() {
        return (boolean) invoke("ae");
    }

    public void b(Entity entity, int i) {
        invoke("b", entity.getHandle(), i);
    }

    public boolean c(NBTTagCompound tag) {
        return (boolean) invoke("c", tag.getHandle());
    }

    public boolean save(NBTTagCompound tag) {
        return c(tag);
    }

    public boolean d(NBTTagCompound tag) {
        return (boolean) invoke("d", tag.getHandle());
    }

    public void e(NBTTagCompound tag) {
        invoke("e", tag.getHandle());
    }

    public void load(NBTTagCompound tag) {
        f(tag);
    }

    public boolean af() {
        return (boolean) invoke("af");
    }

    public String ag() {
        return (String) invoke("ag");
    }

    public void ah() { invoke("ah"); }

    @SuppressWarnings("RedundantCast")
    public NBTTagList a(double... aDouble) {
        return new NBTTagList(invoke("a", (Object) aDouble));
    }

    @SuppressWarnings("RedundantCast")
    public NBTTagList a(float... floats) {
        return new NBTTagList(invoke("a", (Object) floats));
    }

    // public EntityItem a(Item item, int i) {}

    // public EntityItem a(Item item, int i, float f) {}

    // public EntityItem a(ItemStack itemStack, float f) {}

    public boolean isAlive() {
        return (boolean) invoke("isAlive");
    }

    public boolean inBlock() {
        return (boolean) invoke("inBlock");
    }

    // public boolean e(EntityHuman entityHuman) {}

    public void f(NBTTagCompound tag) {
        invoke("f", tag.getHandle());
    }

    // public AxisAlignedBB j(Entity entity) {}

    public void ak() {
        invoke("ak");
    }

    public void al() {
        invoke("al");
    }

    public double am() {
        return (double) invoke("am");
    }

    public double an() {
        return (double) invoke("an");
    }

    public CraftEntity getBukkitEntity() {
        return new CraftEntity(invoke("getBukkitEntity"));
    }

    public void mount(Entity entity) {
        invoke("mount", entity.getHandle());
    }

    public float ao() {
        return (float) invoke("ao");
    }

    public Vec3D ap() {
        return Vec3D.newInstance(invoke("ap"));
    }

    public void d(BlockPosition blockPosition) {
        invoke("d", blockPosition.getHandle());
    }

    public int aq() {
        return (int) invoke("aq");
    }

    public ItemStack[] getEquipment() {
        return ICollectionList.asList((Object[]) invoke("getEquipment")).map(ItemStack::new).valuesArray();
    }

    public void setEquipment(int i, ItemStack itemStack) {
        invoke("setEquipment", i, itemStack.getHandle());
    }

    public boolean isBurning() {
        return (boolean) invoke("isBurning");
    }

    public boolean au() {
        return (boolean) invoke("au");
    }

    public boolean isSneaking() {
        return (boolean) invoke("isSneaking");
    }

    public void setSneaking(boolean flag) {
        invoke("setSneaking", flag);
    }

    public boolean isSprinting() {
        return (boolean) invoke("isSprinting");
    }

    public void setSprinting(boolean flag) {
        invoke("setSprinting", flag);
    }

    public boolean isInvisible() {
        return (boolean) invoke("isInvisible");
    }

    public void setInvisible(boolean flag) {
        invoke("setInvisible", flag);
    }

    public void f(boolean flag) {
        invoke("f", flag);
    }

    public boolean g(int i) {
        return (boolean) invoke("g", i);
    }

    public void b(int i, boolean flag) {
        invoke("b", i, flag);
    }

    public int getAirTicks() {
        return (int) invoke("getAirTicks");
    }

    public void setAirTicks(int i) {
        invoke("setAirTicks", i);
    }

    // public void onLightningStrike(EntityLightning entityLightning) {}

    // public void a(EntityLiving entityLiving) {}

    public boolean j(double d0, double d1, double d2) {
        return (boolean) invoke("j", d0, d1, d2);
    }

    public void aA() {
        invoke("aA");
    }

    public String getName() {
        return (String) invoke("getName");
    }

    public Entity[] aB() {
        Object o = invoke("aB");
        return o != null ? ICollectionList.asList((Object[]) o).map((Function<Object, Entity>) Entity::new).valuesArray() : null;
    }

    public boolean k(Entity entity) {
        return (boolean) invoke("k", entity.getHandle());
    }

    public float getHeadRotation() {
        return (float) invoke("getHeadRotation");
    }

    public void f(float f) {
        invoke("f", f);
    }

    public void g(float f) {
        invoke("g", f);
    }

    public boolean aD() {
        return (boolean) invoke("aD");
    }

    public boolean l(Entity entity) {
        return (boolean) invoke("l", entity.getHandle());
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    // public boolean isInvulnerable(DamageSource damageSource) {}

    public void m(Entity entity) {
        invoke("m", entity.getHandle());
    }

    public void n(Entity entity) {
        invoke("n", entity.getHandle());
    }

    public void c(int i) {
        invoke("c", i);
    }

    public void teleportTo(Location exit, boolean portal) {
        invoke("teleportTo", exit, portal);
    }

    // public float a(Explosion explosion, World world, BlockPosition blockPosition, IBlockData iBlockData) {}

    // public boolean a(Explosion explosion, World world, BlockPosition blockPosition, IBlockData iBlockData, float f) {}

    public int aE() {
        return (int) invoke("aE");
    }

    public Vec3D aG() {
        return new Vec3D(invoke("aG"));
    }

    public EnumDirection aH() {
        return EnumDirection.valueOf(((Enum<?>) invoke("aH")).name());
    }

    public boolean aI() {
        return (boolean) invoke("aI");
    }

    public void appendEntityCrashDetails(CrashReportSystemDetails crashReportSystemDetails) {
        invoke("appendEntityCrashDetails", crashReportSystemDetails.getHandle());
    }

    public UUID getUniqueID() {
        return (UUID) invoke("getUniqueID");
    }

    public boolean aL() {
        return (boolean) invoke("aL");
    }

    public IChatBaseComponent getScoreboardDisplayName() {
        return new ChatComponentText(invoke("getScoreboardDisplayName"));
    }

    public void setCustomName(String s) {
        invoke("setCustomName", s);
    }

    public String getCustomName() {
        return (String) invoke("getCustomName");
    }

    public boolean hasCustomName() {
        return (boolean) invoke("hasCustomName");
    }

    public void setCustomNameVisible(boolean flag) {
        invoke("setCustomNameVisible", flag);
    }

    public boolean getCustomNameVisible() {
        return (boolean) invoke("getCustomNameVisible");
    }

    public void enderTeleportTo(double d0, double d1, double d2) {
        invoke("enderTeleportTo", d0, d1, d2);
    }

    public void i(int i) { invoke("i", i); }

    public EnumDirection getDirection() {
        return EnumDirection.valueOf(((Enum<?>) invoke("getDirection")).name());
    }

    // public ChatHoverable aQ() {}

    public boolean a(EntityPlayer entityPlayer) {
        return (boolean) invoke("a", entityPlayer.getNMSClass());
    }

    // public AxisAlignedBB getBoundingBox() {}

    // public void a(AxisAlignedBB axisAlignedBB) {}

    public float getHeadHeight() {
        return (float) invoke("getHeadHeight");
    }

    public boolean aT() {
        return (boolean) invoke("aT");
    }

    public void h(boolean flag) {
        invoke("h", flag);
    }

    public boolean d(int i, ItemStack itemStack) {
        return (boolean) invoke("d", i, itemStack.getHandle());
    }

    public void sendMessage(IChatBaseComponent iChatBaseComponent) {
        invoke("sendMessage", iChatBaseComponent.getHandle());
    }

    public boolean a(int i, String s) {
        return (boolean) invoke("a", i, s);
    }

    public BlockPosition getChunkCoordinates() {
        return new BlockPosition(invoke("getChunkCoordinates"));
    }

    public Vec3D d() {
        return new Vec3D(invoke("d"));
    }

    public World getWorld() {
        return World.newInstance(invoke("getWorld"));
    }

    @Contract("-> this")
    public Entity f() {
        return this;
    }

    public boolean getSendCommandFeedback() {
        return (boolean) invoke("getSendCommandFeedback");
    }

    // public void a(CommandObjectiveExecutor.EnumCommandResult enumCommandResult, int i) {}

    // public CommandObjectiveExecutor aU() {}

    public void o(Entity entity) {
        invoke("o", entity.getHandle());
    }

    @NotNull
    public NBTTagCompound getNBTTag() {
        Object tag = invoke("getNBTTag");
        return tag == null ? new NBTTagCompound() : new NBTTagCompound(tag);
    }

    // public boolean a(EntityHuman entityHuman, Vec3D vec3D) {}

    public boolean aW() {
        return (boolean) invoke("aW");
    }

    // public void a(EntityLiving entityLiving, Entity entity) {}

    /* Abstract methods */

    public void h() {}

    public void a(NBTTagCompound tag) {}

    public void b(NBTTagCompound tag) {}
}
