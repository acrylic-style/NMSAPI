package xyz.acrylicstyle.nmsapi.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.nmsapi.shared.craftbukkit.entity.CraftPlayer;
import xyz.acrylicstyle.tomeito_api.subcommand.PlayerSubCommandExecutor;
import xyz.acrylicstyle.tomeito_api.subcommand.SubCommand;

@SubCommand(name = "cpGetHandle", description = "Tests CraftPlayer#getHandle.", usage = "/nmsapi cpGetHandle [Player]")
public class CPGetHandleCommand extends PlayerSubCommandExecutor {
    @Override
    public void onCommand(@NotNull Player sender, @NotNull String[] args) {
        Player target = sender;
        if (args.length != 0) {
            target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Player could not be found.");
                return;
            }
        }
        try {
            CraftPlayer craftPlayer = CraftPlayer.getInstance(target);
            sender.sendMessage(ChatColor.GREEN + "CraftPlayer: " + craftPlayer);
            sender.sendMessage(ChatColor.GREEN + "EntityPlayer(Handle): " + craftPlayer.getHandle());
        } catch (Throwable e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.RED + "Something went wrong: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
