package top.whcraft.pvpcontrol.PlaceHolderAPIHook;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import top.whcraft.pvpcontrol.Main;

public class PlaceHolderAPIHook extends PlaceholderExpansion {
    private Main pvpControl;

    public PlaceHolderAPIHook(Main pvpControl) {
        this.pvpControl = pvpControl;
    }
    public String getIdentifier(){
        return "pvpcontrol";
    }

    @Override
    public String getAuthor() {
        return Main.getInstance().getDescription().getAuthors().toString();
    }

    @Override
    public String getVersion() {
        return Main.getInstance().getDescription().getVersion();
    }

    public String onPlaceholderRequest(Player player, String s) {
        if (s.equals("mode"))
            if (Main.pvpmode.get(player.getUniqueId())){
                return "&c战斗模式";
            } else {
                return "&a和平模式";
            }
        if (player == null)
            return "";
        return null;
    }
}
