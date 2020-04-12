package me.angelcore.configurations;

import me.angelcore.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {

    private static FileConfiguration messagesCfg;
    private static File messagesFile;

    public static void createMessagesConfig() {
        messagesFile = new File(Main.plugin.getDataFolder(), "messages.yml");
        if (!messagesFile.exists()){
            Main.plugin.saveResource("messages.yml", false);
        }
        messagesCfg = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public static void saveMessagesConfig() {
        try {
            messagesCfg.save(messagesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void reloadMessagesConfig() {
        messagesCfg = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public static FileConfiguration getMessagesConfig(){
        return messagesCfg;
    }

}
