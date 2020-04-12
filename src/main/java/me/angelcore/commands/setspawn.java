package me.angelcore.commands;

import me.angelcore.Main;
import me.angelcore.configurations.Messages;
import me.angelcore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setspawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("*") || p.hasPermission("angelcore.command.setspawn") || p.isOp()) {
            Main.plugin.getConfig().set("spawn.x", p.getLocation().getX());
            Main.plugin.getConfig().set("spawn.y", p.getLocation().getY());
            Main.plugin.getConfig().set("spawn.z", p.getLocation().getZ());
            Main.plugin.getConfig().set("spawn.yaw", p.getLocation().getYaw());
            Main.plugin.getConfig().set("spawn.pitch", p.getLocation().getPitch());
            Main.plugin.getConfig().set("spawn.world", p.getLocation().getWorld().getName());
            Main.plugin.saveDefaultConfig();
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("setSpawn")));
        }
        return false;
    }
}
