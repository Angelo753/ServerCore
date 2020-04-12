package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.configurations.PlayerConfig;
import me.angelcore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class homes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!PlayerConfig.getPlayerConfig(p).getString("homes").isEmpty()) {
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("homes")));
            for (String list : PlayerConfig.getPlayerConfig(p).getConfigurationSection("homes").getKeys(false)){
                if (list.isEmpty()){
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("noHome")));
                }else {
                    int x = PlayerConfig.getPlayerConfig(p).getInt("homes."+ list +".x");
                    int y = PlayerConfig.getPlayerConfig(p).getInt("homes."+ list +".y");
                    int z = PlayerConfig.getPlayerConfig(p).getInt("homes."+ list +".z");
                    String world = PlayerConfig.getPlayerConfig(p).getString("homes." + list +".world");
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("homesList").replace("%home%", list).replace("%x%", String.valueOf(x)).replace("%y%", String.valueOf(y)).replace("%z%", String.valueOf(z)).replace("%world%", world)));

                }
            }
        }else {
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("noHome")));
        }
        return false;
    }
}
