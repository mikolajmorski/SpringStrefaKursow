package com.morski.springstrefakursow.services;

import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.Quest;
import com.morski.springstrefakursow.domain.repository.KnightRepository;
import com.morski.springstrefakursow.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest (String knightName) {
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
        questRepository.deleteQuest(randomQuest);
    }


}
