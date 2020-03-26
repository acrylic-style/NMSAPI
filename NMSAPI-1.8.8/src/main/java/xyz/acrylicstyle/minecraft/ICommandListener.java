package xyz.acrylicstyle.minecraft;

public interface ICommandListener {
    String getName();

    IChatBaseComponent getScoreboardDisplayName();

    void sendMessage(IChatBaseComponent paramIChatBaseComponent);

    boolean a(int paramInt, String paramString);

    BlockPosition getChunkCoordinates();

    Object d(); // todo: Vec3D

    World getWorld();

    Object f(); // todo: nms.Entity

    boolean getSendCommandFeedback();

    void a(Object paramEnumCommandResult, int paramInt);

    Object getNMSClass();
}
