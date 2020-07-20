package xyz.acrylicstyle.minecraft.v1_8_R1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.Log;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.util.Iterator;
import java.util.List;

public abstract class IChatBaseComponent extends NMSAPI implements Cloneable, xyz.acrylicstyle.nmsapi.abstracts.minecraft.IChatBaseComponent { // NMSAPI - transform interface into class
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

    public xyz.acrylicstyle.nmsapi.abstracts.minecraft.IChatBaseComponent f() {
        //return ICollectionList.asList(((Stream<?>) invoke("f")).collect(Collectors.toList())).map(IChatBaseComponent::getInstance).stream();
        throw new UnsupportedOperationException();
    }

    public Iterator<IChatBaseComponent> iterator() {
        throw new UnsupportedOperationException();
        //return f().iterator();
    }

    public IChatBaseComponent h() {
        return getInstance(invoke("h"));
    }

    public abstract IChatBaseComponent setChatModifier(Object paramChatModifier);

    public abstract Object getChatModifier();

    public abstract IChatBaseComponent addSibling(IChatBaseComponent paramIChatBaseComponent);

    public abstract @NotNull String getText();

    public abstract List<IChatBaseComponent> getSiblings();

    public abstract String c();

    public abstract IChatBaseComponent g();

    @Contract(value = "null -> null; !null -> new", pure = true)
    public static IChatBaseComponent getInstance(Object o) {
        if (o == null) return null;
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
