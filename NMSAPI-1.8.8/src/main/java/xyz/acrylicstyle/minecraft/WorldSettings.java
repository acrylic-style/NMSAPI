package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

public final class WorldSettings extends NMSAPI {
    public enum EnumGamemode {
        NOT_SET(-1, ""),
        SURVIVAL(0, "survival"),
        CREATIVE(1, "creative"),
        ADVENTURE(2, "adventure"),
        SPECTATOR(3, "spectator");

        int f;
        String g;

        EnumGamemode(int i, String s) {
            this.f = i;
            this.g = s;
        }

        public int getId() { return this.f; }

        public String b() { return this.g; }

        public String getName() { return this.g; } // NMSAPI - OBFHelper

        public void a(PlayerAbilities paramPlayerAbilities) {
            if (this == CREATIVE) {
                paramPlayerAbilities.canFly = true;
                paramPlayerAbilities.canInstantlyBuild = true;
                paramPlayerAbilities.isInvulnerable = true;
                paramPlayerAbilities.setField("canFly", true);
                paramPlayerAbilities.setField("canInstantlyBuild", true);
                paramPlayerAbilities.setField("isInvulnerable", true);
            } else if (this == SPECTATOR) {
                paramPlayerAbilities.canFly = true;
                paramPlayerAbilities.canInstantlyBuild = true;
                paramPlayerAbilities.isInvulnerable = true;
                paramPlayerAbilities.isFlying = true;
                paramPlayerAbilities.setField("canFly", true);
                paramPlayerAbilities.setField("canInstantlyBuild", true);
                paramPlayerAbilities.setField("isInvulnerable", true);
                paramPlayerAbilities.setField("isFlying", true);
            } else {
                paramPlayerAbilities.canFly = false;
                paramPlayerAbilities.canInstantlyBuild = false;
                paramPlayerAbilities.isInvulnerable = false;
                paramPlayerAbilities.isFlying = false;
                paramPlayerAbilities.setField("canFly", false);
                paramPlayerAbilities.setField("canInstantlyBuild", false);
                paramPlayerAbilities.setField("isInvulnerable", false);
                paramPlayerAbilities.setField("isFlying", false);
            }
            paramPlayerAbilities.mayBuild = !c();
        }

        public boolean c() {
            return (this == ADVENTURE || this == SPECTATOR);
        }

        public boolean d() {
            return this == CREATIVE;
        }

        public boolean e() {
            return (this == SURVIVAL || this == ADVENTURE);
        }

        public static EnumGamemode getById(int i) {
            for (EnumGamemode enumGamemode : values()) if (enumGamemode.f == i) return enumGamemode;
            return SURVIVAL;
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        public Enum getHandle() {
            try {
                return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("EnumGamemode"), this.name());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static EnumGamemode valueOf(Object o) {
            return valueOf(((Enum<?>) o).name());
        }
    }

    public WorldSettings(long seed, EnumGamemode enumGamemode, boolean generateMapFeatures, boolean hardcore, WorldType paramWorldType) {
        super("WorldSettings", seed, enumGamemode.getHandle(), generateMapFeatures, hardcore, paramWorldType.getHandle());
    }

    public String getH() { return field("h"); } // NMSAPI

    public WorldSettings(WorldData paramWorldData) {
        this(paramWorldData.getSeed(), paramWorldData.getGameType(), paramWorldData.shouldGenerateMapFeatures(), paramWorldData.isHardcore(), paramWorldData.getType());
    }

    public WorldSettings a() {
        invoke("a");
        return this;
    }

    public WorldSettings setGeneratorSettings(String s) {
        invoke("setGeneratorSettings", s);
        return this;
    }

    public boolean c() {
        return field("g");
    }

    public long d() {
        return field("a");
    }

    public EnumGamemode e() {
        return EnumGamemode.valueOf(getField("e"));
    }

    public boolean f() {
        return field("d");
    }

    public boolean g() {
        return field("c");
    }

    public WorldType h() {
        return new WorldType(getField("h"));
    }

    public boolean i() {
        return field("f");
    }

    public static EnumGamemode a(int i) {
        return EnumGamemode.getById(i);
    }

    public String j() {
        return field("h");
    }
}
