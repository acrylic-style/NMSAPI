package xyz.acrylicstyle.minecraft;

public class ChatComponentText extends ChatBaseComponent {
    public static final Class<?> CLASS = getClassWithoutException("ChatComponentText");

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

    public static ChatComponentText fromString(String s) {
        return new ChatComponentText(s);
    }

    public ChatComponentText(String s) {
        super("ChatComponentText", s);
    }

    public ChatComponentText(Object o) {
        super(o, "ChatComponentText");
    }
}
