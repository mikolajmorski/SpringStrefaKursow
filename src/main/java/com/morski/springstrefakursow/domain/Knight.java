package com.morski.springstrefakursow.domain;

import java.util.Objects;

public class Knight {

    private String name ;

    private int age ;
    private Quest quest;

    public Knight() {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setQuest(Quest quest) {
        System.out.println("Wstawiam zadanie dla rycerza");
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + " (" + age + "). Zadanie: " + quest;
    }
}
