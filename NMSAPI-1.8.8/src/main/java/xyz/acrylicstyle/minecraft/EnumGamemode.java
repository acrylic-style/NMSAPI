package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public enum EnumGamemode {
    NOT_SET,
    SURVIVAL,
    CREATIVE,
    ADVENTURE,
    SPECTATOR;

    public static final Class<?> CLASS = getClassWithoutException("EnumGamemode");

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
