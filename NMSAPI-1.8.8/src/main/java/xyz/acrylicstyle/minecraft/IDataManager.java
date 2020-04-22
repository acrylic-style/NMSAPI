package xyz.acrylicstyle.minecraft;

import java.io.File;
import java.util.UUID;

public interface IDataManager {
    WorldData getWorldData(); // todo: create WorldData

    void checkSession();

    Object createChunkLoader(Object paramWorldProvider); // todo: create IChunkLoader

    void saveWorldData(Object paramWorldData, NBTTagCompound paramNBTTagCompound);

    void saveWorldData(Object paramWorldData);

    Object getPlayerFileData(); // todo: create IPlayerFileData

    void a();

    File getDirectory();

    File getDataFile(String paramString);

    String g();

    UUID getUUID();

    Object getHandle();
}
