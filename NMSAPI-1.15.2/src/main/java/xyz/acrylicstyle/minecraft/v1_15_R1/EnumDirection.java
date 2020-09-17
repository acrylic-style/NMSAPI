package xyz.acrylicstyle.minecraft.v1_15_R1;

import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import static xyz.acrylicstyle.shared.NMSAPI.getClassWithoutException;

public enum EnumDirection {
    DOWN,
    UP,
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public static final Class<?> CLASS = getClassWithoutException("EnumDirection");

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Enum getHandle() {
        try {
            return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("EnumDirection"), this.name());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static EnumDirection valueOf(Object o) {
        return valueOf(((Enum<?>) o).name());
    }
}
