package xyz.acrylicstyle.minecraft;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.shared.NMSAPI;

public abstract class World extends NMSAPI implements IBlockAccess {
    public World(Object o) {
        super(o, "World");
    }

    @NotNull
    @Contract("_ -> new")
    public static World newInstance(Object o) {
        return new World(o) {
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
