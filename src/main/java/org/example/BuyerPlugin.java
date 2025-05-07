package org.example;

import net.ess3.api.IEssentials;
import org.bukkit.plugin.java.JavaPlugin;

public class BuyerPlugin extends JavaPlugin {
    private static IEssentials ess;

    public static IEssentials getEssentials() {
        return ess;
    }

    @Override
    public void onEnable() {
        this.getCommand("buyer").setExecutor(new BuyerCommand());
        
        getServer().getPluginManager().registerEvents(new BuyerMenu(), this);
        
        if (!setupEssentials()) {
            getLogger().severe("Essentials не найден! Плагин будет отключен!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        
        getLogger().info("Плагин успешно загружен!");
    }

    private boolean setupEssentials() {
        org.bukkit.plugin.Plugin plugin = getServer().getPluginManager().getPlugin("Essentials");
        if (plugin != null && plugin instanceof net.ess3.api.IEssentials) {
            ess = (net.ess3.api.IEssentials) plugin;
            return true;
        }
        return false;
    }
} 