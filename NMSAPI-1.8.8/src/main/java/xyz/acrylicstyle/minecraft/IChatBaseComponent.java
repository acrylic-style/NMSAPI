package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.NotNull;
import util.ICollectionList;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.Log;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class IChatBaseComponent extends NMSAPI implements Cloneable { // NMSAPI - transform interface into class and extends NMSAPI
    public static final Class<?> CLASS = getClassWithoutException("IChatBaseComponent");

    protected IChatBaseComponent(Object o, String nmsClassName) {
        super(o, nmsClassName);
    }

    protected IChatBaseComponent(@NotNull String nmsClassName, Object... o) {
        super(nmsClassName, o);
    }

    public IChatBaseComponent a(String s) {
        return getInstance(invoke("a", s));
    }

    public String getString() {
        return (String) invoke("getString");
    }

    public String a(int i) {
        return (String) invoke("a", i);
    }

    public String getLegacyString() {
        return (String) invoke("getLegacyString");
    }

    public Stream<IChatBaseComponent> f() {
        return ICollectionList.asList(((Stream<?>) invoke("f")).collect(Collectors.toList())).map(IChatBaseComponent::getInstance).stream();
    }

    public Iterator<IChatBaseComponent> iterator() {
        return f().iterator();
    }

    public IChatBaseComponent h() {
        return getInstance(invoke("h"));
    }

    abstract IChatBaseComponent setChatModifier(Object paramChatModifier);

    abstract Object getChatModifier();

    abstract IChatBaseComponent addSibling(IChatBaseComponent paramIChatBaseComponent);

    abstract String getText();

    abstract List<IChatBaseComponent> getSiblings();

    abstract Stream<IChatBaseComponent> c();

    abstract IChatBaseComponent g();

    public static IChatBaseComponent getInstance(Object o) {
        try {
            if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("ChatMessage"))) {
                return new ChatMessage(o);
            } else if (o.getClass().isAssignableFrom(ReflectionUtil.getNMSClass("ChatBaseComponent"))) {
                return new ChatComponentText(o);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.warn("Unknown IChatBaseComponent Class: " + o.getClass().getCanonicalName());
        return null;
    }
}
