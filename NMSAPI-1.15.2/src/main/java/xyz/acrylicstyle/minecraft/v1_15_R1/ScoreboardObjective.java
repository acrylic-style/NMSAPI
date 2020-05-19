package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.apache.commons.lang.NotImplementedException;
import xyz.acrylicstyle.shared.NMSAPI;

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
