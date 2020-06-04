package com.morski.springstrefakursow;


import com.morski.springstrefakursow.domain.Castle;
import com.morski.springstrefakursow.domain.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Autowired
    Tournament tournament;

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {

        System.out.println(castle);
        tournament.duel();
        System.out.println(tournament);

    }
}
