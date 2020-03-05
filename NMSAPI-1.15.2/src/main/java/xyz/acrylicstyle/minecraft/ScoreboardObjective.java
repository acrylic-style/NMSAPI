package xyz.acrylicstyle.minecraft;

import org.apache.commons.lang.NotImplementedException;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.CraftUtils;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class ScoreboardObjective {
    // NMSAPI start
    private Object o;

    public ScoreboardObjective(Object o) {
        this.o = o;
    }

    public String getName() {
        return (String) invoke("getName");
    }

    public Object getCriteria() {
        return invoke("getCriteria");
    }

    public Object getDisplayName() {
        return invoke("getDisplayName");
    }

    public Object e() {
        return invoke("e");
    }

    public void setDisplayName(Object o) {
        throw new NotImplementedException();
    }

    public Object getRenderType() {
        return getField("e");
    }

    public void setRenderType(Object o) {
        throw new NotImplementedException();
    }

    public Object getNMSScoreboard() {
        if (o.getClass().getCanonicalName().startsWith("net.minecraft.server") && o.getClass().getCanonicalName().endsWith("ScoreboardObjective")) return o;
        try {
            return CraftUtils.getHandle(o);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("ScoreboardObjective"), getNMSScoreboard(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("ScoreboardObjective")
                    .getMethod(method)
                    .invoke(getNMSScoreboard());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("ScoreboardObjective")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNMSScoreboard(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
