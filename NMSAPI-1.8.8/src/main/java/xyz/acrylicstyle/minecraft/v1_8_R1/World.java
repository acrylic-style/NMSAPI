package xyz.acrylicstyle.minecraft.v1_8_R1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.shared.NMSAPI;

public abstract class World extends NMSAPI implements IBlockAccess {
    public static final Class<?> CLASS = getClassWithoutException("World");

    protected World(String clazz, Object... o) {
        super(clazz, o);
    }

    protected World(Object o, String clazz) {
        super(o, clazz);
    }

    public World(Object o) {
        super(o, "World");
    }

    public org.bukkit.World getWorld() { return (org.bukkit.World) invoke("getWorld"); }

    @NotNull
    @Contract("_ -> new")
    public static World newInstance(Object o) {
        return new World(o) {
            @Override
            public TileEntity getTileEntity(BlockPosition blockPosition) {
                return null;
            }

            @Override
            public IBlockData getType(BlockPosition blockPosition) {
                return null;
            }

            @Override
            public boolean isEmpty(BlockPosition blockPosition) {
                return false;
            }

            @Override
            public int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection) {
                return 0;
            }
        };
    }
}
