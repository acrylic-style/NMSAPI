package xyz.acrylicstyle.minecraft.v1_15_R1;

import xyz.acrylicstyle.shared.NMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;

public class Item extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("Item");

    public static int getId(Item paramItem) {
        try {
            ReflectionUtil.getNMSClass("Item").getMethod("getId", ReflectionUtil.getNMSClass("Item")).invoke(null, paramItem.getNMSClass());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static Item getById(int paramInt) {
        try {
            ReflectionUtil.getNMSClass("Item").getMethod("getById", int.class).invoke(null, paramInt);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Item getItemOf(Object paramBlock) {
        try {
            ReflectionUtil.getNMSClass("Item").getMethod("getItemOf", ReflectionUtil.getNMSClass("Block")).invoke(null, paramBlock);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Item d(String paramString) {
        try {
            ReflectionUtil.getNMSClass("Item").getMethod("d", String.class).invoke(null, paramString);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean a(NBTTagCompound paramNBTTagCompound) {
        return (boolean) invoke("a", paramNBTTagCompound.getNMSClass());
    }

    public enum EnumToolMaterial {
        WOOD(0, 59, 2.0F, 0.0F, 15),
        STONE(1, 131, 4.0F, 1.0F, 5),
        IRON(2, 250, 6.0F, 2.0F, 14),
        EMERALD(3, 1561, 8.0F, 3.0F, 10),
        GOLD(0, 32, 12.0F, 0.0F, 22);

        private final int f;

        private final int g;

        private final float h;

        private final float i;

        private final int j;

        EnumToolMaterial(int param1Int1, int param1Int2, float param1Float1, float param1Float2, int param1Int3) {
            this.f = param1Int1;
            this.g = param1Int2;
            this.h = param1Float1;
            this.i = param1Float2;
            this.j = param1Int3;
        }

        public int a() {
            return this.g;
        }

        public float b() {
            return this.h;
        }

        public float c() {
            return this.i;
        }

        public int d() {
            return this.f;
        }

        public int e() {
            return this.j;
        }

        public Item f() {/*
            if (this == WOOD)
                return Item.getItemOf(Blocks.PLANKS);
            if (this == STONE)
                return Item.getItemOf(Blocks.COBBLESTONE);
            if (this == GOLD)
                return Items.GOLD_INGOT;
            if (this == IRON)
                return Items.IRON_INGOT;
            if (this == EMERALD)
                return Items.DIAMOND;*/
            return null;
        }
    }

    public Item c(int paramInt) {
        invoke("c", paramInt);
        return this;
    }

    public Item setMaxStackSize(int maxStackSize) {
        return c(maxStackSize);
    }

    public boolean interactWith(Object paramItemStack, EntityPlayer paramEntityHuman, Object paramWorld, Object paramBlockPosition, Object paramEnumDirection, float paramFloat1, float paramFloat2, float paramFloat3) {
        return false;
    }

    public float getDestroySpeed(Object paramItemStack, Object paramBlock) {
        return 1.0F;
    }

    public int getMaxStackSize() {
        return (int) getField("maxStackSize");
    }

    public boolean usesDurability() {
        return (boolean) invoke("usesDurability");
    }

    public boolean k() {
        return (boolean) getField("j");
    }

    public Item a(boolean paramBoolean) {
        invoke("a", paramBoolean);
        return this;
    }

    public boolean isUnbreakable() {
        return k();
    }

    public Item setUnbreakable(boolean unbreakable) {
        return a(unbreakable);
    }

    // NMSAPI start
    public Item() {
        super("Item");
    }

    public Item(Object o) {
        super(o, "Item");
    }
}
