package xyz.acrylicstyle.minecraft.v1_12_R1;

import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

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
