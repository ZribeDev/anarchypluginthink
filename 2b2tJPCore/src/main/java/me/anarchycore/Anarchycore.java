package me.anarchycore;

import me.anarchycore.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.Objects;

public final class Anarchycore extends JavaPlugin implements Listener {
    public static Boolean witherprot = false;
    public static Boolean elytradisable = false;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getCommand("asettings").setExecutor(new cmd_anarchysettings());
        getCommand("gmc").setExecutor(new cmd_gmc());
        getCommand("gms").setExecutor(new cmd_gms());
        getCommand("kill").setExecutor(new cmd_kill());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (e.getMessage().startsWith(">")) {
            e.setMessage(ChatColor.GREEN + e.getMessage());
        }

    }


    @EventHandler
    public void onCreateSpawn(CreatureSpawnEvent event) {
        if (witherprot) {
            if (event.getEntity().getType() == EntityType.WITHER) {
                event.setCancelled(true);

            }
        }
    }

    @EventHandler
    public void ElytraDisable(EntityToggleGlideEvent e){
        if (elytradisable) {
            Player p = (Player) e.getEntity();
            if ((!p.isGliding())) {
                e.setCancelled(true);
            }

        }
    }
}
