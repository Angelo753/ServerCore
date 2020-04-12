package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.configurations.Warps;
import me.angelcore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warps implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!Warps.getWarpsConfig().getString("warps").isEmpty()) {
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("warps")));
            for (String list : Warps.getWarpsConfig().getConfigurationSection("warps").getKeys(false)){
                if (list.isEmpty()){
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("noWarps")));
                }else {
                    int x = Warps.getWarpsConfig().getInt("warps."+ list +".x");
                    int y = Warps.getWarpsConfig().getInt("warps."+ list +".y");
                    int z = Warps.getWarpsConfig().getInt("warps."+ list +".z");
                    String world = Warps.getWarpsConfig().getString("warps." + list +".world");
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("warpsList").replace("%warps%", list).replace("%x%", String.valueOf(x)).replace("%y%", String.valueOf(y)).replace("%z%", String.valueOf(z)).replace("%world%", world)));

                }
            }
        }else {
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("noWarps")));
        }
        return false;
    }

}
