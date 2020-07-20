package xyz.acrylicstyle.minecraft.v1_8_R1;

import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityHuman;

public class EntityLiving extends Entity implements xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityLiving {
    public EntityLiving(Object o) { this(o, "EntityLiving"); }

    public EntityLiving(String clazz) {
        super(clazz);
    }

    public EntityLiving(Object o, String clazz) {
        super(o, clazz);
    }

    public EntityLiving(String clazz, Object... args) {
        super(clazz, args);
    }

    @Override
    public int getMaxNoDamageTicks() {
        return field("maxNoDamageTicks");
    }

    @Override
    public void setMaxNoDamageTicks(int ticks) {
        setField("maxNoDamageTicks", ticks);
    }

    @Override
    public @Nullable EntityHuman getKiller() {
        Object killer = getField("killer");
        if (killer == null) return null;
        return new xyz.acrylicstyle.minecraft.v1_8_R1.EntityHuman(killer);
    }

    @Override
    public void setKiller(@Nullable EntityHuman entityHuman) {
        setField("killer", entityHuman == null ? null : entityHuman.getHandle());
    }

    @Override
    public float getLastDamage() {
        return field("lastDamage");
    }

    @Override
    public void setLastDamage(float damage) {
        setField("lastDamage", damage);
    }

    @Override
    public @Nullable xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityLiving getLastDamager() {
        Object damager = getField("lastDamager");
        if (damager == null) return null;
        return new xyz.acrylicstyle.minecraft.v1_8_R1.EntityLiving(damager);
    }

    @Override
    public void setLastDamager(@Nullable xyz.acrylicstyle.nmsapi.abstracts.minecraft.EntityLiving entityLiving) {
        setField("lastDamager", entityLiving == null ? null : entityLiving.getHandle());
    }

    @Override
    public int getMaxAirTicks() {
        return field("maxAirTicks");
    }

    @Override
    public void setMaxAirTicks(int maxAirTicks) {
        setField("maxAirTicks", maxAirTicks);
    }

    @Override
    public void killByVoid() {
        invoke("G");
    }

    @Override
    public boolean isBaby() {
        return (boolean) invoke("isBaby");
    }

    @Override
    public boolean isNotBaby() {
        return !isBaby();
    }

    @Override
    public float getAbsorptionHearts() {
        return (float) invoke("getAbsorptionHearts");
    }

    @Override
    public void setAbsorptionHearts(float hearts) {
        invoke("setAbsorptionHearts", hearts);
    }

    @Override
    public float getHealth() {
        return (float) invoke("getHealth");
    }

    @Override
    public void setHealth(float health) {
        invoke("setHealth", health);
    }

    @Override
    public void removeAllEffects() {
        invoke("removeAllEffects");
    }

    @Override
    public void heal(float health) {
        invoke("heal", health);
    }

    @Override
    public void heal(float health, EntityRegainHealthEvent.RegainReason reason) {
        invoke("heal", health, reason);
    }
}
