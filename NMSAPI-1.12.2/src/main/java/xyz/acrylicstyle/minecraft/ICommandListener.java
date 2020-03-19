package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.Nullable;

public interface ICommandListener {
    String getName();

    default IChatBaseComponent getScoreboardDisplayName() {
        return new ChatComponentText(getName());
    }

    default void sendMessage(IChatBaseComponent paramIChatBaseComponent) {}

    boolean a(int paramInt, String paramString);

    default BlockPosition getChunkCoordinates() {
        return BlockPosition.ZERO;
    }

    default Vec3D d() {
        return Vec3D.ZERO;
    }

    @Nullable
    default Entity f() { return null; }

    default boolean getSendCommandFeedback() {
        return false;
    }

    @Nullable
    MinecraftServer C_();
}
