package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

public enum EnumMoveType {
    SELF,
    PLAYER,
    PISTON,
    SHULKER_BOX,
    SHULKER;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Enum toNMSEnum() {
        try {
            return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("EnumMoveType"), this.name());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
