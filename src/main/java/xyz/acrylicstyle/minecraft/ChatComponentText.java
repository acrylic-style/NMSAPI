package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class ChatComponentText extends ChatBaseComponent {
    public String i() {
        return (String) getField("b");
    }

    public String getText() {
        return i();
    }

    public ChatComponentText g() {
        return ChatComponentText.fromString(getText());
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public ChatComponentText clone() {
        return g();
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return (boolean) invoke("equals", o);
    }

    public String toString() {
        return (String) invoke("toString");
    }

    // NMSAPI start
    private Object o;

    public static ChatComponentText fromString(String s) {
        try {
            Object cct = ReflectionUtil.getNMSClass("ChatComponentText").getConstructor(String.class).newInstance(s);
            return new ChatComponentText(cct);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChatComponentText(Object o) {
        super(o);
        this.o = o;
    }

    public Object getChatComponentText() {
        if (o.getClass().getSimpleName().equals("ChatComponentText")) return o;
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("ChatComponentText"), getChatComponentText(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("ChatComponentText")
                    .getMethod(method)
                    .invoke(getChatComponentText());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("ChatComponentText")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getChatComponentText(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
