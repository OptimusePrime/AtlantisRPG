package com.optimuseprime.atlantisrpg.players;

import com.optimuseprime.atlantisrpg.jobs.Job;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class RPGPlayer {

    private String name;
    private UUID uuid;
    private String nickname;
    private Job job;
    private List<String> unlockedSkills;
    private List<String> solvedQuests;
    private List<String> unlockedCharms;
    private Player player;

    public RPGPlayer(String name, UUID uuid, String nickname, Job job, List<String> unlockedSkills, List<String> solvedQuests, List<String> unlockedCharms) {

        setName(name);
        setNickname(nickname);
        setUuid(uuid);
        setJob(job);
        setSolvedQuests(solvedQuests);
        setUnlockedSkills(unlockedSkills);
        setSolvedQuests(solvedQuests);
        setUnlockedCharms(unlockedCharms);
        setPlayer(Bukkit.getPlayer(uuid));
    }

    public RPGPlayer() {

    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getUnlockedSkills() {
        return unlockedSkills;
    }

    public void setUnlockedSkills(List<String> unlockedSkills) {
        this.unlockedSkills = unlockedSkills;
    }

    public List<String> getSolvedQuests() {
        return solvedQuests;
    }

    public void setSolvedQuests(List<String> solvedQuests) {
        this.solvedQuests = solvedQuests;
    }

    public List<String> getUnlockedCharms() {
        return unlockedCharms;
    }

    public void setUnlockedCharms(List<String> unlockedCharms) {
        this.unlockedCharms = unlockedCharms;
    }
}
