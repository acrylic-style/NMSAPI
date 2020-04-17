package xyz.acrylicstyle.craftbukkit.v1_8_R3.util;

import org.bukkit.util.CachedServerIcon;
import xyz.acrylicstyle.shared.OBCAPI;

public class CraftIconCache extends OBCAPI implements CachedServerIcon {
    public static final Class<?> CLASS = getClassWithoutException("util.CraftIconCache");

    public final String value;

    public CraftIconCache(String value) {
        super("util.CraftIconCache", value);
        this.value = (String) getField("value");
    }

    public CraftIconCache(Object o) {
        super(o, "util.CraftIconCache");
        this.value = (String) getField("value");
    }
}
