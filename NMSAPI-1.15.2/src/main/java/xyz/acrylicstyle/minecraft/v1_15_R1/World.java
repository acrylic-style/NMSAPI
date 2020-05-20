package xyz.acrylicstyle.minecraft.v1_15_R1;

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

    @Override
    public TileEntity getTileEntity(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return new TileEntity(method("getTileEntity", BlockPosition.class).invokeObj(getHandle(), blockPosition.getHandle()));
    }

    @Override
    public IBlockData getType(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return IBlockData.getInstance(method("getType", BlockPosition.class).invokeObj(getHandle(), blockPosition));
    }

    @Override
    public boolean isEmpty(xyz.acrylicstyle.minecraft.v1_15_R1.BlockPosition blockPosition) {
        return (boolean) method("isEmpty", BlockPosition.class).invokeObj(getHandle(), blockPosition);
    }

    @Override
    public int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection) {
        return (int) method("getBlockPower", BlockPosition.class, EnumDirection.class).invokeObj(getHandle(), blockPosition, enumDirection);
    }

    @NotNull
    @Contract("_ -> new")
    public static World newInstance(Object o) {
        return new World(o) {};
    }
}
