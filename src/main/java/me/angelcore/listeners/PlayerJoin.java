package me.angelcore.listeners;

import me.angelcore.configurations.PlayerConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private PlayerConfig playerConfig;

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        PlayerConfig.createPlayerCfg(p);
        PlayerConfig.savePlayerConfig(p);
        if (!PlayerConfig.getPlayerConfig(p).contains("lastlocation")){
            PlayerConfig.getPlayerConfig(p).set("lastlocation.x", p.getLocation().getX());
            PlayerConfig.getPlayerConfig(p).set("lastlocation.y", p.getLocation().getY());
            PlayerConfig.getPlayerConfig(p).set("lastlocation.z", p.getLocation().getZ());
            PlayerConfig.getPlayerConfig(p).set("lastlocation.yaw", p.getLocation().getYaw());
            PlayerConfig.getPlayerConfig(p).set("lastlocation.pitch", p.getLocation().getPitch());
            PlayerConfig.getPlayerConfig(p).set("lastlocation.world", p.getLocation().getWorld().getName());
            PlayerConfig.savePlayerConfig(p);
        }
    }

}
