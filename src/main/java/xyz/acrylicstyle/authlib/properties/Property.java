package xyz.acrylicstyle.authlib.properties;

import org.apache.commons.codec.binary.Base64;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.security.*;

public class Property {
    private final String name;

    private final String value;

    private final String signature;

    public String getName() {
        return name == null ? (String) getField("name") : name;
    }

    public String getValue() {
        return value == null ? (String) getField("value") : value;
    }

    public String getSignature() {
        return signature == null && name == null && value == null ? (String) getField("signature") : signature;
    }

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
    private Object o = null;

    public Property(Object o) {
        this.o = o;
        this.name = null;
        this.value = null;
        this.signature = null;
    }

    public Property(String name, String value) {
        this(name, value, null);
    }

    public Property(String name, String value, String signature) {
        this.name = name;
        this.value = value;
        this.signature = signature;
    }

    public Object getProperty() {
        if (o.getClass().getCanonicalName().equals("com.mojang.authlib.properties.Property")) return o;
        try {
            return Class.forName("com.mojang.authlib.properties.Property").getConstructor(String.class, String.class, String.class).newInstance(this.name, this.value, this.signature);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
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
