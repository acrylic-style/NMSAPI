package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.shared.NMSAPI;

public class WorldType extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("WorldType");
    public static final WorldType[] types = new WorldType[16];

    public static final WorldType NORMAL = (new WorldType(0, "default", 1)).i();

    public static final WorldType FLAT = new WorldType(1, "flat");

    public static final WorldType LARGE_BIOMES = new WorldType(2, "largeBiomes");

    public static final WorldType AMPLIFIED = (new WorldType(3, "amplified")).i();

    public static final WorldType CUSTOMIZED = new WorldType(4, "customized");

    public static final WorldType DEBUG_ALL_BLOCK_STATES = new WorldType(5, "debug_all_block_states");

    public static final WorldType NORMAL_1_1 = (new WorldType(8, "default_1_1", 0)).a(false);

    private WorldType(int i, String s) {
        this(i, s, 0);
    }

    private WorldType(int i, String s, int i1) {
        super("WorldType", i, s, i1);
        types[i] = this;
    }

    public WorldType(Object o) {
        super(o, "WorldType");
    }

    public String name() {
        return field("name");
    }

    public int getVersion() {
        return field("version");
    }

    public WorldType a(int i) {
        if (this == NORMAL && i == 0) return NORMAL_1_1;
        return this;
    }

    public WorldType a(boolean b) {
        setField("l", b);
        return this;
    }

    public WorldType i() {
        setField("m", true);
        return this;
    }

    public boolean f() {
        return field("m");
    }

    public static WorldType getType(String paramString) {
        for (WorldType type : types) if (type != null && type.name().equalsIgnoreCase(paramString)) return type;
        return null;
    }

    public int g() {
        return field("i");
    }

    public WorldType j() {
        setField("n", true);
        return this;
    }
}
