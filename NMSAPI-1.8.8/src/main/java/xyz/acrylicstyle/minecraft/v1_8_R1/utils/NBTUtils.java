package xyz.acrylicstyle.minecraft.v1_8_R1.utils;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.entity.CraftEntity;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import xyz.acrylicstyle.minecraft.v1_8_R1.NBTTagCompound;

/**
 * Be aware, this may not work on newer versions.
 */
public class NBTUtils extends NBTTagCompound {
    @NotNull
    public static NBTUtils load(@NotNull Entity entity) {
        NBTUtils tag = new NBTUtils();
        new CraftEntity(entity).getHandle().c(tag);
        return tag;
    }

    @NotNull
    public static NBTUtils load(@NotNull xyz.acrylicstyle.minecraft.v1_8_R1.Entity entity) {
        NBTUtils tag = new NBTUtils();
        entity.c(tag);
        return tag;
    }

    @NotNull
    public static NBTUtils load(@NotNull ItemStack itemStack) {
        NBTUtils tag = new NBTUtils();
        xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack stack = CraftItemStack.asNMSCopy(itemStack);
        CraftItemStack.makeTag(stack);
        stack.c(tag);
        return tag;
    }

    @NotNull
    public static NBTUtils load(@NotNull xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack itemStack) {
        NBTUtils tag = new NBTUtils();
        CraftItemStack.makeTag(itemStack);
        itemStack.c(tag);
        return tag;
    }

    public void save(@NotNull Entity entity) {
        new CraftEntity(entity).getHandle().f(this);
    }

    public void save(@NotNull xyz.acrylicstyle.minecraft.v1_8_R1.Entity entity) {
        entity.f(this);
    }

    public void save(@NotNull ItemStack itemStack) {
        CraftItemStack.asNMSCopy(itemStack).save(this);
    }

    public void save(@NotNull xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack itemStack) {
        itemStack.save(this);
    }
}
