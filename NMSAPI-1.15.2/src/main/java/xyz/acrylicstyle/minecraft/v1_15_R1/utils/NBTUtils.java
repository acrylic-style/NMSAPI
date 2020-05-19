package xyz.acrylicstyle.minecraft.v1_15_R1.utils;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import xyz.acrylicstyle.craftbukkit.v1_15_R1.util.CraftUtils;
import xyz.acrylicstyle.minecraft.v1_15_R1.NBTTagCompound;

import java.lang.reflect.InvocationTargetException;

public class NBTUtils extends NBTTagCompound {
    @NotNull
    public static NBTUtils load(@NotNull Entity entity) {
        NBTUtils tag = new NBTUtils();
        try {
            new xyz.acrylicstyle.minecraft.v1_15_R1.Entity(CraftUtils.getHandle(entity)).c(tag);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return tag;
    }

    @NotNull
    public static NBTUtils load(@NotNull xyz.acrylicstyle.minecraft.v1_15_R1.Entity entity) {
        NBTUtils tag = new NBTUtils();
        entity.c(tag);
        return tag;
    }

    @NotNull
    public static NBTUtils load(@NotNull ItemStack itemStack) {
        NBTUtils tag = new NBTUtils();
        xyz.acrylicstyle.minecraft.v1_15_R1.ItemStack stack = CraftItemStack.asNMSCopy(itemStack);
        CraftItemStack.makeTag(stack);
        stack.setTag(tag);
        return tag;
    }

    @NotNull
    public static NBTUtils load(@NotNull xyz.acrylicstyle.minecraft.v1_15_R1.ItemStack itemStack) {
        NBTUtils tag = new NBTUtils();
        CraftItemStack.makeTag(itemStack);
        itemStack.setTag(tag);
        return tag;
    }

    public void save(@NotNull Entity entity) {
        try {
            new xyz.acrylicstyle.minecraft.v1_15_R1.Entity(CraftUtils.getHandle(entity)).load(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(@NotNull xyz.acrylicstyle.minecraft.v1_15_R1.Entity entity) {
        entity.load(this);
    }

    public void save(@NotNull ItemStack itemStack) {
        CraftItemStack.asNMSCopy(itemStack).save(this);
    }

    public void save(@NotNull xyz.acrylicstyle.minecraft.v1_15_R1.ItemStack itemStack) {
        itemStack.save(this);
    }
}
