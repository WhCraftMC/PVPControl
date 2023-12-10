package top.whcraft.pvpcontrol.Command.SubCommands;

import top.whcraft.pvpcontrol.Command.SubCommand;
import top.whcraft.pvpcontrol.Main;
import top.whcraft.pvpcontrol.Utils;
import org.bukkit.entity.Player;

public class HelpCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        Utils.Help(player);
    }

    @Override
    public String name() {
        return Main.getInstance().commandManager.help;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
