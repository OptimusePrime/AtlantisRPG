package com.optimuseprime.atlantisrpg.players;

import com.optimuseprime.atlantisrpg.AtlantisRPG;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerManager {

    private static List<RPGPlayer> players;

    public static List<RPGPlayer> getPlayers() {
        return players;
    }

    public static void setPlayers(List<RPGPlayer> players) {
        PlayerManager.players = players;
    }

    public static void loadPlayer(Player p) throws IOException {
        File playerFile = new File(AtlantisRPG.getInstance().getDataFolder(), "players/" + p.getUniqueId().toString() + ".yml");
        RPGPlayer rpgPlayer = new RPGPlayer();
        FileConfiguration configuration = null;

        if(!playerFile.createNewFile()) {
            configuration = YamlConfiguration.loadConfiguration(playerFile);

            configuration.createSection("name");
            configuration.createSection("nickname");
            configuration.createSection("uuid");
            configuration.createSection("job");
            configuration.createSection("skills.unlockedSkills");
            configuration.createSection("quests.solvedQuests");
            configuration.createSection("magic.unlockedCharms");
            configuration.save(playerFile);

            rpgPlayer.setName(p.getName());
            rpgPlayer.setNickname(p.getName());
            rpgPlayer.setUuid(p.getUniqueId());
            rpgPlayer.setJob(null);
            rpgPlayer.setUnlockedCharms(new ArrayList<>());
            rpgPlayer.setUnlockedSkills(new ArrayList<>());
            rpgPlayer.setSolvedQuests(new ArrayList<>());
            savePlayer(getRPGPlayerByBukkitPlayer(p));
        }

        configuration = YamlConfiguration.loadConfiguration(playerFile);

        rpgPlayer.setName(p.getName());
        rpgPlayer.setNickname(configuration.getString("nickname"));
        rpgPlayer.setUuid(p.getUniqueId());
        rpgPlayer.setUnlockedCharms(configuration.getStringList("magic.unlockedCharms"));
        rpgPlayer.setUnlockedSkills(configuration.getStringList("skills.unlockedSkills"));
        rpgPlayer.setSolvedQuests(configuration.getStringList("quests.solvedQuests"));
        getPlayers().add(rpgPlayer);
    }

    public static void savePlayer(RPGPlayer p) {
        File playerFile = new File(AtlantisRPG.getInstance().getDataFolder(), "players/" + p.getUuid().toString() + ".yml");
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(playerFile);

        configuration.set("name", p.getName());
        configuration.set("nickname", p.getNickname());
        configuration.set("uuid", p.getUuid().toString());
        configuration.set("job", p.getJob().getName());
        configuration.set("skills.unlockedSkills", p.getUnlockedSkills());
        configuration.set("quests.solvedQuests", p.getSolvedQuests());
        configuration.set("magic.unlockedCharms", p.getUnlockedCharms());
        try {
            configuration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unloadPlayer(RPGPlayer p) {
        savePlayer(p);
        getPlayers().remove(p);
    }

    public static RPGPlayer getRPGPlayerByName(String name) {
        for(RPGPlayer player : getPlayers()) {
            if(player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public static RPGPlayer getRPGPlayerByUUID(UUID uuid) {
        for(RPGPlayer player : getPlayers()) {
            if(player.getUuid().equals(uuid)) {
                return player;
            }
        }
        return null;
    }

    public static RPGPlayer getRPGPlayerByBukkitPlayer(Player p) {
        for(RPGPlayer player : getPlayers()) {
            if(player.getUuid().equals(p.getUniqueId())) {
                return player;
            }
        }
        return null;
    }

}
