package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.configurations.PlayerConfig;
import me.angelcore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sethome implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) {
            PlayerConfig.getPlayerConfig(p).set("homes.home.x", p.getLocation().getX());
            PlayerConfig.getPlayerConfig(p).set("homes.home.y", p.getLocation().getY());
            PlayerConfig.getPlayerConfig(p).set("homes.home.z", p.getLocation().getZ());
            PlayerConfig.getPlayerConfig(p).set("homes.home.yaw", p.getLocation().getYaw());
            PlayerConfig.getPlayerConfig(p).set("homes.home.pitch", p.getLocation().getPitch());
            PlayerConfig.getPlayerConfig(p).set("homes.home.world", p.getLocation().getWorld().getName());
            PlayerConfig.savePlayerConfig(p);
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("setHome").replace("%home%", "home")));
        } else {
            if (args.length == 1){
                PlayerConfig.getPlayerConfig(p).set("homes." + args[0] + ".x", p.getLocation().getX());
                PlayerConfig.getPlayerConfig(p).set("homes." + args[0] + ".y", p.getLocation().getY());
                PlayerConfig.getPlayerConfig(p).set("homes." + args[0] + ".z", p.getLocation().getZ());
                PlayerConfig.getPlayerConfig(p).set("homes." + args[0] + ".yaw", p.getLocation().getYaw());
                PlayerConfig.getPlayerConfig(p).set("homes." + args[0] + ".pitch", p.getLocation().getPitch());
                PlayerConfig.getPlayerConfig(p).set("homes." + args[0] + ".world", p.getLocation().getWorld().getName());
                PlayerConfig.savePlayerConfig(p);
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("setHome").replace("%home%", args[0])));
            }else {
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("setHomeArgument")));
            }
        }
        return false;
    }
}
