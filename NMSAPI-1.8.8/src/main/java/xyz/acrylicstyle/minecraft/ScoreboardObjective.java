package xyz.acrylicstyle.minecraft;

import org.apache.commons.lang.NotImplementedException;
import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.CraftUtils;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class ScoreboardObjective extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("ScoreboardObjective");

    public ScoreboardObjective(Object o) {
        super(o, "ScoreboardObjective");
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
}
