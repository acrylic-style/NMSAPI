package xyz.acrylicstyle.minecraft;

public interface IBlockAccess {
    // TileEntity getTileEntity(BlockPosition blockPosition);
    IBlockData getType(BlockPosition blockPosition);
    boolean isEmpty(BlockPosition blockPosition);
    int getBlockPower(BlockPosition blockPosition, EnumDirection enumDirection);
}
