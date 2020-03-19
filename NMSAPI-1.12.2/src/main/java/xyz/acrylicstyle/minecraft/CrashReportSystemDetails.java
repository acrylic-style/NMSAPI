package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

public class CrashReportSystemDetails {
    public static String a(double paramDouble1, double paramDouble2, double paramDouble3) {
        return String.format("%.2f,%.2f,%.2f - %s", paramDouble1, paramDouble2, paramDouble3, a(new BlockPosition(paramDouble1, paramDouble2, paramDouble3)));
    }

    public static String a(BlockPosition paramBlockPosition) {
        int i = paramBlockPosition.getX();
        int j = paramBlockPosition.getY();
        int k = paramBlockPosition.getZ();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(String.format("World: (%d,%d,%d)", i, j, k));
        } catch (Throwable throwable) {
            stringBuilder.append("(Error finding world loc)");
        }
        stringBuilder.append(", ");
        try {
            int m = i >> 4;
            int n = k >> 4;
            int i1 = i & 0xF;
            int i2 = j >> 4;
            int i3 = k & 0xF;
            int i4 = m << 4;
            int i5 = n << 4;
            int i6 = (m + 1 << 4) - 1;
            int i7 = (n + 1 << 4) - 1;
            stringBuilder.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", i1, i2, i3, m, n, i4, i5, i6, i7));
        } catch (Throwable throwable) {
            stringBuilder.append("(Error finding chunk loc)");
        }
        stringBuilder.append(", ");
        try {
            int m = i >> 9;
            int n = k >> 9;
            int i1 = m << 5;
            int i2 = n << 5;
            int i3 = (m + 1 << 5) - 1;
            int i4 = (n + 1 << 5) - 1;
            int i5 = m << 9;
            int i6 = n << 9;
            int i7 = (m + 1 << 9) - 1;
            int i8 = (n + 1 << 9) - 1;
            stringBuilder.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", m, n, i1, i2, i3, i4, i5, i6, i7, i8));
        } catch (Throwable throwable) {
            stringBuilder.append("(Error finding world loc)");
        }
        return stringBuilder.toString();
    }

    public void a(String paramString, Callable<String> paramCallable) {
        try {
            a(paramString, paramCallable.call());
        } catch (Throwable throwable) {
            a(paramString, throwable);
        }
    }

    public void a(String paramString, Object paramObject) {
        invoke("a", paramString, paramObject);
    }

    public void a(String paramString, Throwable paramThrowable) {
        invoke("a", paramString, paramThrowable);
    }

    public int a(int paramInt) {
        return (int) invoke("a", paramInt);
    }

    public boolean a(StackTraceElement paramStackTraceElement1, StackTraceElement paramStackTraceElement2) {
        return (boolean) invoke("a", paramStackTraceElement1, paramStackTraceElement2);
    }

    public void b(int paramInt) {
        invoke("b", paramInt);
    }

    public void a(StringBuilder sb) {
        invoke("a", sb);
    }

    public StackTraceElement[] a() {
        return (StackTraceElement[]) invoke("a");
    }

    public static void a(CrashReportSystemDetails crashReportSystemDetails, BlockPosition blockPosition, Object paramBlock, int paramInt) {
        try {
            ReflectionUtil
                    .getNMSClass("CrashReportSystemDetails")
                    .getMethod("a", ReflectionUtil.getNMSClass("CrashReportSystemDetails"), ReflectionUtil.getNMSClass("BlockPosition"), ReflectionUtil.getNMSClass("Block"), int.class)
                    .invoke(null, crashReportSystemDetails, blockPosition, paramBlock, paramInt);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void a(CrashReportSystemDetails crashReportSystemDetails, BlockPosition blockPosition, Object paramIBlockData) {
        try {
            ReflectionUtil
                    .getNMSClass("CrashReportSystemDetails")
                    .getMethod("a", ReflectionUtil.getNMSClass("CrashReportSystemDetails"), ReflectionUtil.getNMSClass("BlockPosition"), ReflectionUtil.getNMSClass("IBlockData"))
                    .invoke(null, crashReportSystemDetails, blockPosition, paramIBlockData);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static class CrashReportDetail {
        private final String a;

        private final String b;

        public CrashReportDetail(String param1String, Object param1Object) {
            this.a = param1String;
            if (param1Object == null) {
                this.b = "~~NULL~~";
            } else if (param1Object instanceof Throwable) {
                Throwable throwable = (Throwable)param1Object;
                this.b = "~~ERROR~~ " + throwable.getClass().getSimpleName() + ": " + throwable.getMessage();
            } else {
                this.b = param1Object.toString();
            }
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public Object toNMSClass() {
            try {
                return ReflectionUtil
                        .getNMSClass("CrashReportSystemDetails.CrashReportDetail")
                        .getConstructor(String.class, Object.class)
                        .newInstance(a, b);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // NMSAPI start
    private Object o;

    public CrashReportSystemDetails(Object o) {
        this.o = o;
    }

    public CrashReportSystemDetails(CrashReport crashReport, String string) {
        try {
            this.o = ReflectionUtil.getNMSClass("CrashReportSystemDetails")
                    .getConstructor(ReflectionUtil.getNMSClass("CrashReport"), String.class)
                    .newInstance(crashReport.toNMSClass(), string);
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object toNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("CrashReportSystemDetails").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("CrashReportSystemDetails"), toNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("CrashReportSystemDetails")
                    .getMethod(method)
                    .invoke(toNMSClass());
        } catch (NoSuchMethodException e) {
            try {
                return ReflectionUtil.getNMSClass("CrashReportSystemDetails")
                        .getSuperclass()
                        .getMethod(method)
                        .invoke(toNMSClass());
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = ICollectionList.asList(o).map(Object::getClass);
            return ReflectionUtil.getNMSClass("CrashReportSystemDetails")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(toNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getNMSClass("CrashReportSystemDetails").getDeclaredField(field);
            f.setAccessible(true);
            f.set(toNMSClass(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getNMSClass("CrashReportSystemDetails").getSuperclass().getDeclaredField(field);
                f.setAccessible(true);
                f.set(toNMSClass(), value);
            } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    // NMSAPI end
}
