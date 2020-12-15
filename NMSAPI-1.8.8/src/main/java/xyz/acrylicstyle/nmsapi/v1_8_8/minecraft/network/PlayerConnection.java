package xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.network;

import org.bukkit.Location;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.reflect.RefClass;
import util.reflector.CastTo;
import util.reflector.ForwardMethod;
import xyz.acrylicstyle.nmsapi.shared.NMSAPI;

public interface PlayerConnection {
    RefClass<?> CLASS = NMSAPI.nms("PlayerConnection");

    @ForwardMethod("a")
    @CastTo(NetworkManager.class)
    @Contract(pure = true)
    @NotNull
    NetworkManager getNetworkManager();

    /**
     * Kicks player from the server.
     * @param message the message to be sent to the client.
     */
    void disconnect(@NotNull String message);

    void teleport(@NotNull Location location);

    void handleCommand(@NotNull String command);
}
