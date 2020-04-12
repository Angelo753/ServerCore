package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tp implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("*") || p.hasPermission("angelcore.command.tp") || p.isOp()) {
            if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("teleport").replace("%player%", p.getDisplayName()).replace("%target%", p.getDisplayName())));
                    p.teleport(player.getLocation());
                }else {
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("playerIsOffline").replace("%player%", args[0])));
                }
            } else {
                if (args.length == 2) {
                    Player player = Bukkit.getPlayer(args[0]);
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null && player != null) {
                        p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("teleport").replace("%player%", p.getDisplayName()).replace("%target%", target.getDisplayName())));
                        player.teleport(target.getLocation());
                    }else {
                        p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("playerIsOffline").replace("%player%", args[0])));
                    }
                } else {
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("").replace("%command%", "/tp <player>")));
                }
            }
        }
        return false;
    }
}
