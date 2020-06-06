package com.morski.springstrefakursow.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
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
