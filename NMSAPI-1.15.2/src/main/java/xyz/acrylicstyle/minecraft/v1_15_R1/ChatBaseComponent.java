package xyz.acrylicstyle.minecraft.v1_15_R1;

import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

public abstract class ChatBaseComponent extends IChatBaseComponent {
    public static final Class<?> CLASS = getClassWithoutException("ChatBaseComponent");

    protected ChatBaseComponent(Object o, String clazz) {
        super(o, clazz);
    }

    protected ChatBaseComponent(String clazz, Object... args) {
        super(clazz, args);
    }

    public ChatBaseComponent(Object o) {
        super(o, "ChatBaseComponent");
    }

    public IChatBaseComponent addSibling(IChatBaseComponent iChatBaseComponent) {
        invoke("addSibling", iChatBaseComponent.getHandle());
        return this;
    }

    @SuppressWarnings("unchecked")
    public List<IChatBaseComponent> getSiblings() {
        return (List<IChatBaseComponent>) invoke("getSiblings");
    }

    public IChatBaseComponent setChatModifier(Object o) {
        try {
            ReflectionUtil
                    .getNMSClass("ChatBaseComponent")
                    .getMethod("setChatModifier", ReflectionUtil.getNMSClass("ChatModifier"))
                    .invoke(getHandle(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Object getChatModifier() {
        return invoke("getChatModifier");
    }

    @SuppressWarnings("unchecked")
    public Stream<IChatBaseComponent> c() {
        return (Stream<IChatBaseComponent>) invoke("c");
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    public String toString() {
        return (String) invoke("toString");
    }
}
