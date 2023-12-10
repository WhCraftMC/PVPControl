package top.whcraft.pvpcontrol.Listeners;

import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import top.whcraft.pvpcontrol.Main;

public class RegainListener implements Listener {
    @EventHandler
    public void regain(EntityRegainHealthEvent e){
        if (e.getEntity() instanceof Player && e.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
            if (ConfigManager.isNoLifeRecovery()){
                if (Main.pvpmode.get(e.getEntity().getUniqueId())){
                    e.setCancelled(true);
                    e.setAmount(0.0D);
                }
            }
        }
    }
}
