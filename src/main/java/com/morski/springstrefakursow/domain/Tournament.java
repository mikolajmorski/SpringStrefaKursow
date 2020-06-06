package com.morski.springstrefakursow.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Tournament {

    @Autowired
    List<Knight> knights;

    public Tournament(){
    }

    public void duel() {
        //knight.setAge(knight.getAge() + 1);
    }

    public void setKnight(List<Knight> knights) {
        this.knights = knights;
    }

    @Override
    public String toString() {
        return "W turnieju bierze udzial rycerze: " + knights.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
