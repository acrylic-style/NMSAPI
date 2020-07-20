package xyz.acrylicstyle.minecraft.v1_8_R1;

import xyz.acrylicstyle.shared.NMSAPI;

public interface ICommandListener {
    Class<?> CLASS = NMSAPI.getClassWithoutException("ICommandListener");

    String getName();

    IChatBaseComponent getScoreboardDisplayName();

    void sendMessage(IChatBaseComponent paramIChatBaseComponent);

    boolean a(int paramInt, String paramString);

    BlockPosition getChunkCoordinates();

    Vec3D d();

    World getWorld();

    Entity f();

    boolean getSendCommandFeedback();

    void a(Object paramEnumCommandResult, int paramInt);

    Object getNMSClass();
}
