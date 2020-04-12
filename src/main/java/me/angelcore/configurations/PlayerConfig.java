package me.angelcore.configurations;

import me.angelcore.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class PlayerConfig implements Listener {


    private static FileConfiguration playerCfg;
    private static File playerFile;

    public static void createPlayerCfg(Player p) {
        playerFile = new File(Main.plugin.getDataFolder(), "userdata/" + p.getUniqueId() + ".yml");
        File playerDirectory = new File(Main.plugin.getDataFolder(), "userdata");
        if (!playerDirectory.exists()){
            playerDirectory.mkdir();
        }
        if (!playerFile.exists()){
            try {
                playerFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        playerCfg = YamlConfiguration.loadConfiguration(playerFile);
    }

    public static void savePlayerConfig(Player p) {
        try {
            playerCfg.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileConfiguration getPlayerConfig(Player p){
        return playerCfg;
    }

}
