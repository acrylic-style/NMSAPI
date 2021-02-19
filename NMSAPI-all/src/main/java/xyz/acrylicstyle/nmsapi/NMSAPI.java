package xyz.acrylicstyle.nmsapi;

import xyz.acrylicstyle.nmsapi.shared.AbstractNMSAPI;
import xyz.acrylicstyle.tomeito_api.utils.Log;
import xyz.acrylicstyle.tomeito_api.utils.ReflectionUtil;

public class NMSAPI extends AbstractNMSAPI {
    private static final Log.Logger LOGGER = Log.with("NMSAPI");
    private static boolean warned = false;

    private static void warn() {
        if (!warned) {
            LOGGER.warn("==================================================");
            LOGGER.warn("");
            LOGGER.warn("NMSAPI does not fully support " + ReflectionUtil.getServerVersion() + ". You've been warned!");
            LOGGER.warn("");
            LOGGER.warn("==================================================");
            warned = true;
        }
    }
}
