package xyz.acrylicstyle.minecraft.v1_8_R1;

import xyz.acrylicstyle.shared.NMSAPI;

@SuppressWarnings("unused")
public class ChatModifier extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("ChatModifier");

    public ChatModifier(Object o) {
        super(o, "ChatModifier");
    }

    public EnumChatFormat getColor() {
        return EnumChatFormat.valueOf(invoke("getColor"));
    }

    public boolean isBold() {
        return (boolean) invoke("isBold");
    }

    public boolean isItalic() {
        return (boolean) invoke("isItalic");
    }

    public boolean isStrikethrough() {
        return (boolean) invoke("isStrikethrough");
    }

    public boolean isUnderlined() {
        return (boolean) invoke("isUnderlined");
    }

    public boolean isRandom() {
        return (boolean) invoke("isRandom");
    }

    public boolean g() {
        return (boolean) invoke("g");
    }

    public ChatClickable h() {
        return ChatClickable.getInstance(invoke("h"));
    }

    public ChatHoverable i() {
        return ChatHoverable.getInstance(invoke("i"));
    }

    public String j() {
        return (String) invoke("j");
    }

    public ChatModifier setColor(EnumChatFormat enumChatFormat) {
        invoke("setColor", enumChatFormat.getHandle());
        return this;
    }

    public ChatModifier setBold(boolean b) {
        invoke("setBold", b);
        return this;
    }

    public ChatModifier setItalic(boolean b) {
        invoke("setItalic", b);
        return this;
    }

    public ChatModifier setStrikethrough(boolean b) {
        invoke("setStrikethrough", b);
        return this;
    }

    public ChatModifier setUnderline(boolean b) {
        invoke("setUnderline", b);
        return this;
    }

    public ChatModifier setRandom(boolean b) {
        invoke("setRandom", b);
        return this;
    }

    public ChatModifier setChatClickable(ChatClickable chatClickable) {
        invoke("setChatClickable", chatClickable.getHandle());
        return this;
    }

    public ChatModifier setChatHoverable(ChatHoverable chatHoverable) {
        invoke("setChatHoverable", chatHoverable.getHandle());
        return this;
    }

    public ChatModifier setInsertion(String s) {
        invoke("setInsertion", s);
        return this;
    }

    public ChatModifier setChatModifier(ChatModifier chatModifier) {
        invoke("setChatModifier", chatModifier.getHandle());
        return this;
    }

    private ChatModifier o() {
        return new ChatModifier(invoke("o"));
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatModifier)) return false;
        ChatModifier chatModifier = (ChatModifier) o;
        if (isBold() == chatModifier.isBold()
                && getColor() == chatModifier.getColor()
                && isItalic() == chatModifier.isItalic()
                && isRandom() == chatModifier.isRandom()
                && isStrikethrough() == chatModifier.isStrikethrough()
                && isUnderlined() == chatModifier.isUnderlined()) {
            if ((h() != null) ?
                !h().equals(chatModifier.h()) : (
                        chatModifier.i() != null))
                if ((i() != null) ?
                        !i().equals(chatModifier.i()) : (
                                chatModifier.i() != null))
                    return j() != null || chatModifier.j() != null;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public ChatModifier clone() {
        return new ChatModifier(invoke("clone"));
    }

    public ChatModifier n() {
        return new ChatModifier(invoke("n"));
    }
}
