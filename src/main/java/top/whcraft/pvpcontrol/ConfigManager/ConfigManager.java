package top.whcraft.pvpcontrol.ConfigManager;

import top.whcraft.pvpcontrol.Main;

import java.util.List;

public class ConfigManager {
    // 前缀部分
    public static String getPrefix(){
        return Main.getInstance().getConfig().getString("Prefix").replaceAll("§","&");
    }

    // Settings 部分
    public static Boolean isDefaultPVPMode(){
        return Main.getInstance().getConfig().getBoolean("Settings.DefaultPVPMode");
    }
    public static Boolean isTitleMessage(){
        return Main.getInstance().getConfig().getBoolean("Settings.TitleMessage");
    }
    public static Boolean isNoLifeRecovery(){
        return Main.getInstance().getConfig().getBoolean("Settings.NoLifeRecovery");
    }

    // Language 部分
    public static String getNoPermission(){
        return Main.getInstance().getConfig().getString("Language.NoPermission").replaceAll("§","&");
    }
    public static String getSucessfullyReload(){
        return Main.getInstance().getConfig().getString("Language.SucessfullyReload").replaceAll("§","&");
    }
    public static String getCancelAttack(){
        return Main.getInstance().getConfig().getString("Language.CancelAttack").replaceAll("§","&");
    }
    public static String getCancelAttack2(){
        return Main.getInstance().getConfig().getString("Language.CancelAttack2").replaceAll("§","&");
    }
    public static String getToggleMode(){
        return Main.getInstance().getConfig().getString("Language.ToggleMode").replaceAll("§","&");
    }
    public static String getAdminSetPVPMode(){
        return Main.getInstance().getConfig().getString("Language.AdminSetPVPMode").replaceAll("§","&");
    }
    public static String getAttackStates(){
        return Main.getInstance().getConfig().getString("Language.AttackStates").replaceAll("§","&");
    }
    public static String getSelfMode(){
        return Main.getInstance().getConfig().getString("Language.SelfMode").replaceAll("§","&");
    }
    public static String getTargetMode(){
        return Main.getInstance().getConfig().getString("Language.TargetMode").replaceAll("§","&");
    }
    public static String getDantiaoStart(){
        return Main.getInstance().getConfig().getString("Language.DantiaoStart").replaceAll("§","&");
    }

    public static List<String> getWorld(){
        return Main.getInstance().getConfig().getStringList("DisableWorld");
    }

}
