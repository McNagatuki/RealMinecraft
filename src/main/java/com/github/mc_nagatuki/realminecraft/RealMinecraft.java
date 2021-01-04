package com.github.mc_nagatuki.realminecraft;

import org.bukkit.plugin.java.JavaPlugin;

public final class RealMinecraft extends JavaPlugin {
    public static RealMinecraft plugin;

    private MineManager mm;
    private MineConfiguration config;

    @Override
    public void onEnable() {
        this.plugin = this;

        this.mm = new MineManager();
        this.config = new MineConfiguration();

        // events
        this.getServer().getPluginManager().registerEvents(new PlayerMovementListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerClickListener(), this);

        // commands
        this.getCommand("real").setExecutor(new CommandManager(this));
    }

    public MineManager getMineManager() {
        return this.mm;
    }

    public MineConfiguration getMineConfig() {
        return this.config;
    }
}
