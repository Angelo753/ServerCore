package me.angelcore.utils;

import org.bukkit.ChatColor;

public class Chat {

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
