package com.westosia.magic;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new ClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);

    }
}
