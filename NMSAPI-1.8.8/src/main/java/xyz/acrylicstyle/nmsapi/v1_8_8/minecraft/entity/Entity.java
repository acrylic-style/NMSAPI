package xyz.acrylicstyle.nmsapi.v1_8_8.minecraft.entity;

import util.reflector.ForwardMethod;

public interface Entity extends xyz.acrylicstyle.nmsapi.shared.minecraft.entity.Entity {
    @ForwardMethod("V")
    @Override
    boolean isInWater();
}
