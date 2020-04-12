package me.angelcore.configurations;

import me.angelcore.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Warps {

    private static FileConfiguration warpsCfg;
    private static File warpsFile;

    public static void createWarpsConfig() {
        warpsFile = new File(Main.plugin.getDataFolder(), "warps.yml");
        if (!warpsFile.exists()){
            Main.plugin.saveResource("warps.yml", false);
        }
        warpsCfg = YamlConfiguration.loadConfiguration(warpsFile);
    }

    public static void saveWarpsConfig() {
        try {
            warpsCfg.save(warpsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void reloadWarpsConfig() {
        warpsCfg = YamlConfiguration.loadConfiguration(warpsFile);
    }

    public static FileConfiguration getWarpsConfig(){
        return warpsCfg;
    }

}
