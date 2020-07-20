package xyz.acrylicstyle.minecraft.v1_8_R1;

import xyz.acrylicstyle.shared.NMSAPI;

public class ServerCommand extends NMSAPI {
    public static final Class<?> CLASS = getClassWithoutException("ServerCommand");

    public ServerCommand(Object o) {
        super(o, "ServerCommand");
        this.command = (String) getField("command");
        this.source = null;
    }

    public final String command;
    public final ICommandListener source;

    public ServerCommand(String paramString, ICommandListener paramICommandListener) {
        super("ServerCommand", paramString, paramICommandListener.getNMSClass());
        this.command = (String) getField("command");
        this.source = paramICommandListener;
    }
}
