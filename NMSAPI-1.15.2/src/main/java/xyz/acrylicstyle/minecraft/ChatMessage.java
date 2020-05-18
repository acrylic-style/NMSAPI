package xyz.acrylicstyle.minecraft;

import util.ReflectionHelper;

import java.util.Objects;
import java.util.regex.Pattern;

public class ChatMessage extends ChatBaseComponent {
    public static final Class<?> CLASS = getClassWithoutException("ChatMessage");

    public static final Pattern c = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");

    public ChatMessage(Object o) {
        super(o, "ChatMessage");
    }

    private static Object callCtor(String s, Object... o) {
        try {
            return CLASS.getConstructor(String.class, Object[].class).newInstance(s, o);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public ChatMessage(String paramString, Object... paramVarArgs) {
        super(callCtor(paramString, paramVarArgs), "ChatMessage");
    }

    @Override
    public String getText() {
        return (String) invoke("getText");
    }

    @Override
    public ChatMessage h() {
        return new ChatMessage(invoke("h"));
    }

    @Override
    public IChatBaseComponent g() {
        return IChatBaseComponent.getInstance(invoke("g"));
    }

    @Override
    public boolean equals(Object o) {
        try {
            return (boolean) Objects.requireNonNull(ReflectionHelper.findMethod(CLASS, "equals", Object.class)).invoke(this.getHandle(), o);
        } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
    }

    @Override
    public int hashCode() {
        return (int) invoke("hashCode");
    }

    @Override
    public String toString() {
        return (String) invoke("toString");
    }

    public String i() {
        return field("d"); // 1.8.8
    }

    public Object[] j() {
        return field("e"); // 1.8.8
    }

    /*
    public IChatBaseComponent a(int paramInt) {
        return IChatBaseComponent.getInstance(invoke("a", paramInt));
    }
    */

    public IChatBaseComponent setChatModifier(ChatModifier paramChatModifier) {
        invoke("setChatModifier", paramChatModifier);
        return this;
    }

    protected void b(String paramString) {
        invoke("b", paramString);
    }
}
