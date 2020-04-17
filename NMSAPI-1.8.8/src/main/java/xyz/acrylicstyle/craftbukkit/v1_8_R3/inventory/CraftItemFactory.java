package xyz.acrylicstyle.craftbukkit.v1_8_R3.inventory;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.acrylicstyle.shared.NMSAPI;

public class CraftItemFactory extends NMSAPI implements ItemFactory {
    public static final Class<?> CLASS = getClassWithoutException("inventory.CraftItemFactory");

    public static final Color DEFAULT_LEATHER_COLOR = Color.fromRGB(10511680);

    public static final ImmutableSet<Object> KNOWN_NBT_ATTRIBUTE_NAMES;

    private static final CraftItemFactory instance = new CraftItemFactory();

    static {
        KNOWN_NBT_ATTRIBUTE_NAMES = ImmutableSet.builder()
                .add("generic.attackDamage")
                .add("generic.followRange")
                .add("generic.knockbackResistance")
                .add("generic.maxHealth")
                .add("generic.movementSpeed")
                .add("horse.jumpStrength")
                .add("zombie.spawnReinforcements")
                .build();
    }

    public boolean isApplicable(ItemMeta meta, ItemStack itemStack) {
        if (itemStack == null) return false;
        return isApplicable(meta, itemStack.getType());
    }

    public boolean isApplicable(ItemMeta meta, Material type) {
        return (boolean) invoke("isApplicable", meta, type);
    }

    @Override
    public boolean equals(ItemMeta meta1, ItemMeta meta2) throws IllegalArgumentException {
        return (boolean) invoke("equals", meta1, meta2);
    }

    @Override
    public ItemMeta asMetaFor(ItemMeta meta, ItemStack stack) throws IllegalArgumentException {
        return (ItemMeta) invoke("asMetaFor", meta, stack);
    }

    @Override
    public ItemMeta asMetaFor(ItemMeta meta, Material material) throws IllegalArgumentException {
        return (ItemMeta) invoke("asMetaFor", meta, material);
    }

    @Override
    public Color getDefaultLeatherColor() {
        return (Color) invoke("getDefaultLeatherColor");
    }

    public ItemMeta getItemMeta(Material material) {
        Validate.notNull(material, "Material cannot be null");
        return (ItemMeta) invoke("getItemMeta");
    }

    public CraftItemFactory(Object o) {
        super(o, "inventory.CraftItemFactory");
    }

    public CraftItemFactory() {
        super("inventory.CraftItemFactory");
    }

    public static CraftItemFactory instance() {
        return instance;
    }
}
