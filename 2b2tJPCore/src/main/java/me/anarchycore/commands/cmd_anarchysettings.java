package me.anarchycore.commands;

import me.anarchycore.Anarchycore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_anarchysettings implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            Player player = (Player) sender;
            if (player.hasPermission("anarchycore.settings")) {
                if (args[0].equalsIgnoreCase("witherprot")) {
                    if (args[1].equalsIgnoreCase("on")) {
                        player.sendMessage("&0&l[&4&lAnarchy Core&0&l]&f Withers Are Now Disabled!".replace("&", "§"));
                        Anarchycore.witherprot = true;
                    } else {
                        player.sendMessage("&0&l[&4&lAnarchy Core&0&l]&f Withers Are Now Enabled!".replace("&", "§"));
                        Anarchycore.witherprot = false;
                    }

                } else if (args[0].equalsIgnoreCase("elytradisable")) {
                    if (args[1].equalsIgnoreCase("on")) {
                        player.sendMessage("&0&l[&4&lAnarchy Core&0&l]&f Elytras Are Now Disabled!".replace("&", "§"));
                        Anarchycore.elytradisable = true;
                    } else {
                        player.sendMessage("&0&l[&4&lAnarchy Core&0&l]&f Elytras Are Now Enabled!".replace("&", "§"));
                        Anarchycore.elytradisable = false;
                    }

                }

            }
        } else {
            sender.sendMessage("&0&l[&4&lAnarchy Core&0&l]&f Use /asettings (elytradisable/witherprot) (on/off)".replace("&", "§"));
        }

        return true;
    }
}
