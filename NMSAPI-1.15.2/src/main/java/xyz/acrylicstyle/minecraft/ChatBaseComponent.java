package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

public abstract class ChatBaseComponent implements IChatBaseComponent {
    public IChatBaseComponent addSibling(IChatBaseComponent iChatBaseComponent) {
        invoke("addSibling", iChatBaseComponent.getIChatBaseComponent());
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
                    .invoke(getChatBaseComponent(), o);
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

    // NMSAPI start
    private Object o;

    public ChatBaseComponent(Object o) {
        this.o = o;
    }

    public Object getChatBaseComponent() {
        if (o.getClass().getSimpleName().equals("ChatBaseComponent") || o.getClass().getSuperclass().getSimpleName().equals("ChatBaseComponent")) return o;
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("ChatBaseComponent"), getChatBaseComponent(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("ChatBaseComponent")
                    .getMethod(method)
                    .invoke(getChatBaseComponent());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("ChatBaseComponent")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getChatBaseComponent(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
