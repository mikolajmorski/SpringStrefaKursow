package com.morski.springstrefakursow.services;


import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.PlayerInformation;
import com.morski.springstrefakursow.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;


    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return  knightRepository.getKnight(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void update(Knight knight) {
        knightRepository.update(knight.getId(), knight);
    }

    public int collectRewards() {
        int sum = knightRepository.getAllKnights().stream().filter(knight -> knight.getQuest().isCompleted())
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(knight -> knight.getQuest().isCompleted())
                .forEach(knight -> {
                    knight.setQuest(null);
                });
        return sum;
    }
}
