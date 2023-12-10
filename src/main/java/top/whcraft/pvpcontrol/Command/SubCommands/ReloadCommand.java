package top.whcraft.pvpcontrol.Command.SubCommands;

import top.whcraft.pvpcontrol.Command.SubCommand;
import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import top.whcraft.pvpcontrol.Main;
import top.whcraft.pvpcontrol.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class ReloadCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if (!(player.hasPermission("PVPControl.Admin"))){
            Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getNoPermission());
            return;
        }
        if (args.length != 1){
            Utils.Message(player, ConfigManager.getPrefix() + "&c请仔细检查你的参数!");
            return;
        }
        Main.getInstance().reloadConfig();
        Utils.Message(player, ConfigManager.getPrefix() + ConfigManager.getSucessfullyReload());

    }

    @Override
    public String name() {
        return Main.getInstance().commandManager.reload;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
