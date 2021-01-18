package com.optimuseprime.atlantisrpg;

import com.optimuseprime.atlantisrpg.listeners.ListenerManager;
import com.optimuseprime.atlantisrpg.players.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class AtlantisRPG extends JavaPlugin {

    private static AtlantisRPG instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        load();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AtlantisRPG getInstance() {
        return instance;
    }

    private void load() {
        File f = new File(getInstance().getDataFolder(), "players");
        if(!f.exists()) {
            f.mkdir();
        }
        PlayerManager.setPlayers(new ArrayList<>());
        ListenerManager.registerEvents();

    }

}
