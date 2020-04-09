package xyz.acrylicstyle.minecraft;

public interface ICommandListener {
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
