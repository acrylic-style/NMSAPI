package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public enum  EnumDifficulty {
    PEACEFUL(0, "options.difficulty.peaceful"),
    EASY(1, "options.difficulty.easy"),
    NORMAL(2, "options.difficulty.normal"),
    HARD(3, "options.difficulty.hard");

    private static final EnumDifficulty[] e;

    private final int f;

    private final String g;

    static {
        e = new EnumDifficulty[(values()).length];
        for (EnumDifficulty enumDifficulty : values()) {
            e[enumDifficulty.f] = enumDifficulty;
        }
    }

    EnumDifficulty(int paramInt, String paramString) {
        this.f = paramInt;
        this.g = paramString;
    }

    public int a() {
        return this.f;
    }

    public static EnumDifficulty getById(int paramInt) {
        return e[paramInt % e.length];
    }

    public String b() {
        return this.g;
    }

    public static final Class<?> CLASS = getClassWithoutException("EnumDifficulty");

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Enum getHandle() {
        try {
            return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("EnumDifficulty"), this.name());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static EnumDifficulty valueOf(Object o) {
        return valueOf(((Enum<?>) o).name());
    }
}
