package me.angelcore.commands;

import me.angelcore.configurations.Messages;
import me.angelcore.configurations.Warps;
import me.angelcore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
         if (args.length == 1) {
             if (Warps.getWarpsConfig().getConfigurationSection("warps").contains(args[0])) {
                 Double x = Warps.getWarpsConfig().getDouble("warps." + args[0] + ".x");
                 Double y = Warps.getWarpsConfig().getDouble("warps." + args[0] + ".y");
                 Double z = Warps.getWarpsConfig().getDouble("warps." + args[0] + ".z");
                 float yaw = Warps.getWarpsConfig().getInt("warps." + args[0] + ".yaw");
                 float pitch = Warps.getWarpsConfig().getInt("warps." + args[0] + ".pitch");
                 World world = Bukkit.getWorld(Warps.getWarpsConfig().getString("warps." + args[0] + ".world"));
                 if (Bukkit.getWorlds().contains(world)) {
                     p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("warpsTeleport").replace("%warps%", args[0])));
                     p.teleport(new Location(world, x, y, z, yaw, pitch));
                 } else {
                     p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("worldNotExists").replace("%world%", (CharSequence) world)));
                 }
             } else {
                 p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("warpNotExists").replace("%warp%", args[0])));
             }
         }else {
             p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("warpArgument")));
         }
        return false;
    }

}
