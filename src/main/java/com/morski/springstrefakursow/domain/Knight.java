package com.morski.springstrefakursow.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Knight {


    private String name = "Lancelot";

    private int age = 30;
    //private Quest quest;

    /*public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }*/

/*
    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        this.quest = quest;
    }
*/

/*
    public void setQuest(Quest quest) {
        this.quest = quest;
    }
*/
    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + " (" + age + ")." /*Zadanie: " + quest*/;
    }
}
