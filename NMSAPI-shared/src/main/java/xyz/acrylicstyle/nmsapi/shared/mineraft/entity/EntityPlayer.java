package xyz.acrylicstyle.nmsapi.shared.mineraft.entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.mcutil.mojang.GameProfile;
import xyz.acrylicstyle.nmsapi.shared.authlib.AbstractGameProfile;
import xyz.acrylicstyle.nmsapi.shared.mineraft.network.PlayerConnection;

public interface EntityPlayer {
    /**
     * Get ping of this player.
     * @return the ping
     */
    @Contract(pure = true)
    int getPing();

    /**
     * Returns the current game profile
     * @return the current profile
     */
    @NotNull
    GameProfile getProfile();

    /**
     * Sets the game profile to the provided profile.
     * @param profile the profile
     */
    void setProfile(@NotNull AbstractGameProfile profile);

    @Contract(pure = true)
    @NotNull
    PlayerConnection getPlayerConnection();
}
