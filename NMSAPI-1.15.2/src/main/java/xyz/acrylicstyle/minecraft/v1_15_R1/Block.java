package xyz.acrylicstyle.minecraft.v1_15_R1;

import org.bukkit.Material;
import org.jetbrains.annotations.Contract;
import util.reflect.Ref;
import xyz.acrylicstyle.shared.NMSAPI;

public class Block extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("Block");

    public Block(Object o) {
        super(o, "Block");
    }

    @Contract("_ -> null") // todo: update when IBlockData is done
    public static IBlockData getByCombinedId(int i) {
        return IBlockData.getInstance(getByCombinedIdRaw(i));
    }

    @Contract("_, _ -> null") // todo: update when IBlockData is done
    public static IBlockData getByCombinedId(Material material, byte data) {
        return IBlockData.getInstance(getByCombinedIdRaw(material, data));
    }

    public static Object getByCombinedIdRaw(int i) {
        return Ref.getMethod(CLASS, "getByCombinedId", int.class).invoke(null, i);
    }

    @SuppressWarnings("deprecation")
    public static Object getByCombinedIdRaw(Material material, byte data) {
        return getByCombinedIdRaw(material.getId() + (data << 12));
    }
}
