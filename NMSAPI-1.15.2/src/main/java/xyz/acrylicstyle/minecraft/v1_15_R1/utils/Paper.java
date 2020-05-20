package xyz.acrylicstyle.minecraft.v1_15_R1.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that object is only available on paper spigot.<br />
 * <strong>May throw error if server isn't running under paper spigot!</strong>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
public @interface Paper {
}
