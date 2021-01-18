package com.optimuseprime.atlantisrpg.listeners.playerlisteners;

import com.optimuseprime.atlantisrpg.players.PlayerManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;

public class PlayerConnectionEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        try {
            PlayerManager.loadPlayer(e.getPlayer());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        PlayerManager.unloadPlayer(PlayerManager.getRPGPlayerByBukkitPlayer(e.getPlayer()));
    }


}
