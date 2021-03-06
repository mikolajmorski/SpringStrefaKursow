package com.morski.springstrefakursow.domain;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;
    private String password;
    private boolean enabled;

    public  PlayerInformation() {

    }

    public  PlayerInformation(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.enabled = true;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    private int gold = 0;

}
