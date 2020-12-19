package xyz.acrylicstyle.nmsapi.shared.mineraft.network;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface PlayerConnection {
    @Contract(pure = true)
    @NotNull
    NetworkManager getNetworkManager();
}
