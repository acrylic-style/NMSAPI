package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

public enum EnumGamemode {
    NOT_SET,
    SURVIVAL,
    CREATIVE,
    ADVENTURE,
    SPECTATOR;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Enum toNMSEnumGamemode() {
        try {
            return Enum.valueOf((Class<Enum>) ReflectionUtil.getNMSClass("EnumGamemode"), this.name());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
