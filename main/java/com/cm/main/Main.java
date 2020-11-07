package com.cm.main;

import com.cm.commands.PartyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("p").setExecutor(new PartyCommand());
    }

    @Override
    public void onDisable() {

    }
}
