package xyz.acrylicstyle.craftbukkit.v1_8_R3.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CraftUtils {
    public static Object getHandle(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NullPointerException {
        if (o == null) throw new NoSuchMethodException();
        Method method;
        try {
            method = o
                    .getClass()
                    .getDeclaredMethod("getHandle");
        } catch (NoSuchMethodException e) {
            try {
                method = o
                        .getClass()
                        .getSuperclass()
                        .getDeclaredMethod("getHandle");
            } catch (NoSuchMethodException e2) {
                try {
                    method = o
                            .getClass()
                            .getSuperclass()
                            .getSuperclass()
                            .getDeclaredMethod("getHandle");
                } catch (NoSuchMethodException e3) {
                    method = o
                            .getClass()
                            .getSuperclass()
                            .getSuperclass()
                            .getSuperclass()
                            .getDeclaredMethod("getHandle"); // when couldn't find getHandle method with 4th try, then give up.
                }
            }
        }
        method.setAccessible(true);
        return method.invoke(o);
    }

    public static Object getProfile(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NullPointerException {
        if (o == null) throw new NoSuchMethodException();
        Method method;
        try {
            method = o
                    .getClass()
                    .getDeclaredMethod("gerProfile");
        } catch (NoSuchMethodException e) {
            try {
                method = o
                        .getClass()
                        .getSuperclass()
                        .getDeclaredMethod("getProfile");
            } catch (NoSuchMethodException e2) {
                try {
                    method = o
                            .getClass()
                            .getSuperclass()
                            .getSuperclass()
                            .getDeclaredMethod("getProfile");
                } catch (NoSuchMethodException e3) {
                    method = o
                            .getClass()
                            .getSuperclass()
                            .getSuperclass()
                            .getSuperclass()
                            .getDeclaredMethod("getProfile"); // when couldn't find getHandle method with 4th try, then give up.
                }
            }
        }
        method.setAccessible(true);
        return method.invoke(o);
    }
}
