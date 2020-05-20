package xyz.acrylicstyle.minecraft.v1_15_R1;

import util.CollectionList;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

@SuppressWarnings("unused")
public class BlockPosition extends BaseBlockPosition {
    public static final Class<?> CLASS = getClassWithoutException("BlockPosition");

    public static final BlockPosition ZERO = new BlockPosition(0D, 0D, 0D);

    public BlockPosition(Entity paramEntity) {
        super("BlockPosition", paramEntity.getNMSClass());
    }

    public BlockPosition(Vec3D paramVec3D) {
        super("BlockPosition", paramVec3D.getNMSClass());
    }

    public BlockPosition(String s, Object... o) {
        super(s, o);
    }

    public BlockPosition a(double d1, double d2, double d3) {
        return new BlockPosition(invoke("a", d1, d2, d3));
    }

    public BlockPosition a(int i1, int i2, int i3) {
        return new BlockPosition(invoke("a", i1, i2, i3));
    }

    public BlockPosition a(BaseBlockPosition baseBlockPosition) {
        return new BlockPosition(invoke("a", baseBlockPosition.getNMSClass()));
    }

    public BlockPosition b(BaseBlockPosition baseBlockPosition) {
        return new BlockPosition(invoke("b", baseBlockPosition.getNMSClass()));
    }

    public BlockPosition up() {
        return new BlockPosition(invoke("up"));
    }

    public BlockPosition up(int i1) {
        return new BlockPosition(invoke("up", i1));
    }

    public BlockPosition down() {
        return new BlockPosition(invoke("down"));
    }

    public BlockPosition down(int i1) {
        return new BlockPosition(invoke("down", i1));
    }

    public BlockPosition north() {
        return new BlockPosition(invoke("north"));
    }

    public BlockPosition north(int i1) {
        return new BlockPosition(invoke("north", i1));
    }

    public BlockPosition south() {
        return new BlockPosition(invoke("south"));
    }

    public BlockPosition south(int i1) {
        return new BlockPosition(invoke("south", i1));
    }

    public BlockPosition west() {
        return new BlockPosition(invoke("west"));
    }

    public BlockPosition west(int i1) {
        return new BlockPosition(invoke("west", i1));
    }

    public BlockPosition east() {
        return new BlockPosition(invoke("east"));
    }

    public BlockPosition east(int i1) {
        return new BlockPosition(invoke("east", i1));
    }

    public BlockPosition shift(EnumDirection enumDirection) {
        return new BlockPosition(invoke("shift", enumDirection.getHandle()));
    }

    public BlockPosition shift(EnumDirection enumDirection, int i1) {
        return new BlockPosition(invoke("shift", enumDirection.getHandle(), i1));
    }

    public BlockPosition c(BaseBlockPosition baseBlockPosition) {
        return new BlockPosition(invoke("c", baseBlockPosition.getNMSClass()));
    }

    public long asLong() {
        return (long) invoke("asLong");
    }

    public static BlockPosition fromLong(long paramLong) {
        try {
            return new BlockPosition(ReflectionUtil.getNMSClass("BlockPosition").getMethod("fromLong", long.class).invoke(null, paramLong));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("Convert2MethodRef")
    public static Iterable<BlockPosition> a(BlockPosition blockPosition1, BlockPosition blockPosition2) {
        try {
            Iterable<?> iterable = (Iterable<?>) ReflectionUtil.getNMSClass("BlockPosition")
                    .getMethod("a", ReflectionUtil.getNMSClass("BlockPosition"), ReflectionUtil.getNMSClass("BlockPosition"))
                    .invoke(null, blockPosition1, blockPosition2);
            return new CollectionList<>(iterable).map(o -> new BlockPosition(o));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("Convert2MethodRef")
    public static Iterable<BlockPosition> b(BlockPosition blockPosition1, BlockPosition blockPosition2) {
        try {
            Iterable<?> iterable = (Iterable<?>) ReflectionUtil.getNMSClass("BlockPosition")
                    .getMethod("b", ReflectionUtil.getNMSClass("BlockPosition"), ReflectionUtil.getNMSClass("BlockPosition"))
                    .invoke(null, blockPosition1, blockPosition2);
            return new CollectionList<>(iterable).map(o -> new BlockPosition(o));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static final class MutableBlockPosition extends BlockPosition {
        public static final Class<?> CLASS = getClassWithoutException("BlockPosition$MutableBlockPosition");

        private int c;
        private int d;
        private int e;

        public MutableBlockPosition() {
            this(0, 0, 0);
        }

        public MutableBlockPosition(int i1, int i2, int i3) {
            super("BlockPosition.MutableBlockPosition", 0, 0, 0);
            this.c = i1;
            this.d = i2;
            this.e = i3;
        }

        public int getX() {
            return this.c;
        }

        public int getY() {
            return this.d;
        }

        public int getZ() {
            return this.e;
        }

        public MutableBlockPosition c(int i1, int i2, int i3) {
            invoke("c", i1, i2, i3);
            this.c = i1;
            this.d = i2;
            this.e = i3;
            return this;
        }
    }

    public BlockPosition(BaseBlockPosition baseBlockPosition) {
        this(baseBlockPosition.getX(), baseBlockPosition.getY(), baseBlockPosition.getZ());
    }

    public BlockPosition(Object o) {
        super(o, "BlockPosition");
    }

    public BlockPosition(int i1, int i2, int i3) {
        super("BlockPosition", i1, i2, i3);
    }

    public BlockPosition(double double1, double double2, double double3) {
        super("BlockPosition", double1, double2, double3);
    }

    public final boolean isValidLocation() {
        return getX() >= -30000000 && getZ() >= -30000000 && getX() < 30000000 && getZ() < 30000000 && getY() >= 0 && getY() < 256;
    }

    public final boolean isInvalidYLocation() {
        return getY() < 0 || getY() >= 256;
    }
}
