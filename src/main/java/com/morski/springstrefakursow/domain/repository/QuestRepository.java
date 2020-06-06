package com.morski.springstrefakursow.domain.repository;

import com.morski.springstrefakursow.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    Random rand = new Random();
    List<Quest> questList = new ArrayList<>();

    public void createQuest(String description) {
        questList.add(new Quest(description));
    }

    public List<Quest> getAll() {
        return questList;
    }

    public void deleteQuest(Quest quest) {
        questList.remove(quest);
    }

    @PostConstruct
    public void init() {

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
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
        System.out.println("Utworzylem zadanie o opisie: " + description);
        createQuest(description);
    }
}
