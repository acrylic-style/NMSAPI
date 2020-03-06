package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

public enum EnumDirection {
    DOWN,
    UP,
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Enum toNMSEnum() {
        try {
            return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("EnumDirection"), this.name());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
