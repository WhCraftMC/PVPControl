package top.whcraft.pvpcontrol.Command.SubCommands;

import top.whcraft.pvpcontrol.Command.SubCommand;
import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import top.whcraft.pvpcontrol.Events.PlayerToggleModeEvent;
import top.whcraft.pvpcontrol.Main;
import top.whcraft.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ToggleCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if (args.length != 1){
            Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
            return;
        }
        if (Main.pvpmode.get(player.getUniqueId())){
            Main.pvpmode.put(player.getUniqueId(), false);
            String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
            Utils.Message(player, msg);
            if (ConfigManager.isTitleMessage()){
                String title = PlaceholderAPI.setPlaceholders(player, ConfigManager.getToggleMode());
                Utils.MessageTitle(player, "", title);
            }
            Bukkit.getPluginManager().callEvent(new PlayerToggleModeEvent(player, false));
        } else {
            Main.pvpmode.put(player.getUniqueId(), true);
            String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getToggleMode());
            Utils.Message(player, msg);
            if (ConfigManager.isTitleMessage()){
                String title = PlaceholderAPI.setPlaceholders(player, ConfigManager.getToggleMode());
                Utils.MessageTitle(player, "", title);
            }
            if (ConfigManager.isNoLifeRecovery()){
                Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getAttackStates());
            }
            Bukkit.getPluginManager().callEvent(new PlayerToggleModeEvent(player, true));
        }
    }

    @Override
    public String name() {
        return Main.getInstance().commandManager.toggle;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
