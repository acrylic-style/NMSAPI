package xyz.acrylicstyle.minecraft.v1_8_R1;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.io.File;
import java.lang.reflect.Method;

public class CrashReport extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("CrashReport");

    public void h() {
        invoke("h");
    }

    public String a() {
        return (String) getField("b");
    }

    public String getMessage() { return a(); }

    public Throwable b() {
        return (Throwable) getField("c");
    }

    public Throwable getThrowable() { return b(); }

    public void a(StringBuilder stringBuilder) {
        invoke("a", stringBuilder);
    }

    public String d() {
        return (String) invoke("d");
    }

    public String e() {
        return (String) invoke("e");
    }

    public boolean a(File file) {
        return (boolean) invoke("a", file);
    }

    public boolean saveCrashReport(File file) {
        return a(file);
    }

    public static String i() {
        try {
            Method method = ReflectionUtil.getNMSClass("CrashReport").getDeclaredMethod("i");
            method.setAccessible(true);
            return (String) method.invoke(null);
        } catch(ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRandomMessage() { return i(); }

    public static CrashReport a(Throwable throwable, String s) {
        CrashReport crashReport;
        if (throwable instanceof ReportedException) {
            crashReport = ((ReportedException) throwable).getCrashReport();
        } else crashReport = new CrashReport(s, throwable);
        return crashReport;
    }

    public static CrashReport getCrashReport(Throwable throwable, String s) {
        return a(throwable, s);
    }

    public CrashReportSystemDetails g() {
        return new CrashReportSystemDetails(getField("d"));
    }

    public CrashReportSystemDetails a(String s) {
        return a(s, 1);
    }

    public CrashReportSystemDetails a(String s, int i) {
        return new CrashReportSystemDetails(invoke("a", s, i));
    }

    public CrashReport(Object o) {
        super(o, "CrashReport");
    }

    public CrashReport(String s, Throwable throwable) {
        super("CrashReport", s, throwable);
    }
}
