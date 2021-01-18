package com.optimuseprime.atlantisrpg.jobs;

import com.optimuseprime.atlantisrpg.players.RPGPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Job {

    private String name;
    private String maxLevelPay;
    private List<JobLevel> levels;
    private List<UUID> employees;

    public Job(String name, String maxLevelPay) {
        setLevels(new ArrayList<>());
        setName(name);
        setMaxLevelPay(maxLevelPay);
        setEmployees(new ArrayList<>());
    }

    public Job() {

    }

    public List<UUID> getEmployees() {
        return employees;
    }

    public void setEmployees(List<UUID> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaxLevelPay() {
        return maxLevelPay;
    }

    public void setMaxLevelPay(String maxLevelPay) {
        this.maxLevelPay = maxLevelPay;
    }

    public List<JobLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<JobLevel> levels) {
        this.levels = levels;
    }
}
