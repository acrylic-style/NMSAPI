package xyz.acrylicstyle.craftbukkit;

import xyz.acrylicstyle.minecraft.v1_8_R1.MinecraftServer;

/**
 * Why do we have this class?<br />
 * We cannot run the server without actual spigot.jar, so it's the bad idea.<br /><br />
 * If you really want to use this, you may want to shade NMSAPI into the spigot.jar.
 */
public class Main {
    public static void main(String[] args) {
        Class<?> target;
        System.out.println("Loading class...");
        try {
            target = Class.forName("org.bukkit.craftbukkit.Main");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find CraftBukkit, falling back to MinecraftServer.");
            try {
                MinecraftServer.main();
            } catch (Throwable t) {
                System.err.println("Couldn't start the server. You might need to shade CraftBukkit or minecraft server.");
                t.printStackTrace();
                System.exit(1);
            }
            return;
        }
        try {
            target.getMethod("main").invoke(null);
        } catch (Throwable e) {
            System.err.println("Couldn't start the server. Printing a stacktrace below.");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
