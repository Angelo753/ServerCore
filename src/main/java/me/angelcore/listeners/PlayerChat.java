package me.angelcore.listeners;

import me.angelcore.Main;
import me.angelcore.utils.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void playerChatFormat(AsyncPlayerChatEvent e){
        if (Main.plugin.getConfig().getBoolean("chat-format.enabled")) {
            e.setFormat(Chat.chat(Main.plugin.getConfig().getString("chat-format.format").replace("%player%", e.getPlayer().getDisplayName()).replace("%message%", e.getMessage())));
        }
    }


}
