package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.jetbrains.annotations.NotNull;
import util.StringCollection;
import xyz.acrylicstyle.shared.NMSAPI;

public class DamageSource extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("DamageSource");

    protected DamageSource(@NotNull Object o) {
        super(o, "DamageSource");
    }

    @NotNull
    private static final StringCollection<DamageSource> cache = new StringCollection<>();

    @NotNull
    public static DamageSource getInstance(@NotNull String fieldName) {
        fieldName = fieldName.toUpperCase();
        DamageSource cached = cache.get(fieldName);
        if (cached != null) return cached;
        try {
            DamageSource ds = new DamageSource(CLASS.getField(fieldName).get(null));
            cache.add(fieldName, ds);
            return ds;
        } catch (ReflectiveOperationException e) {
            throw new UnsupportedOperationException("DamageSource." + fieldName + " is not supported in this minecraft version");
        }
    }

    // These DamageSources can be used at any versions //

    @NotNull public static DamageSource fire() { return getInstance("FIRE"); }

    @NotNull public static DamageSource lightning() { return getInstance("LIGHTNING"); }

    @NotNull public static DamageSource burn() { return getInstance("burn"); }

    @NotNull public static DamageSource lava() { return getInstance("LAVA"); }

    @NotNull public static DamageSource stuck() { return getInstance("STUCK"); }

    @NotNull public static DamageSource drown() { return getInstance("DROWN"); }

    @NotNull public static DamageSource starve() { return getInstance("STARVE"); }

    @NotNull public static DamageSource cactus() { return getInstance("CACTUS"); }

    @NotNull public static DamageSource fall() { return getInstance("FALL"); }

    @NotNull public static DamageSource outOfWorld() { return getInstance("OUT_OF_WORLD"); }

    @NotNull public static DamageSource generic() { return getInstance("GENERIC"); }

    @NotNull public static DamageSource magic() { return getInstance("MAGIC"); }

    @NotNull public static DamageSource wither() { return getInstance("WITHER"); }

    @NotNull public static DamageSource anvil() { return getInstance("ANVIL"); }

    @NotNull public static DamageSource fallingBlock() { return getInstance("FALLING_BLOCK"); }

    // These DamageSources may not be available at older versions //

    @NotNull public static DamageSource sweetBerryBush() { return getInstance("SWEET_BERRY_BUSH"); }

    @NotNull public static DamageSource dryout() { return getInstance("DRYOUT"); }

    @NotNull public static DamageSource dragonBreath() { return getInstance("DRAGON_BREATH"); }

    @NotNull public static DamageSource fireworks() { return getInstance("FIREWORKS"); }

    @NotNull public static DamageSource flyIntoWall() { return getInstance("FLY_INTO_WALL"); }

    @NotNull public static DamageSource hotFloor() { return getInstance("HOT_FLOOR"); }

    @NotNull public static DamageSource cramming() { return getInstance("CRAMMING"); }
}
