package me.angelcore.commands;

import me.angelcore.Main;
import me.angelcore.configurations.Messages;
import me.angelcore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Double x = Main.plugin.getConfig().getDouble("spawn.x");
        Double y = Main.plugin.getConfig().getDouble("spawn.y");
        Double z = Main.plugin.getConfig().getDouble("spawn.z");
        float yaw = Main.plugin.getConfig().getInt("spawn.yaw");
        float pitch = Main.plugin.getConfig().getInt("spawn.pitch");
        World world = Bukkit.getWorld(Main.plugin.getConfig().getString("spawn.world"));
        if (Bukkit.getWorlds().contains(world)) {
            p.teleport(new Location(world, x, y, z, yaw, pitch));
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("spawnTeleport")));
        } else {
            p.sendMessage(Chat.chat(Messages.getMessagesConfig().getString("worldNotExists").replace("%world%", (CharSequence) world)));
        }
        return false;
    }
}
