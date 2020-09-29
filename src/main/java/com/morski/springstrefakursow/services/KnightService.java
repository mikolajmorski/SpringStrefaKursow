package com.morski.springstrefakursow.services;


import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.PlayerInformation;
import com.morski.springstrefakursow.domain.repository.InMemoryKnightRepository;
import com.morski.springstrefakursow.domain.repository.PlayerInformationRepository;
import com.morski.springstrefakursow.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {

    @Autowired
    InMemoryKnightRepository inMemoryKnightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    PlayerInformationRepository playerInformationRepository;


    public List<Knight> getAllKnights() {
        return new ArrayList<>(inMemoryKnightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        inMemoryKnightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return  inMemoryKnightRepository.getKnight(id);
    }

    public void deleteKnight(Integer id) {
        inMemoryKnightRepository.deleteKnight(id);
    }

    public void update(Knight knight) {
        inMemoryKnightRepository.update(knight.getId(), knight);
    }

    public int collectRewards() {
        int sum = inMemoryKnightRepository.getAllKnights().stream().filter(knightPredicate())
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        inMemoryKnightRepository.getAllKnights().stream().filter(knightPredicate())
                .forEach(knight -> {
                    knight.setQuest(null);
                });
        return sum;
    }

    private Predicate<Knight> knightPredicate() {
        return knight -> {
            if (knight.getQuest() != null)
                return knight.getQuest().isCompleted();
            return false;
        };
    }

    @Transactional
    public void getMyGold() {

        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
            if(knight.getQuest() != null) {
                boolean completed = knight.getQuest().isCompleted();
                if(completed) {
                    questRepository.update(knight.getQuest());
                }
            }
        });
        PlayerInformation firts = playerInformationRepository.getFirts();
        int currentGold = firts.getGold();
        firts.setGold(currentGold + collectRewards());

    }
}
