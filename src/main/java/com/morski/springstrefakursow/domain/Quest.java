package com.morski.springstrefakursow.domain;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Quest {

    private String decription;
    private int reward = 100;
    private int lenght =  30000;

    private boolean started = false;
    private boolean completed = false;

    public Quest(String decription) {
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
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean ended) {
        this.completed = ended;
    }
}
