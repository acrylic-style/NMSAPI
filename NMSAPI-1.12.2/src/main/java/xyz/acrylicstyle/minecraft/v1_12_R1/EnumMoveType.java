package xyz.acrylicstyle.minecraft.v1_12_R1;

import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

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
