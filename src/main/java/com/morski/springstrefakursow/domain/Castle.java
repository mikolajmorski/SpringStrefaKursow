package com.morski.springstrefakursow.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@PropertySource("classpath:castle.properties")
public class Castle {

    @Value("${my.castle.name:East Watch}")
    private String name;

    @Autowired
    Knight knight;

    public Castle() {
    }

    @PostConstruct
    public void build() {
        System.out.println("Wybudowano zamek: " + name);
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("Zaraz wyburzumy zamek: " + name);
    }

    @Override
    public String toString() {
        return "Znajduje sie tu zamek o nazwie: " + this.name + ". Zamieszkały przez rycerza: " + knight;
    }
}
