package xyz.acrylicstyle.nmsapi.abstracts.minecraft;

import org.jetbrains.annotations.NotNull;
import util.reflect.Ref;
import xyz.acrylicstyle.shared.NMSAPI;

import java.util.NoSuchElementException;

public enum EnumMonsterType {
    UNDEFINED,
    UNDEAD,
    ARTHROPOD,
    ILLAGER,
    WATER,
    ;

    public static final Class<?> CLASS = NMSAPI.getClassWithoutException("EnumMonsterType");

    @NotNull
    public Object getHandle() {
        try {
            return Ref.getClass(CLASS).getField(name()).get(null);
        } catch (Exception e) {
            throw new NoSuchElementException("The running minecraft version does not support EnumMonsterType." + name());
        }
    }
}
