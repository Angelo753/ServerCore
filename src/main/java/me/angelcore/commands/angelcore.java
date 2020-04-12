package me.angelcore.commands;

import me.angelcore.Main;
import me.angelcore.configurations.Messages;
import me.angelcore.configurations.PlayerConfig;
import me.angelcore.configurations.Warps;
import me.angelcore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class angelcore implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.isOp() || p.hasPermission("*") || p.hasPermission("angelcore.command.reload")) {
            if (args[0].equalsIgnoreCase("reload")) {
                Main.plugin.reloadConfig();
                Messages.saveMessagesConfig();
                Warps.createWarpsConfig();
                ArrayList players = new ArrayList(Bukkit.getOnlinePlayers());
                if (players != null) {
                    for (int i = 0; i < players.size(); i++) {
                        Player playerList = (Player) players.get(i);
                        PlayerConfig.createPlayerCfg(playerList);
                    }
                }else {

                }
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("reload")));
            }
        }
        return false;
    }
}
