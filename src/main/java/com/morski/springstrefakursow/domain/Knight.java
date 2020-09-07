package com.morski.springstrefakursow.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Knight {

    private int id;

    public Quest getQuest() {
        return quest;
    }

    @NotNull
    @Size(min=2, max = 40)
    private String name ;

    @NotNull
    @Range(min=18, max=60)
    private int age ;


    private int level;

    private Quest quest;

    public Knight() {
    }

    public Knight( String name, int age) {
        this.age = age;
        this.name = name;
        this.level = 1;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setQuest(Quest quest) {
        quest.setStarted(true);
        this.quest = quest;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + " (" + age + "). Zadanie: " + quest;
    }
}
