package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.configurations.Warps;
import me.angelcore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setwarp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("angelcore.command.setwarp") || p.hasPermission("*") || p.isOp()){
            if (args.length == 1){
                Warps.getWarpsConfig().set("warps." + args[0] + ".x", p.getLocation().getX());
                Warps.getWarpsConfig().set("warps." + args[0] + ".y", p.getLocation().getY());
                Warps.getWarpsConfig().set("warps." + args[0] + ".z", p.getLocation().getZ());
                Warps.getWarpsConfig().set("warps." + args[0] + ".yaw", p.getLocation().getYaw());
                Warps.getWarpsConfig().set("warps." + args[0] + ".pitch", p.getLocation().getPitch());
                Warps.getWarpsConfig().set("warps." + args[0] + ".world", p.getLocation().getWorld().getName());
                Warps.saveWarpsConfig();
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("setHome").replace("%home%", args[0])));
            }else {
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("setWarpArgument")));
            }
        }

        return false;
    }

}
