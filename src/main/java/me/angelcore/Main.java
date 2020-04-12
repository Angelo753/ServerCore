package me.angelcore;

import me.angelcore.commands.*;
import me.angelcore.configurations.Messages;
import me.angelcore.configurations.PlayerConfig;
import me.angelcore.configurations.Warps;
import me.angelcore.listeners.PlayerChat;
import me.angelcore.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println(ChatColor.GREEN + "Plugin AngelCore byl zapnut.");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Messages.createMessagesConfig();
        Warps.createWarpsConfig();
        eventRegister();
        commandRegister();
        ArrayList players = new ArrayList(Bukkit.getOnlinePlayers());
        if (players != null) {
            for (int i = 0; i < players.size(); i++) {
                Player playerList = (Player) players.get(i);
                PlayerConfig.createPlayerCfg(playerList);
            }
        }else {

        }
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.GREEN + "Plugin AngelCore byl zapnut.");
    }

    public void eventRegister(){
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerChat(), this);
    }

    public void commandRegister(){
        getCommand("angelcore").setExecutor(new angelcore());
        getCommand("back").setExecutor(new back());
        getCommand("fly").setExecutor(new fly());
        getCommand("speed").setExecutor(new speed());
        getCommand("tp").setExecutor(new tp());
        getCommand("sethome").setExecutor(new sethome());
        getCommand("home").setExecutor(new home());
        getCommand("homes").setExecutor(new homes());
        getCommand("warps").setExecutor(new warps());
        getCommand("warp").setExecutor(new warp());
        getCommand("setwarp").setExecutor(new setwarp());
    }


}
