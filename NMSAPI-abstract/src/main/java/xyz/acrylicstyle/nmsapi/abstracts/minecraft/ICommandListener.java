package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.jetbrains.annotations.NotNull;

public interface ICommandListener {
    /**
     * Returns the name of this command listener.
     * @return the name
     */
    String getName();

    /**
     * Sends the message to this listener.
     * @param iChatBaseComponent the message
     */
    void sendMessage(@NotNull IChatBaseComponent iChatBaseComponent);

    /**
     * @return whether they receives command feedback.
     */
    boolean getSendCommandFeedback();

    Entity f();
}
