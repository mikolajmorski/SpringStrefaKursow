package com.morski.springstrefakursow.domain.repository;

import com.morski.springstrefakursow.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public KnightRepository() {
    }

    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    public Knight getKnight(String name) {
        return knights.get(name);
    }

    public void deleteKnight(String name) {
        knights.remove(name);
    }

    public void setKnights(Map<String, Knight> knights) {
        this.knights = knights;
    }

    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }

}
