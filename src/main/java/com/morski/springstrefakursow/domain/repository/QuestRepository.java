package com.morski.springstrefakursow.domain.repository;

import com.morski.springstrefakursow.domain.Quest;
import com.morski.springstrefakursow.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {

    Random rand = new Random();

    Map<Integer, Quest> quests = new HashMap<>();

    public void createQuest(String description) {
        int newId = Ids.generateNewId(quests.keySet());
        Quest quest = new Quest(newId, description);
        quests.put(newId, quest);
    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

    @PostConstruct
    public void init() {

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }


    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj ksiezniczke");
        descriptions.add("Wez udzial w turnieju");
        descriptions.add("Zabij smoka");
        descriptions.add("Zabij bande goblinow");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        //System.out.println("Utworzylem zadanie o opisie: " + description);
        createQuest(description);
    }

    public void update(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }
}
