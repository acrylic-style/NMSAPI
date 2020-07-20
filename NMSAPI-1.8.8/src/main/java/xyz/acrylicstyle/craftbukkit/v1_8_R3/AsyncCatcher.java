package xyz.acrylicstyle.craftbukkit.v1_8_R3;

import xyz.acrylicstyle.minecraft.v1_8_R1.MinecraftServer;

public class AsyncCatcher {
    public static boolean enabled = true;

    public static void catchOp(String reason) {
        if (enabled && Thread.currentThread() != (MinecraftServer.getServer()).primaryThread)
            throw new IllegalStateException("Asynchronous " + reason + "!");
    }
}
