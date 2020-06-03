package com.morski.springstrefakursow.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Castle {

    private String name;


    Knight knight;

    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.knight = knight;
        this.name = name;
    }


    public void build() {
        System.out.println("Wybudowano zamek: " + name);
    }


    public void tearDown() {
        System.out.println("Zaraz wyburzumy zamek: " + name);
    }

    @Override
    public String toString() {
        return "Znajduje sie tu zamek o nazwie: " + this.name + ". Zamieszkały przez rycerza: " + knight;
    }

    public void setName(String name) {
        this.name = name;
    }
}
