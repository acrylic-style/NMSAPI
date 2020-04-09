package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public interface IChatBaseComponent extends Cloneable {
    default IChatBaseComponent a(String s) {
        IChatBaseComponent c = this;
        c.setO(invoke("a", s));
        return c;
    }

    default String getString() {
        return (String) invoke("getString");
    }

    default String a(int i) {
        return (String) invoke("a", i);
    }

    default String getLegacyString() {
        return (String) invoke("getLegacyString");
    }

    @SuppressWarnings("unchecked")
    default Stream<IChatBaseComponent> f() {
        return (Stream<IChatBaseComponent>) invoke("f");
    }

    default Iterator<IChatBaseComponent> iterator() {
        return f().iterator();
    }

    default IChatBaseComponent h() {
        IChatBaseComponent c = this;
        c.setO(invoke("h"));
        return c;
    }

    IChatBaseComponent setChatModifier(Object paramChatModifier);

    Object getChatModifier();

    IChatBaseComponent addSibling(IChatBaseComponent paramIChatBaseComponent);

    String getText();

    List<IChatBaseComponent> getSiblings();

    Stream<IChatBaseComponent> c();

    IChatBaseComponent g();

    // NMSAPI start
    AtomicReference<Object> o = new AtomicReference<>();

    default void setO(Object o) {
        this.o.set(o);
    }

    default Object getIChatBaseComponent() {
        if (o.get().getClass().getSimpleName().equals("IChatBaseComponent") || o.get().getClass().getSuperclass().getSimpleName().equals("IChatBaseComponent")) return o;
        return null;
    }

    default Object getNMSClass() { return getIChatBaseComponent(); }

    default Object getHandle() { return getIChatBaseComponent(); }

    default Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("IChatBaseComponent"), getIChatBaseComponent(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    default Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("IChatBaseComponent")
                    .getMethod(method)
                    .invoke(getIChatBaseComponent());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    default Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("IChatBaseComponent")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getIChatBaseComponent(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
