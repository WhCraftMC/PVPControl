package top.whcraft.pvpcontrol.Command.SubCommands;

import top.whcraft.pvpcontrol.Command.SubCommand;
import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import top.whcraft.pvpcontrol.Main;
import top.whcraft.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class meCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if (args.length != 1){
            Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
            return;
        }
        if (Main.pvpmode.get(player.getUniqueId())){
            String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getSelfMode());
            Utils.Message(player, msg);
        } else {
            String msg = PlaceholderAPI.setPlaceholders(player, ConfigManager.getPrefix() + ConfigManager.getSelfMode());
            Utils.Message(player, msg);
        }

    }

    @Override
    public String name() {
        return Main.getInstance().commandManager.me;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
