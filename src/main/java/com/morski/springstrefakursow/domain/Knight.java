package com.morski.springstrefakursow.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Knight {

    private String name ;

    private int age ;
    private Quest quest;

    public Knight() {
        this.name = "Lancelot";
        this.age = 30;

    }

    public Knight( String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Autowired
    public void setQuest(Quest quest) {
        System.out.println("Wstawiam zadanie dla rycerza");
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + " (" + age + "). Zadanie: " + quest;
    }
}
