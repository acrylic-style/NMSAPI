package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.List;

public class MethodProfiler extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("MethodProfiler");

    public MethodProfiler() {
        super("MethodProfiler");
    }

    public MethodProfiler(Object o) {
        super(o, "MethodProfiler");
    }

    public boolean a;
    public void a() {}
    public void a(String s) {}
    public void b() {}
    public List<ProfilerInfo> b(String s) {
        return null;
    }

    public void c(String s) {}

    public String c() { return ""; }

    public static final class ProfilerInfo extends NMSAPI implements Comparable<ProfilerInfo> {
        public static final Class<?> CLASS = getClassWithoutException("MethodProfiler$ProfilerInfo");

        public ProfilerInfo(Object o) {
            super(o, "ProfilerInfo");
            c = field("c");
            a = field("a");
            b = field("b");
        }

        public double a;
        public double b;
        public String c;

        public ProfilerInfo(String s, double d0, double d1) {
            super("ProfilerInfo", s, d0, d1);
            c = s;
            a = d0;
            b = d1;
        }

        public int a(ProfilerInfo profilerInfo) {
            return (profilerInfo.a < this.a) ? -1 : ((profilerInfo.a > this.a) ? 1 : profilerInfo.c.compareTo(this.c));
        }

        @Override
        public int compareTo(@NotNull MethodProfiler.ProfilerInfo o) {
            return a(o);
        }
    }
}
