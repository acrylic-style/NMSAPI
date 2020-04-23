package xyz.acrylicstyle;

import xyz.acrylicstyle.minecraft.MinecraftServer;

public class AsyncCatcher {
    public static boolean enabled = true;

    public static void catchOp(String reason) {
        if (enabled && Thread.currentThread() != (MinecraftServer.getServer()).primaryThread)
            throw new IllegalStateException("Asynchronous " + reason + "!");
    }
}
