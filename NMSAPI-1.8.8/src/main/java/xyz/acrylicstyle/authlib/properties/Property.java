package xyz.acrylicstyle.authlib.properties;

import org.apache.commons.codec.binary.Base64;
import util.CollectionList;
import util.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.security.*;

public class Property {
    public String getName() { return (String) invoke("getName"); }

    public String getValue() { return (String) invoke("getValue"); }

    public String getSignature() { return (String) invoke("getSignature"); }

    public boolean hasSignature() {
        return getSignature() != null;
    }

    public boolean isSignatureValid(PublicKey publicKey) {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(getValue().getBytes());
            return signature.verify(Base64.decodeBase64(getSignature()));
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return false;
    }

    // NMSAPI start
    private Object o;

    public Property(Object o) {
        this.o = o;
    }

    public Property(String name, String value) {
        this(name, value, null);
    }

    public Property(String name, String value, String signature) {
        try {
            o = Class.forName("com.mojang.authlib.properties.Property").getConstructor(String.class, String.class, String.class).newInstance(name, value, signature);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getProperty() {
        if (o != null && o.getClass().getCanonicalName().equals("com.mojang.authlib.properties.Property")) return o;
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(Class.forName("org.mojang.authlib.properties.Property"), getProperty(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return Class.forName("org.mojang.authlib.properties.Property")
                    .getMethod(method)
                    .invoke(getProperty());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return Class.forName("org.mojang.authlib.properties.Property")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getProperty(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
