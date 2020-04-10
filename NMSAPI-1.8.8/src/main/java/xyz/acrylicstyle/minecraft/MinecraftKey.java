package xyz.acrylicstyle.minecraft;

import xyz.acrylicstyle.shared.NMSAPI;

public class MinecraftKey extends NMSAPI {
    public MinecraftKey(Object o) {
        super(o, "MinecraftKey");
    }

    public MinecraftKey(int paramInt, String... paramVarArgs) {
        super("MinecraftKey", paramInt, paramVarArgs);
    }

    public MinecraftKey(String paramString) {
        this(0, paramString);
    }

    public static String[] a(String paramString) {
        String[] arrayOfString = { null, paramString };
        int i = paramString.indexOf(':');
        if (i >= 0) {
            arrayOfString[1] = paramString.substring(i + 1);
            if (i > 1)
                arrayOfString[0] = paramString.substring(0, i);
        }
        return arrayOfString;
    }

    public String getA() { return field("a"); }

    public String getB() { return field("b"); }

    public String a() { return getA() + ':' + getB(); }

    public String toString() { return (String) invoke("toString"); }

    public boolean equals(Object paramObject) {
        if (this == paramObject)
            return true;
        if (paramObject instanceof MinecraftKey) {
            MinecraftKey minecraftKey = (MinecraftKey) paramObject;
            return (this.getA().equals(minecraftKey.getA()) && this.getB().equals(minecraftKey.getB()));
        }
        return false;
    }

    public int hashCode() { return 31 * getA().hashCode() + getB().hashCode(); }

    public int a(MinecraftKey minecraftKey) { return (int) invoke("a", minecraftKey.getNMSClass()); }
}
