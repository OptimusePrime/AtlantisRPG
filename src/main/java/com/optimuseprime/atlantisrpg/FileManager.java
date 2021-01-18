package com.optimuseprime.atlantisrpg;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    private static final File jobsFile = new File(AtlantisRPG.getInstance().getDataFolder(), "jobs.yml");
    private static final FileConfiguration configuration = YamlConfiguration.loadConfiguration(jobsFile);


    public static FileConfiguration getJobsConfig() {
        return configuration;
    }

    public static void saveJobsConfig() {
        try {
            configuration.save(jobsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
