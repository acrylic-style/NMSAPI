package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.List;

public interface IChatBaseComponent {
    Class<?> CLASS = NMSAPI.getClassWithoutException("IChatBaseComponent");

    // IChatBaseComponent setChatModifier(ChatModifier modifier);
    // ChatModifier getChatModifier();
    IChatBaseComponent a(String s);

    /**
     * Add IChatBaseComponent to this IChatBaseComponent and returns new IChatBaseComponent.
     * @param iChatBaseComponent the IChatBaseComponent that will be added to this
     * @return the merged IChatBaseComponent
     */
    IChatBaseComponent addSibling(@NotNull IChatBaseComponent iChatBaseComponent);

    /**
     * Returns IChatBaseComponent as string.
     * @return IChatBaseComponent... as a string.
     */
    @NotNull
    String getText();

    String c();

    List<?> a();

    IChatBaseComponent f();

    /**
     * Returns the nms object.
     * @return the nms object
     */
    @NotNull
    Object getHandle();
}
