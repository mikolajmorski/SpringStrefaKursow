package com.morski.springstrefakursow;


import com.morski.springstrefakursow.domain.repository.KnightRepository;
import com.morski.springstrefakursow.domain.repository.QuestRepository;
import com.morski.springstrefakursow.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {

        questRepository.createRandomQuest();
         questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        questService.assignRandomQuest("Lancelot");
        questService.assignRandomQuest("Percival");

        System.out.println(knightRepository);

    }
}
