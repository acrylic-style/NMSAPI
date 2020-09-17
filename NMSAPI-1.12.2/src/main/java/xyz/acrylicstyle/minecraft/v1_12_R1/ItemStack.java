package xyz.acrylicstyle.minecraft.v1_12_R1;

import util.CollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ItemStack {
    public NBTTagCompound save(NBTTagCompound nbtTagCompound) {
        return new NBTTagCompound(invoke("save", nbtTagCompound.getHandle()));
    }

    public void c(NBTTagCompound nbtTagCompound) {
        invoke("c", nbtTagCompound.getHandle());
    }

    public ItemStack cloneItemStack() {
        return new ItemStack(invoke("cloneItemStack"));
    }

    public boolean hasTag() {
        return (boolean) invoke("hasTag");
    }

    public NBTTagCompound getTag() {
        return new NBTTagCompound(getField("tag"));
    }

    public NBTTagCompound a(String s, boolean flag) {
        return new NBTTagCompound(invoke("a", s, flag));
    }

    public NBTTagList getEnchantments() {
        return new NBTTagList(invoke("getEnchantments"));
    }

    public void setTag(NBTTagCompound nbtTagCompound) {
        invoke("setTag", nbtTagCompound.getHandle());
    }

    public String getName() {
        return (String) invoke("getName");
    }

    public ItemStack c(String s) {
        return new ItemStack(invoke("c", s));
    }

    public void r() {
        invoke("r");
    }

    public boolean hasName() {
        return (boolean) invoke("hasName");
    }

    public boolean v() {
        return (boolean) invoke("v");
    }

    public boolean hasEnchantments() {
        return (boolean) invoke("hasEnchantments");
    }

    public void a(String s, NBTBase nbtBase) {
        invoke("a", s, nbtBase.toNMSObject());
    }

    public boolean x() {
        return (boolean) invoke("x");
    }

    public boolean y() {
        return (boolean) invoke("y");
    }

    public int getRepairCost() {
        return (int) invoke("getRepairCost");
    }

    public void setRepairCost(int i) {
        invoke("setRepairCost", i);
    }

    public void setItem(Item item) {
        invoke("setItem", item.getNMSClass());
    }

    public int j() {
        return (int) invoke("j");
    }

    public boolean isDamaged(int i, Random random) {
        return (boolean) invoke("isDamaged", i, random);
    }

    public void setData(int i) {
        invoke("setData", i);
    }

    public int h() {
        return getData();
    }

    public int getData() {
        return (int) getField("damage");
    }

    public boolean g() {
        return (boolean) invoke("g");
    }

    public boolean usesData() {
        return (boolean) invoke("usesData");
    }

    public boolean e() {
        return (boolean) invoke("e");
    }

    public boolean isStackable() {
        return (boolean) invoke("isStackable");
    }

    public int getMaxStackSize() {
        return (int) invoke("getMaxStackSize");
    }

    public Item getItem() {
        return new Item(getField("item"));
    }

    public ItemStack cloneAndSubtract(int i) {
        return new ItemStack(invoke("cloneAndSubtract", i));
    }

    public static ItemStack createStack(NBTTagCompound nbtTagCompound) {
        ItemStack itemStack = new ItemStack();
        itemStack.c(nbtTagCompound);
        return (itemStack.getItem() != null) ? itemStack : null;
    }

    public ItemStack() {
        try {
            this.o = ReflectionUtil.getNMSClass("ItemStack").getConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    // NMSAPI start
    private Object o;

    public ItemStack(Object o) {
        this.o = o;
    }

    public Object getNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("ItemStack").getCanonicalName())) return o;
        } catch (ClassNotFoundException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("ItemStack"), getNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("ItemStack")
                    .getMethod(method)
                    .invoke(getNMSClass());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = new CollectionList<>();
            for (Object o1 : o) classes.add(o1.getClass());
            return ReflectionUtil.getNMSClass("ItemStack")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(getNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    // NMSAPI end
}
