package xyz.acrylicstyle.authlib.properties;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.CraftUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.function.Function;

@SuppressWarnings("UnusedReturnValue")
public class PropertyMap {
    @SuppressWarnings("rawtypes")
    public Multimap delegate() {
        return (Multimap) invoke("delegate");
    }

    public boolean put(String key, Property value) {
        try {
            return (boolean) ForwardingMultimap.class
                    .getMethod("put", Object.class, Object.class)
                    .invoke(o, key, value.getProperty());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("Convert2MethodRef")
    public Collection<Property> removeAll(String key) {
        try {
            return new CollectionList<>((Collection<?>) ForwardingMultimap.class
                    .getMethod("removeAll", Object.class)
                    .invoke(o, key)).map(s -> new Property(s));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public @NotNull CollectionList<Property> get(@Nullable String key) {
        try {
            Collection collection = (Collection) ForwardingMultimap.class
                    .getMethod("get", Object.class)
                    .invoke(o, key);
            return new CollectionList<>(collection).map((Function<Object, Property>) Property::new);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    // NMSAPI start
    private final Object o;

    public PropertyMap(Object o) {
        this.o = o;
    }

    public Object getPropertyMap() {
        if (o.getClass().getCanonicalName().equals("com.mojang.authlib.properties.PropertyMap")) return o;
        try {
            return CraftUtils.getProfile(o).getClass().getMethod("getProperties").invoke(o);
        } catch (NoSuchMethodException e1) {
            try {
                return CraftUtils.getProfile(CraftUtils.getHandle(o)).getClass().getMethod("getProperties").invoke(o);
            } catch (Exception e) {
                return null;
            }
        } catch (InvocationTargetException | IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(Class.forName("com.mojang.authlib.properties.PropertyMap"), getPropertyMap(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return Class.forName("com.mojang.authlib.properties.PropertyMap")
                    .getMethod(method)
                    .invoke(getPropertyMap());
        } catch (NoSuchMethodException e) {
            try {
                return Class.forName("com.mojang.authlib.properties.PropertyMap")
                        .getSuperclass()
                        .getMethod(method)
                        .invoke(getPropertyMap());
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException ex) {
                ex.printStackTrace();
                return null;
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        CollectionList<Class<?>> classes = new CollectionList<>();
        for (Object o1 : o) classes.add(o1.getClass());
        try {
            return Class.forName("com.mojang.authlib.properties.PropertyMap")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getPropertyMap(), o);
        } catch (NoSuchMethodException e) {
            try {
                return Class.forName("com.mojang.authlib.properties.PropertyMap")
                        .getSuperclass()
                        .getMethod(method, classes.toArray(new Class[0]))
                        .invoke(getPropertyMap(), o);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException ex) {
                ex.printStackTrace();
                return null;
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
