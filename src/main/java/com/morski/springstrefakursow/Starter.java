package com.morski.springstrefakursow;


import com.morski.springstrefakursow.domain.PlayerInformation;
import com.morski.springstrefakursow.domain.repository.*;
import com.morski.springstrefakursow.services.QuestService;
import com.morski.springstrefakursow.utils.Role;
import com.morski.springstrefakursow.utils.RoleRepository;
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

    @Autowired
    RoleRepository roleRepository;

    @java.lang.Override
    @Transactional
    public void run(java.lang.String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        //questService.assignRandomQuest("Lancelot");

        knightRepository.createKnight("Percival", 32);

        PlayerInformation playerInformation1 = new PlayerInformation("user1", "user1");
        playerInformationRepository.createPlayerInformation(playerInformation1);
        PlayerInformation playerInformation2 = new PlayerInformation("user2", "user2");
        playerInformationRepository.createPlayerInformation(playerInformation2);

        Role user1RoleUSER = new Role("user1", "USER");
        Role user2RoleUSER = new Role("user2", "USER");
        Role user2RoleADMIN = new Role("user2", "ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);
        questService.assignRandomQuest("Percival");

        //System.out.println(knightRepository);

    }
}
