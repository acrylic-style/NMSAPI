package xyz.acrylicstyle.shared;

import org.jetbrains.annotations.Contract;
import util.reflect.Ref;

import java.util.UUID;

class Bukkit {
    @Contract("null -> fail")
    static Player getPlayer(UUID uuid) {
        try {
            Object o = Class.forName("org.bukkit.Bukkit").getMethod("getPlayer", UUID.class).invoke(null, uuid);
            if (o == null) return null;
            return new Player(o);
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    @Contract("null -> fail")
    static Player getPlayer(String name) {
        try {
            Object o = Class.forName("org.bukkit.Bukkit").getMethod("getPlayer", String.class).invoke(null, name);
            if (o == null) return null;
            return new Player(o);
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    static String getVersion() {
        return (String) Ref.forName("org.bukkit.Bukkit").getMethod("getVersion").invoke(null);
    }
}
