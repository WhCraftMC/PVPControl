package top.whcraft.pvpcontrol;

import org.bukkit.ChatColor;
import top.whcraft.pvpcontrol.Command.CommandManager;
import top.whcraft.pvpcontrol.ConfigManager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import top.whcraft.pvpcontrol.Listeners.DamageListener;
import top.whcraft.pvpcontrol.Listeners.JoinListener;
import top.whcraft.pvpcontrol.Listeners.RegainListener;
import top.whcraft.pvpcontrol.PlaceHolderAPIHook.PlaceHolderAPIHook;

import java.util.*;

public final class Main extends JavaPlugin {
    private static Main ins;
    public static Map<UUID, Boolean> pvpmode = new HashMap<>();
    public static List<String> disableWorld = new ArrayList<>();
    public CommandManager commandManager;

    @Override
    public void onEnable() {
        ins = this;
        saveDefaultConfig();
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PlaceHolderAPIHook(this).register();
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[PVPControl Hook] 依赖 &fPlaceHolderAPI &7已兼容."));
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[PVPControl Hook] &c试图调用执行未检测到并兼容的插件 &fPlaceHolderAPI"));
            setEnabled(false);
        }
        commandManager = new CommandManager();
        commandManager.setUp();
        regListener();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Main getInstance(){
        return ins;
    }

    public void regListener(){
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new RegainListener(), this);
    }

    public void addDisableWorld(){
        disableWorld.addAll(ConfigManager.getWorld());
    }

}
