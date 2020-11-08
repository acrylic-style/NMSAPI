package xyz.acrylicstyle.nmsapi.test;

import org.bukkit.plugin.java.JavaPlugin;
import util.reflector.Reflector;
import xyz.acrylicstyle.tomeito_api.TomeitoAPI;
import xyz.acrylicstyle.tomeito_api.utils.Log;

public class NMSAPITest extends JavaPlugin {
    @Override
    public void onEnable() {
        Reflector.classLoader = this.getClassLoader();
        TomeitoAPI.getInstance().registerCommands(this.getClassLoader(), "nmsapi", "xyz.acrylicstyle.nmsapi.test.commands");
        Log.info("Enabled NMSAPI-TestPlugin");
    }
}
