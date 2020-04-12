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

public class back implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("*") || p.hasPermission("angelcore.command.back") || p.isOp()){
            Double x = PlayerConfig.getPlayerConfig(p).getDouble("lastlocation.x");
            Double y = PlayerConfig.getPlayerConfig(p).getDouble("lastlocation.y");
            Double z = PlayerConfig.getPlayerConfig(p).getDouble("lastlocation.z");
            float yaw = PlayerConfig.getPlayerConfig(p).getInt("lastlocation.yaw");
            float pitch = PlayerConfig.getPlayerConfig(p).getInt("lastlocation.pitch");
            World world = Bukkit.getWorld(PlayerConfig.getPlayerConfig(p).getString("lastlocation.world"));
            if (!Bukkit.getWorlds().contains(world)){
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("teleportError").replace("%world%", String.valueOf(world))));
            }else {
                p.teleport(new Location(world, x, y, z, yaw, pitch));
                p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("back")));
            }
        }
        return false;
    }
}
