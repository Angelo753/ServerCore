package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.configurations.PlayerConfig;
import me.angelcore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class home implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.isOp() || p.hasPermission("angelcore.command.home") || p.hasPermission("*")){
            if (args.length == 0) {
                Double x = PlayerConfig.getPlayerConfig(p).getDouble("homes.home.x");
                Double y = PlayerConfig.getPlayerConfig(p).getDouble("homes.home.y");
                Double z = PlayerConfig.getPlayerConfig(p).getDouble("homes.home.z");
                float yaw = PlayerConfig.getPlayerConfig(p).getInt("homes.home.yaw");
                float pitch = PlayerConfig.getPlayerConfig(p).getInt("homes.home.pitch");
                World world = Bukkit.getWorld(PlayerConfig.getPlayerConfig(p).getString("homes.home.world"));
                if (Bukkit.getWorlds().contains(world)) {
                    p.teleport(new Location(world, x, y, z, yaw, pitch));
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("homeTeleport").replace("%home%", "home")));
                } else {
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("worldNotExists").replace("%world%", (CharSequence) world)));
                }
            }else {
                if (args.length == 1) {
                    if (PlayerConfig.getPlayerConfig(p).getConfigurationSection("homes").contains(args[0])) {
                        Double x = PlayerConfig.getPlayerConfig(p).getDouble("homes." + args[0] + ".x");
                        Double y = PlayerConfig.getPlayerConfig(p).getDouble("homes." + args[0] + ".y");
                        Double z = PlayerConfig.getPlayerConfig(p).getDouble("homes." + args[0] + ".z");
                        float yaw = PlayerConfig.getPlayerConfig(p).getInt("homes." + args[0] + ".yaw");
                        float pitch = PlayerConfig.getPlayerConfig(p).getInt("homes." + args[0] + ".pitch");
                        World world = Bukkit.getWorld(PlayerConfig.getPlayerConfig(p).getString("homes." + args[0] + ".world"));
                        p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("homeTeleport").replace("%home%", args[0])));
                        if (Bukkit.getWorlds().contains(world)) {
                            p.teleport(new Location(world, x, y, z, yaw, pitch));
                        } else {
                            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("worldNotExists").replace("%world%", (CharSequence) world)));
                        }
                    } else {
                        p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("homeNotExists").replace("%home%", args[0])));
                    }
                }else {
                    p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("homeArgument")));
                }
            }
        }
        return false;
    }
}
