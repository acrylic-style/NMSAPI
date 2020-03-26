package xyz.acrylicstyle.craftbukkit.v1_8_R3.support;

import org.bukkit.Bukkit;

public class DummyServer extends EmptyServer {
    static {
        try {
            Bukkit.setServer(new DummyServer());
        } catch (Throwable t) {
            throw new Error(t);
        }
    }

    public static void load() {}
}
