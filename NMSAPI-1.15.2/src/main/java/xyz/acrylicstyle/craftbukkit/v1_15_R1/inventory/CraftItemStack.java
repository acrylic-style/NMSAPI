package xyz.acrylicstyle.craftbukkit.v1_15_R1.inventory;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unused")
public final class CraftItemStack extends ItemStack {
    public static xyz.acrylicstyle.minecraft.v1_15_R1.ItemStack asNMSCopy(ItemStack original) {
        try {
            return new xyz.acrylicstyle.minecraft.v1_15_R1.ItemStack(ReflectionUtil.getOBCClass("inventory.CraftItemStack").getMethod("asNMSCopy", ItemStack.class).invoke(null, original));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static ItemStack asBukkitCopy(xyz.acrylicstyle.minecraft.v1_15_R1.ItemStack original) {
        try {
            return (ItemStack) ReflectionUtil.getOBCClass("inventory.CraftItemStack").getMethod("asBukkitCopy", ReflectionUtil.getNMSClass("ItemStack")).invoke(null, original.getHandle());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void makeTag(xyz.acrylicstyle.minecraft.v1_15_R1.ItemStack stack) {
        NMSAPI.invokeStatic("inventory.CraftItemStack", null, "makeTag", stack == null ? null : stack.getHandle());
    }
}
