package com.morski.springstrefakursow.services;

import com.morski.springstrefakursow.domain.Quest;
import com.morski.springstrefakursow.domain.repository.DBKnightRepository;
import com.morski.springstrefakursow.domain.repository.InMemoryKnightRepository;
import com.morski.springstrefakursow.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    InMemoryKnightRepository inMemoryKnightRepository;

    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest (String knightName) {
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        inMemoryKnightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }


    public List<Quest> getAllNotStartedQuests() {
        return questRepository.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public void update(Quest quest) {
        questRepository.update(quest);
    }

    public void isQuestCompleted(Quest quest) {
        quest.isCompleted();
    }
}
