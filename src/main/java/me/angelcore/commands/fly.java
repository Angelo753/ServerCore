package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.isOp() || p.hasPermission("*") || p.hasPermission("angelcore.command.fly")){
            if (!p.isFlying() && !p.getAllowFlight()){
                p.setAllowFlight(true);
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("flyOn")));
            }else {
                p.setAllowFlight(false);
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("flyOff")));
            }
        }
        return false;
    }
}
