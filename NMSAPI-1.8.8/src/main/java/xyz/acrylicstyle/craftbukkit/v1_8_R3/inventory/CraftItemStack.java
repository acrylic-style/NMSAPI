package xyz.acrylicstyle.craftbukkit.v1_8_R3.inventory;

import org.bukkit.inventory.ItemStack;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.util.Handler;
import xyz.acrylicstyle.minecraft.v1_8_R1.NBTTagCompound;
import xyz.acrylicstyle.shared.OBCAPI;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unused")
public class CraftItemStack extends ItemStack implements Handler<xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack> {
    public static final Class<?> CLASS = OBCAPI.getClassWithoutException("inventory.CraftItemStack");

    public static xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack asNMSCopy(ItemStack original) {
        try {
            return new xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack(ReflectionUtil.getOBCClass("inventory.CraftItemStack")
                    .getMethod("asNMSCopy", ItemStack.class)
                    .invoke(null, original));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static ItemStack asBukkitCopy(xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack original) {
        try {
            return (ItemStack) ReflectionUtil.getOBCClass("inventory.CraftItemStack")
                    .getMethod("asBukkitCopy", ReflectionUtil.getNMSClass("ItemStack"))
                    .invoke(null, original.getNMSClass());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean makeTag(xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack item) {
        if (item == null) return false;
        if (item.getTag() == null) item.setTag(new NBTTagCompound());
        return true;
    }

    @Override
    public xyz.acrylicstyle.minecraft.v1_8_R1.ItemStack getHandle() {
        return asNMSCopy(this);
    }
}
