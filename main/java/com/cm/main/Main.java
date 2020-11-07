package com.cm.main;

import com.cm.commands.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("heal").setExecutor(new HealCommand());
    }

    @Override
    public void onDisable() {
        
    }
}
