package xyz.acrylicstyle.craftbukkit;

import org.bukkit.inventory.ItemStack;
import xyz.acrylicstyle.minecraft.NBTTagCompound;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unused")
public class CraftItemStack extends ItemStack implements Handler<xyz.acrylicstyle.minecraft.ItemStack> {
    public static xyz.acrylicstyle.minecraft.ItemStack asNMSCopy(ItemStack original) {
        try {
            return new xyz.acrylicstyle.minecraft.ItemStack(ReflectionUtil.getOBCClass("inventory.CraftItemStack").getMethod("asNMSCopy", ItemStack.class).invoke(null, original));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ItemStack asBukkitCopy(xyz.acrylicstyle.minecraft.ItemStack original) {
        try {
            return (ItemStack) ReflectionUtil.getOBCClass("inventory.CraftItemStack").getMethod("asBukkitCopy", ReflectionUtil.getNMSClass("ItemStack")).invoke(null, original.getNMSClass());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean makeTag(xyz.acrylicstyle.minecraft.ItemStack item) {
        if (item == null) return false;
        if (item.getTag() == null) item.setTag(new NBTTagCompound());
        return true;
    }

    @Override
    public xyz.acrylicstyle.minecraft.ItemStack getHandle() {
        return asNMSCopy(this);
    }
}
