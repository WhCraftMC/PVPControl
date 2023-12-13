package top.whcraft.pvpcontrol.Listeners;

import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import top.whcraft.pvpcontrol.Main;
import top.whcraft.pvpcontrol.Utils;

public class DamageListener implements Listener {
    @EventHandler
    public void Damage(EntityDamageByEntityEvent e){
        if (e.isCancelled()) {
            return; // 屏蔽已取消的
        }

        // 是玩家
        if (e.getDamager() instanceof Player){
            // 攻击者是玩家
            if (e.getEntity() instanceof Player Victim){
                for (String s : Main.disableWorld ) {
                    if (e.getDamager().getWorld().getName().contains(s) && e.getEntity().getWorld().getName().contains(s)){
                        return; // 屏蔽禁用的世界
                    }
                }

                // 攻击者
                Player Attacker = (Player)e.getDamager(); // 被攻击者

                // 如果玩家状态为和平，取消攻击
                if (!(Main.pvpmode.get(Attacker.getUniqueId()))){
                    Utils.Message(Attacker, ConfigManager.getPrefix() + ConfigManager.getCancelAttack());
                    e.setCancelled(true);
                    e.setDamage(0);
                    return;
                }

                // 如果玩家状态为和平，取消攻击
                if (!(Main.pvpmode.get(Victim.getUniqueId()))){
                    Utils.Message(Attacker, ConfigManager.getPrefix() + ConfigManager.getCancelAttack2());
                    e.setCancelled(true);
                    e.setDamage(0);
                    return;
                }
            }
        }

        // 是抛射物
        if (e.getDamager() instanceof Projectile) {
            // 攻击者是玩家
            if (e.getEntity() instanceof Player){
                for (String s : Main.disableWorld ) {
                    if (e.getDamager().getWorld().getName().contains(s) && e.getEntity().getWorld().getName().contains(s)){
                        return;
                    }
                }
                //获取抛射物
                Projectile projectile = (Projectile)e.getDamager();

                // 抛射物发射者是玩家
                if (projectile.getShooter() instanceof Player){
                    // 如果玩家状态为和平，取消攻击
                    if (!(Main.pvpmode.get(((Player) projectile.getShooter()).getUniqueId()))){
                        Utils.Message((Player)projectile.getShooter(), ConfigManager.getPrefix() + ConfigManager.getCancelAttack());
                        e.setCancelled(true);
                        e.setDamage(0);
                        return;
                    }
                }

                if (!(Main.pvpmode.get(e.getEntity().getUniqueId()))){
                    // 发射者是玩家，取消攻击
                    if (projectile.getShooter() instanceof Player) {
                        Utils.Message((Player) projectile.getShooter(), ConfigManager.getPrefix() + ConfigManager.getCancelAttack2());
                        e.setCancelled(true);
                        e.setDamage(0);
                    }
                    // 不是玩家
                }

            }
        }
    }
}
