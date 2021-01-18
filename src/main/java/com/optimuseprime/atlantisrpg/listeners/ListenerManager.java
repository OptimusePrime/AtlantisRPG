package com.optimuseprime.atlantisrpg.listeners;

import com.optimuseprime.atlantisrpg.AtlantisRPG;
import com.optimuseprime.atlantisrpg.listeners.playerlisteners.PlayerConnectionEvents;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {

    public static void registerEvents() {
        PluginManager pm = AtlantisRPG.getInstance().getServer().getPluginManager();

        pm.registerEvents(new PlayerConnectionEvents(), AtlantisRPG.getInstance());

    }
}
