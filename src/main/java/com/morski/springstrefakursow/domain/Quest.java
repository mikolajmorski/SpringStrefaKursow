package com.morski.springstrefakursow.domain;


import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class Quest {

    private int id;
    private String decription;
    private int reward = 100;
    protected int lenghtInSeconds =  3;
    protected LocalDateTime startDate;

    private boolean started = false;
    private boolean completed = false;

    public Quest(int id, String decription) {
        this.id = id;
        this.decription = decription;
    }

    @Override
    public String toString() {
        return decription;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenght() {
        return lenghtInSeconds;
    }

    public void setLenght(int lenght) {
        this.lenghtInSeconds = lenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if(started) {
            this.startDate =  LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {
        if(this.completed) {
            return this.completed;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);
        boolean isAfter = now.isAfter(questEndDate);
        if(isAfter) {
            this.completed = true;
        }
        return isAfter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
