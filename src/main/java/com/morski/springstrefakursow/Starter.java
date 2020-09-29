package com.morski.springstrefakursow;


import com.morski.springstrefakursow.domain.PlayerInformation;
import com.morski.springstrefakursow.domain.repository.*;
import com.morski.springstrefakursow.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    DBKnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @java.lang.Override
    @Transactional
    public void run(java.lang.String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        //questService.assignRandomQuest("Lancelot");

        knightRepository.createKnight("Percival", 32);

        playerInformationRepository.createPlayerInformation(new PlayerInformation());

        questService.assignRandomQuest("Percival");

        //System.out.println(knightRepository);

    }
}
