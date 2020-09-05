package com.morski.springstrefakursow.domain.repository;

import com.morski.springstrefakursow.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public KnightRepository() {
    }

    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knights.put(newKnight.getId(), newKnight);
    }

    private int getNewId() {
        if(knights.isEmpty()) {
            return 0;
        }
        else {
            Integer max = knights.keySet().stream().max(Integer::max).get();
            return max+1;
        }
    }

    public Knight getKnight(Integer id) {
        return knights.get(id);
    }

    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    public Optional<Knight> getKnight(String name) {
        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();
        return knightByName;
    }

    public void deleteKnight(Integer id) {
        knights.remove(id);
    }

    public void setKnights(Map<Integer, Knight> knights) {
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

    public void createKnight(Knight knight) {
        knights.put(getNewId(), knight);
    }


}
