package com.optimuseprime.atlantisrpg.jobs;

import com.optimuseprime.atlantisrpg.FileManager;
import com.optimuseprime.atlantisrpg.players.PlayerManager;
import com.optimuseprime.atlantisrpg.players.RPGPlayer;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class JobManager {

    private static List<Job> loadedJobs;

    public static void getJob(String job, RPGPlayer p) {
        if(p.getJob() != null) {
            JobManager.getJobByName(p.getJob().getName()).getEmployees().remove(p.getUuid());
        }
        p.setJob(JobManager.getJobByName(job));
        PlayerManager.savePlayer(p);
    }

    public static Job getJobByName(String job) {
        for(Job job1  : loadedJobs) {
            if(job1.getName().equalsIgnoreCase(job)) {
                return job1;
            }
        }
        return null;
    }

    public static void loadJobs() {
        JobManager.setLoadedJobs(new ArrayList<>());

        for(String key : FileManager.getJobsConfig().getConfigurationSection("jobs").getKeys(false)) {
            Job job = new Job(FileManager.getJobsConfig().getString("jobs." + key + ".name"),
                    FileManager.getJobsConfig().getString("jobs." + key + ".maxLevelPay"));
            for(String level : FileManager.getJobsConfig().getConfigurationSection("jobs." + key + ".levels").getKeys(false)) {
                //TODO: Implement job levels
            }
            JobManager.getLoadedJobs().add(job);
        }
    }

    public static void removePlayer(RPGPlayer p) {
        p.setJob(null);
        PlayerManager.savePlayer(p);
    }



    public static List<Job> getLoadedJobs() {
        return loadedJobs;
    }

    public static void setLoadedJobs(List<Job> loadedJobs) {
        JobManager.loadedJobs = loadedJobs;
    }
}
