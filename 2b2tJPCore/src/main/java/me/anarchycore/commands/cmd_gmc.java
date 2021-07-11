package me.anarchycore.commands;

import me.anarchycore.Anarchycore;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_gmc  implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("anarchycore.gmc")) {
            player.setGameMode(GameMode.CREATIVE);
        }
        return false;
    }
}
