package xyz.acrylicstyle.minecraft;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import org.apache.commons.lang.Validate;
import xyz.acrylicstyle.shared.NMSAPI;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.UUID;

@SuppressWarnings("unused")
public class PacketDataSerializer extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("PacketDataSerializer");

    public PacketDataSerializer() {
        super("PacketDataSerializer");
    }

    public PacketDataSerializer(ByteBuf byteBuf) {
        super("PacketDataSerializer", byteBuf);
    }

    public static int a(int i) {
        for (int j = 1; j < 5; j++) {
            if ((i & -1 << j * 7) == 0)
                return j;
        }
        return 5;
    }

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    public void a(byte[] bytes) {
        invoke("a", bytes);
    }

    public byte[] a() {
        return (byte[]) invoke("a");
    }

    public BlockPosition c() {
        return new BlockPosition(invoke("c"));
    }

    public void a(BlockPosition blockPosition) {
        invoke("a", blockPosition.getHandle());
    }

    public IChatBaseComponent d() {
        return new ChatComponentText(invoke("d"));
    }

    public void a(IChatBaseComponent iChatBaseComponent) {
        invoke("a", iChatBaseComponent.getHandle());
    }

    public Enum<?> a(Class<?> oClass) {
        return ((Enum<?>[]) oClass.getEnumConstants())[e()];
    }

    public void a(Enum<?> oEnum) {
        b(oEnum.ordinal());
    }

    public int e() {
        return (int) invoke("e");
    }

    public long f() {
        return (long) invoke("f");
    }

    public void a(UUID uuid) {
        invoke("a", uuid);
    }

    public UUID g() {
        return (UUID) invoke("g");
    }

    public void b(int i) {
        invoke("b", i);
    }

    public void b(long i) {
        invoke("b", i);
    }

    public void a(NBTTagCompound nbtTagCompound) {
        invoke("a", nbtTagCompound.getNMSClass());
    }

    public NBTTagCompound h() {
        return new NBTTagCompound(invoke("h"));
    }

    public void a(ItemStack itemStack) { invoke("a", itemStack.getHandle()); }

    public ItemStack i() { return new ItemStack(invoke("i")); }

    public String c(int i) {
        return (String) invoke("c", i);
    }

    public PacketDataSerializer a(String s) {
        return PacketDataSerializer.fromPacketDataSerializer(invoke("a", s));
    }

    public int capacity() {
        return (int) invoke("capacity");
    }

    public ByteBuf capacity(int i) {
        return (ByteBuf) invoke("capacity", i);
    }

    public int maxCapacity() {
        return (int) invoke("maxCapacity");
    }

    public ByteBufAllocator alloc() {
        return (ByteBufAllocator) invoke("alloc");
    }

    public ByteOrder order() {
        return (ByteOrder) invoke("order");
    }

    public ByteBuf order(ByteOrder byteOrder) {
        return (ByteBuf) invoke("order", byteOrder);
    }

    public ByteBuf unwrap() {
        return (ByteBuf) invoke("unwrap");
    }

    public boolean isDirect() {
        return (boolean) invoke("isDirect");
    }

    public int readerIndex() {
        return (int) invoke("readerIndex");
    }

    public ByteBuf readerIndex(int i) {
        return (ByteBuf) invoke("readerIndex", i);
    }

    public int writerIndex() {
        return (int) invoke("writerIndex");
    }

    public ByteBuf writerIndex(int i) {
        return (ByteBuf) invoke("writerIndex", i);
    }

    public ByteBuf setIndex(int i, int j) {
        return (ByteBuf) invoke("setIndex", i, j);
    }

    public int readableBytes() {
        return (int) invoke("readableBytes");
    }

    public int writableBytes() {
        return (int) invoke("writableBytes");
    }

    public int maxWritableBytes() {
        return (int) invoke("maxWritableBytes");
    }

    public boolean isReadable() {
        return (boolean) invoke("isReadable");
    }

    public boolean isReadable(int i) {
        return (boolean) invoke("isReadable", i);
    }

    public boolean isWritable() {
        return (boolean) invoke("isWritable");
    }

    public boolean isWritable(int i) {
        return (boolean) invoke("isWritable", i);
    }

    public ByteBuf clear() {
        return (ByteBuf) invoke("clear");
    }

    public ByteBuf markReaderIndex() {
        return (ByteBuf) invoke("markReaderIndex");
    }

    public ByteBuf resetReaderIndex() {
        return (ByteBuf) invoke("resetReaderIndex");
    }

    public ByteBuf markWriterIndex() {
        return (ByteBuf) invoke("markWriterIndex");
    }

    public ByteBuf resetWriterIndex() {
        return (ByteBuf) invoke("resetWriterIndex");
    }

    public ByteBuf discardReadBytes() {
        return (ByteBuf) invoke("discardReadBytes");
    }

    public ByteBuf discardSomeReadBytes() {
        return (ByteBuf) invoke("discardSomeReadBytes");
    }

    public ByteBuf ensureWritable(int i) {
        return (ByteBuf) invoke("ensureWritable", i);
    }

    public boolean getBoolean(int i) {
        return (boolean) invoke("getBoolean", i);
    }

    public byte getByte(int i) {
        return (byte) invoke("getByte", i);
    }

    public short getUnsignedByte(int i) {
        return (short) invoke("getUnsignedByte", i);
    }

    public short getShort(int i) {
        return (short) invoke("getShort", i);
    }

    public int getUnsignedShort(int i) {
        return (int) invoke("getUnsignedShort", i);
    }

    public int getMedium(int i) {
        return (int) invoke("getMedium", i);
    }

    public int getUnsignedMedium(int i) {
        return (int) invoke("getUnsignedMedium", i);
    }

    public int getInt(int i) {
        return (int) invoke("getInt", i);
    }

    public long getUnsignedInt(int i) {
        return (long) invoke("getUnsignedInt", i);
    }

    public long getLong(int i) {
        return (long) invoke("getLong", i);
    }

    public char getChar(int i) {
        return (char) invoke("getChar", i);
    }

    public float getFloat(int i) {
        return (float) invoke("getFloat", i);
    }

    public double getDouble(int i) {
        return (double) invoke("getDouble", i);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf) {
        return (ByteBuf) invoke("getBytes", i, byteBuf);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int j) {
        return (ByteBuf) invoke("getBytes", i, byteBuf, j);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int j, int k) {
        return (ByteBuf) invoke("getBytes", i, byteBuf, j, k);
    }

    public ByteBuf getBytes(int i, byte[] bytes) {
        return (ByteBuf) invoke("getBytes", i, bytes);
    }

    public ByteBuf getBytes(int i, byte[] bytes, int j, int k) {
        return (ByteBuf) invoke("getBytes", i, bytes, j, k);
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        return (ByteBuf) invoke("getBytes", i, byteBuffer);
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int j) {
        return (ByteBuf) invoke("getBytes", i, outputStream, j);
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int j) {
        return (int) invoke("getBytes", i, gatheringByteChannel, j);
    }

    public ByteBuf setBoolean(int i, boolean flag) {
        return (ByteBuf) invoke("setBoolean", i, flag);
    }

    public ByteBuf setByte(int i, int j) {
        return (ByteBuf) invoke("setByte", i, j);
    }

    public ByteBuf setShort(int i, int j) {
        return (ByteBuf) invoke("setShort", i, j);
    }

    public ByteBuf setMedium(int i, int j) {
        return (ByteBuf) invoke("setMedium", i, j);
    }

    public ByteBuf setInt(int i, int j) {
        return (ByteBuf) invoke("setInt", i, j);
    }

    public ByteBuf setLong(int i, long j) {
        return (ByteBuf) invoke("setLong", i, j);
    }

    public ByteBuf setChar(int i, int j) {
        return (ByteBuf) invoke("setChar", i, j);
    }

    public ByteBuf setFloat(int i, float f) {
        return (ByteBuf) invoke("setFloat", i, f);
    }

    public ByteBuf setDouble(int i, double d0) {
        return (ByteBuf) invoke("setDouble", i, d0);
    }

    public ByteBuf setBytes(int i, ByteBuf bytebuf) {
        return (ByteBuf) invoke("setBytes", i, bytebuf);
    }

    public ByteBuf setBytes(int i, ByteBuf bytebuf, int j) {
        return (ByteBuf) invoke("setBytes", i, bytebuf, j);
    }

    public ByteBuf setBytes(int i, ByteBuf bytebuf, int j, int k) {
        return (ByteBuf) invoke("setBytes", i, bytebuf, j, k);
    }

    public ByteBuf setBytes(int i, byte[] abyte) {
        return (ByteBuf) invoke("setBytes", i, abyte);
    }

    public ByteBuf setBytes(int i, byte[] abyte, int j, int k) {
        return (ByteBuf) invoke("setBytes", i, abyte, j, k);
    }

    public ByteBuf setBytes(int i, ByteBuffer bytebuffer) {
        return (ByteBuf) invoke("setBytes", i, bytebuffer);
    }

    public int setBytes(int i, InputStream inputstream, int j) {
        return (int) invoke("setBytes", i, inputstream, j);
    }

    public int setBytes(int i, ScatteringByteChannel scatteringbytechannel, int j) {
        return (int) invoke("setBytes", i, scatteringbytechannel, j);
    }

    public ByteBuf setZero(int i, int j) {
        return (ByteBuf) invoke("setZero", i, j);
    }

    public boolean readBoolean() {
        return (boolean) invoke("readBoolean");
    }

    public byte readByte() {
        return (byte) invoke("readByte");
    }

    public short readUnsignedByte() {
        return (short) invoke("readUnsignedByte");
    }

    public short readShort() {
        return (short) invoke("readShort");
    }

    public int readUnsignedShort() {
        return (int) invoke("readUnsignedShort");
    }

    public int readMedium() {
        return (int) invoke("readMedium");
    }

    public int readUnsignedMedium() {
        return (int) invoke("readUnsignedMedium");
    }

    public int readInt() {
        return (int) invoke("readInt");
    }

    public long readUnsignedInt() {
        return (long) invoke("readUnsignedInt");
    }

    public long readLong() {
        return (long) invoke("readLong");
    }

    public char readChar() {
        return (char) invoke("readChar");
    }

    public float readFloat() {
        return (float) invoke("readFloat");
    }

    public double readDouble() {
        return (double) invoke("readDouble");
    }

    public ByteBuf readBytes(int i) {
        return (ByteBuf) invoke("readBytes", i);
    }

    public ByteBuf readSlice(int i) {
        return (ByteBuf) invoke("readSlice", i);
    }

    public ByteBuf readBytes(ByteBuf bytebuf) {
        return (ByteBuf) invoke("readBytes", bytebuf);
    }

    public ByteBuf readBytes(ByteBuf bytebuf, int i) {
        return (ByteBuf) invoke("readBytes", bytebuf, i);
    }

    public ByteBuf readBytes(ByteBuf bytebuf, int i, int j) {
        return (ByteBuf) invoke("readBytes", bytebuf, i, j);
    }

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    public ByteBuf readBytes(byte[] abyte) {
        return (ByteBuf) invoke("readBytes", abyte);
    }

    public ByteBuf readBytes(byte[] abyte, int i, int j) {
        return (ByteBuf) invoke("readBytes", abyte, i, j);
    }

    public ByteBuf readBytes(ByteBuffer bytebuffer) {
        return (ByteBuf) invoke("readBytes", bytebuffer);
    }

    public ByteBuf readBytes(OutputStream outputstream, int i) {
        return (ByteBuf) invoke("readBytes", outputstream, i);
    }

    public int readBytes(GatheringByteChannel gatheringbytechannel, int i) {
        return (int) invoke("readBytes", gatheringbytechannel, i);
    }

    public ByteBuf skipBytes(int i) {
        return (ByteBuf) invoke("skipBytes", i);
    }

    public ByteBuf writeBoolean(boolean flag) {
        return (ByteBuf) invoke("writeBoolean", flag);
    }

    public ByteBuf writeByte(int i) {
        return (ByteBuf) invoke("writeByte", i);
    }

    public ByteBuf writeShort(int i) {
        return (ByteBuf) invoke("writeShort", i);
    }

    public ByteBuf writeMedium(int i) {
        return (ByteBuf) invoke("writeMedium", i);
    }

    public ByteBuf writeInt(int i) {
        return (ByteBuf) invoke("writeInt", i);
    }

    public ByteBuf writeLong(long i) {
        return (ByteBuf) invoke("writeLong", i);
    }

    public ByteBuf writeChar(int i) {
        return (ByteBuf) invoke("writeChar", i);
    }

    public ByteBuf writeFloat(float f) {
        return (ByteBuf) invoke("writeFloat", f);
    }

    public ByteBuf writeDouble(double d0) {
        return (ByteBuf) invoke("writeDouble", d0);
    }

    public ByteBuf writeBytes(ByteBuf bytebuf) {
        return (ByteBuf) invoke("writeBytes", bytebuf);
    }

    public ByteBuf writeBytes(ByteBuf bytebuf, int i) {
        return (ByteBuf) invoke("writeBytes", bytebuf, i);
    }

    public ByteBuf writeBytes(ByteBuf bytebuf, int i, int j) {
        return (ByteBuf) invoke("writeBytes", bytebuf, i, j);
    }

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    public ByteBuf writeBytes(byte[] abyte) {
        return (ByteBuf) invoke("writeBytes", abyte);
    }

    public ByteBuf writeBytes(byte[] abyte, int i, int j) {
        return (ByteBuf) invoke("writeBytes", abyte, i, j);
    }

    public ByteBuf writeBytes(ByteBuffer bytebuffer) {
        return (ByteBuf) invoke("writeBytes", bytebuffer);
    }

    public int writeBytes(InputStream inputstream, int i) {
        return (int) invoke("writeBytes", inputstream, i);
    }

    public int writeBytes(ScatteringByteChannel scatteringbytechannel, int i) {
        return (int) invoke("writeBytes", scatteringbytechannel, i);
    }

    public ByteBuf writeZero(int i) {
        return (ByteBuf) invoke("writeZero", i);
    }

    public int indexOf(int i, int j, byte b0) {
        return (int) invoke("indexOf", i, j, b0);
    }

    public int bytesBefore(byte b0) {
        return (int) invoke("bytesBefore", b0);
    }

    public int bytesBefore(int i, byte b0) {
        return (int) invoke("bytesBefore", i, b0);
    }

    public int bytesBefore(int i, int j, byte b0) {
        return (int) invoke("bytesBefore", i, j, b0);
    }

    public int forEachByte(@Deprecated ByteBufProcessor bytebufprocessor) {
        return (int) invoke("forEachByte", bytebufprocessor);
    }

    public int forEachByte(int i, int j, @Deprecated ByteBufProcessor bytebufprocessor) {
        return (int) invoke("forEachByte", i, j, bytebufprocessor);
    }

    public int forEachByteDesc(@Deprecated ByteBufProcessor bytebufprocessor) {
        return (int) invoke("forEachByteDesc", bytebufprocessor);
    }

    public int forEachByteDesc(int i, int j, @Deprecated ByteBufProcessor bytebufprocessor) {
        return (int) invoke("forEachByteDesc", i, j, bytebufprocessor);
    }

    public ByteBuf copy() {
        return (ByteBuf) invoke("copy");
    }

    public ByteBuf copy(int i, int j) {
        return (ByteBuf) invoke("copy", i, j);
    }

    public ByteBuf slice() {
        return (ByteBuf) invoke("slice");
    }

    public ByteBuf slice(int i, int j) {
        return (ByteBuf) invoke("slice", i, j);
    }

    public ByteBuf duplicate() {
        return (ByteBuf) invoke("duplicate");
    }

    public int nioBufferCount() {
        return (int) invoke("nioBufferCount");
    }

    public ByteBuffer nioBuffer() {
        return (ByteBuffer) invoke("nioBuffer");
    }

    public ByteBuffer nioBuffer(int i, int j) {
        return (ByteBuffer) invoke("nioBuffer", i, j);
    }

    public ByteBuffer internalNioBuffer(int i, int j) {
        return (ByteBuffer) invoke("internalNioBuffer", i, j);
    }

    public ByteBuffer[] nioBuffers() {
        return (ByteBuffer[]) invoke("nioBuffers");
    }

    public ByteBuffer[] nioBuffers(int i, int j) {
        return (ByteBuffer[]) invoke("nioBuffers", i, j);
    }

    public boolean hasArray() {
        return (boolean) invoke("hasArray");
    }

    public byte[] array() {
        return (byte[]) invoke("array");
    }

    public int arrayOffset() {
        return (int) invoke("arrayOffset");
    }

    public boolean hasMemoryAddress() {
        return (boolean) invoke("hasMemoryAddress");
    }

    public long memoryAddress() {
        return (long) invoke("memoryAddress");
    }

    public String toString(Charset charset) {
        return (String) invoke("toString", charset);
    }

    public String toString(int i, int j, Charset charset) {
        return (String) invoke("toString", i, j, charset);
    }

    public int hashCode() {
        return (int) invoke("hashCode");
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object object) {
        return (boolean) invoke("equals", object);
    }

    public int compareTo(ByteBuf bytebuf) {
        return (int) invoke("compareTo", bytebuf);
    }

    public String toString() {
        return (String) invoke("toString");
    }

    public ByteBuf retain(int i) {
        return (ByteBuf) invoke("retain", i);
    }

    public ByteBuf retain() {
        return (ByteBuf) invoke("retain");
    }

    public int refCnt() {
        return (int) invoke("refCnt");
    }

    public boolean release() {
        return (boolean) invoke("release");
    }

    public boolean release(int i) {
        return (boolean) invoke("release", i);
    }

    public static PacketDataSerializer fromPacketDataSerializer(Object o) {
        Validate.notNull(o, "Object cannot be null");
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer();
        packetDataSerializer.o = o;
        return packetDataSerializer;
    }
}
