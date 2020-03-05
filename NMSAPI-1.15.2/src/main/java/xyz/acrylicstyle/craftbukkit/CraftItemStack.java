package xyz.acrylicstyle.craftbukkit;

import org.bukkit.inventory.ItemStack;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unused")
public final class CraftItemStack extends ItemStack {
    public static Object asNMSCopy(ItemStack original) {
        try {
            return ReflectionUtil.getOBCClass("inventory.CraftItemStack").getMethod("asNMSCopy", ItemStack.class).invoke(null, original);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ItemStack asBukkitCopy(Object original) {
        try {
            return (ItemStack) ReflectionUtil.getOBCClass("inventory.CraftItemStack").getMethod("asBukkitCopy", ReflectionUtil.getNMSClass("ItemStack")).invoke(null, original);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
