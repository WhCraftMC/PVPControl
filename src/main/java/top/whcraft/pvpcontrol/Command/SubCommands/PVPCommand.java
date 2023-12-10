package top.whcraft.pvpcontrol.Command.SubCommands;

import top.whcraft.pvpcontrol.Command.SubCommand;
import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import top.whcraft.pvpcontrol.Events.PlayerToggleModeEvent;
import top.whcraft.pvpcontrol.Main;
import top.whcraft.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PVPCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if (args.length == 2){
            if (args[1].equalsIgnoreCase("on")){
                Main.pvpmode.put(player.getUniqueId(), true);
                String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
                Utils.Message(player, msg);
                if (ConfigManager.isNoLifeRecovery()){
                    Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getAttackStates());
                }
                if (ConfigManager.isTitleMessage()){
                    String title = PlaceholderAPI.setPlaceholders(player, ConfigManager.getToggleMode());
                    Utils.MessageTitle(player, "", title);
                }
                Bukkit.getPluginManager().callEvent(new PlayerToggleModeEvent(player, true));
                return;
            } else if (args[1].equalsIgnoreCase("off")){
                Main.pvpmode.put(player.getUniqueId(), false);
                String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
                Utils.Message(player, msg);
                if (ConfigManager.isTitleMessage()){
                    String title = PlaceholderAPI.setPlaceholders(player, ConfigManager.getToggleMode());
                    Utils.MessageTitle(player, "", title);
                }
                Bukkit.getPluginManager().callEvent(new PlayerToggleModeEvent(player, false));
                return;
            } else {
                Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
                return;
            }
        } else if (args.length == 3){
            if (!(player.hasPermission("PVPControl.Admin"))){
                Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getNoPermission());
                return;
            }
            if (args[1].equalsIgnoreCase("on")){
                Player p1 = Bukkit.getPlayer(args[2]);
                Main.pvpmode.put(p1.getUniqueId(), true);
                String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getAdminSetPVPMode());
                String msg2 = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
                Utils.Message(player, msg);
                Utils.Message(p1, msg2);
                if (ConfigManager.isNoLifeRecovery()){
                    Utils.Message(p1, ConfigManager.getPrefix() + ConfigManager.getAttackStates());
                }
                if (ConfigManager.isTitleMessage()){
                    String title = PlaceholderAPI.setPlaceholders(player, ConfigManager.getToggleMode());
                    Utils.MessageTitle(p1, "", title);
                }
                Bukkit.getPluginManager().callEvent(new PlayerToggleModeEvent(p1, true));
                return;
            }
            if (args[1].equalsIgnoreCase("off")){
                Player p1 = Bukkit.getPlayer(args[2]);
                Main.pvpmode.put(p1.getUniqueId(), false);
                String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getAdminSetPVPMode());
                String msg2 = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
                Utils.Message(player, msg);
                Utils.Message(p1, msg2);
                if (ConfigManager.isTitleMessage()){
                    String title = PlaceholderAPI.setPlaceholders(player, ConfigManager.getToggleMode());
                    Utils.MessageTitle(p1, "", title);
                }
                Bukkit.getPluginManager().callEvent(new PlayerToggleModeEvent(p1, false));
                return;
            } else {
                Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
                return;
            }

        } else {
            Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
            return;
        }
    }

    @Override
    public String name() {
        return Main.getInstance().commandManager.pvp;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
