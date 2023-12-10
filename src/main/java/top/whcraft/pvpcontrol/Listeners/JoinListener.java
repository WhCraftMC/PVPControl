package top.whcraft.pvpcontrol.Listeners;

import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import top.whcraft.pvpcontrol.Main;
import top.whcraft.pvpcontrol.Utils;

public class JoinListener implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (ConfigManager.isDefaultPVPMode()){
            Main.pvpmode.put(p.getUniqueId(), true);
            String msg = PlaceholderAPI.setPlaceholders(p, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
            Utils.Message(p, msg);
            return;
        } else {
            Main.pvpmode.put(p.getUniqueId(), false);
            String msg = PlaceholderAPI.setPlaceholders(p, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
            Utils.Message(p, msg);
            return;
        }
    }
}
