package xyz.acrylicstyle.nmsapi.abstracts.utils;

import java.lang.reflect.Method;

public class CraftUtils {
    public static Object getHandle(Object o) {
        try {
            if (o == null) throw new NullPointerException("o");
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
        } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
    }
}
