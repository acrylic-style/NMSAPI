package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.reflect.Ref;
import xyz.acrylicstyle.nmsapi.abstracts.utils.CraftUtils;
import xyz.acrylicstyle.shared.NMSAPI;

public interface EntityLiving extends Entity {
    /**
     * Obtain the instance of EntityLiving.
     * @param entity the entity
     * @return the instance of EntityLiving.
     */
    @NotNull
    static EntityLiving getInstance(@NotNull LivingEntity entity) {
        Validate.notNull(entity, "entity cannot be null");
        return (EntityLiving) Ref.forName(NMSAPI.getClassPrefix() + "EntityLiving").getConstructor(Object.class).newInstance(CraftUtils.getHandle(entity));
    }

    /**
     * Get maximum invulnerable ticks of the entity.
     * @return maximum invulnerable ticks
     */
    int getMaxNoDamageTicks();

    /**
     * Set maximum invulnerable ticks of the entity.
     * @param ticks maximum invulnerable ticks
     */
    void setMaxNoDamageTicks(int ticks);

    /**
     * Get a human who killed this entity.
     * @return the human who killed this entity
     */
    @Nullable
    EntityHuman getKiller();

    /**
     * Set a human who killed this entity.
     * @param entityHuman the human who killed this entity
     */
    void setKiller(@Nullable EntityHuman entityHuman);

    /**
     * Get last damage dealt by something.
     * @return last damage
     */
    float getLastDamage();

    /**
     * Set last damage dealt by something.
     * @param damage last damage
     */
    void setLastDamage(float damage);

    /**
     * Get a human who hurt this entity.
     * @return the human who hurt this entity
     */
    @Nullable
    EntityLiving getLastDamager();

    /**
     * Set a human who hurt this entity.
     * @param entityLiving the human who hurt this entity
     */
    void setLastDamager(@Nullable EntityLiving entityLiving);

    /**
     * Get max air ticks.
     * @return max air ticks
     */
    int getMaxAirTicks();

    /**
     * Set max air ticks.
     * @param maxAirTicks max air ticks
     */
    void setMaxAirTicks(int maxAirTicks);

    /**
     * Called by server when ticking while the entity is inactive.
     */
    void inactiveTick();

    /**
     * Deals infinite amount of damage with void damage and kills player forcefully.
     */
    void killByVoid();

    /**
     * @return whether this entity is baby or not
     */
    boolean isBaby();

    /**
     * @return whether this entity is <b>not</b> baby or not
     */
    boolean isNotBaby();

    /**
     * Get absorption hearts of this entity.
     * @return absorption hearts
     */
    float getAbsorptionHearts();

    /**
     * Set absorption hearts of this entity.
     * @param hearts absorption hearts
     */
    void setAbsorptionHearts(float hearts);

    /**
     * Get head rotation of this entity.
     * @return head rotation
     */
    float getHeadRotation();

    /**
     * Get the health of this entity
     * @return the health
     */
    float getHealth();

    /**
     * Set the health of this entity
     * @param health the health
     */
    void setHealth(float health);

    /**
     * Removes all potion effects.
     */
    void removeAllEffects();

    void heal(float health);

    void heal(float health, EntityRegainHealthEvent.RegainReason reason);
}
