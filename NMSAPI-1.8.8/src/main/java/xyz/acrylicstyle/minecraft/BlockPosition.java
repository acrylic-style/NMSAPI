package xyz.acrylicstyle.minecraft;

import util.CollectionList;
import util.ICollectionList;
import util.ReflectionHelper;
import xyz.acrylicstyle.tomeito_core.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unused")
public class BlockPosition extends BaseBlockPosition {
    public static final BlockPosition ZERO = new BlockPosition(0, 0, 0);

    // public BlockPosition(Entity paramEntity)
    // public BlockPosition(Vec3D paramVec3D)

    public BlockPosition a(double d1, double d2, double d3) {
        return new BlockPosition(invoke("a", d1, d2, d3));
    }

    public BlockPosition a(int i1, int i2, int i3) {
        return new BlockPosition(invoke("a", i1, i2, i3));
    }

    public BlockPosition a(BaseBlockPosition baseBlockPosition) {
        return new BlockPosition(invoke("a", baseBlockPosition.toNMSClass()));
    }

    public BlockPosition b(BaseBlockPosition baseBlockPosition) {
        return new BlockPosition(invoke("b", baseBlockPosition.toNMSClass()));
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
        return new BlockPosition(invoke("shift", enumDirection.toNMSEnum()));
    }

    public BlockPosition shift(EnumDirection enumDirection, int i1) {
        return new BlockPosition(invoke("shift", enumDirection.toNMSEnum(), i1));
    }

    public BlockPosition c(BaseBlockPosition baseBlockPosition) {
        return new BlockPosition(invoke("c", baseBlockPosition.toNMSClass()));
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

    public static Iterable<BlockPosition> a(BlockPosition blockPosition1, BlockPosition blockPosition2) {
        try {
            Iterable<?> iterable = (Iterable<?>) ReflectionUtil.getNMSClass("BlockPosition")
                    .getMethod("a", ReflectionUtil.getNMSClass("BlockPosition"), ReflectionUtil.getNMSClass("BlockPosition"))
                    .invoke(null, blockPosition1, blockPosition2);
            return new CollectionList<>(iterable).map(BlockPosition::new);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Iterable<BlockPosition> b(BlockPosition blockPosition1, BlockPosition blockPosition2) {
        try {
            Iterable<?> iterable = (Iterable<?>) ReflectionUtil.getNMSClass("BlockPosition")
                    .getMethod("b", ReflectionUtil.getNMSClass("BlockPosition"), ReflectionUtil.getNMSClass("BlockPosition"))
                    .invoke(null, blockPosition1, blockPosition2);
            return new CollectionList<>(iterable).map(BlockPosition::new);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static final class MutableBlockPosition extends BlockPosition {
        private int c;
        private int d;
        private int e;

        public MutableBlockPosition() {
            this(0, 0, 0);
        }

        public MutableBlockPosition(int i1, int i2, int i3) {
            super(0, 0, 0);
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
            this.c = i1;
            this.d = i2;
            this.e = i3;
            return this;
        }

        public Object toNMSClass() {
            try {
                return ReflectionUtil
                        .getNMSClass("BlockPosition.MutableBlockPosition")
                        .getConstructor(int.class, int.class, int.class)
                        .newInstance(this.c, this.d, this.e);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BlockPosition(BaseBlockPosition baseBlockPosition) {
        this(baseBlockPosition.getX(), baseBlockPosition.getY(), baseBlockPosition.getZ());
    }

    // NMSAPI start
    private Object o;

    public BlockPosition(Object o) {
        super(o);
        this.o = o;
    }

    public BlockPosition(int i1, int i2, int i3) {
        super(i1, i2, i3);
        try {
            this.o = ReflectionUtil.getNMSClass("BlockPosition")
                    .getConstructor(int.class, int.class, int.class)
                    .newInstance(i1, i2, i3);
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public BlockPosition(double double1, double double2, double double3) {
        super(double1, double2, double3);
        try {
            this.o = ReflectionUtil.getNMSClass("BlockPosition")
                    .getConstructor(double.class, double.class, double.class)
                    .newInstance(double1, double2, double3);
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object toNMSClass() {
        try {
            if (o.getClass().getCanonicalName().equals(ReflectionUtil.getNMSClass("BlockPosition").getCanonicalName())) return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getField(String field) {
        try {
            return ReflectionHelper.getField(ReflectionUtil.getNMSClass("BlockPosition"), toNMSClass(), field);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invoke(String method) {
        try {
            return ReflectionUtil.getNMSClass("BlockPosition")
                    .getMethod(method)
                    .invoke(toNMSClass());
        } catch (NoSuchMethodException e) {
            try {
                return ReflectionUtil.getNMSClass("BlockPosition")
                        .getSuperclass()
                        .getMethod(method)
                        .invoke(toNMSClass());
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(String method, Object... o) {
        try {
            CollectionList<Class<?>> classes = ICollectionList.asList(o).map(Object::getClass);
            return ReflectionUtil.getNMSClass("BlockPosition")
                    .getMethod(method, classes.toArray(new Class[0]))
                    .invoke(toNMSClass(), o);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(String field, Object value) {
        try {
            Field f = ReflectionUtil.getNMSClass("BlockPosition").getDeclaredField(field);
            f.setAccessible(true);
            f.set(toNMSClass(), value);
        } catch (NoSuchFieldException e) {
            try {
                Field f = ReflectionUtil.getNMSClass("BlockPosition").getSuperclass().getDeclaredField(field);
                f.setAccessible(true);
                f.set(toNMSClass(), value);
            } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    // NMSAPI end
}
