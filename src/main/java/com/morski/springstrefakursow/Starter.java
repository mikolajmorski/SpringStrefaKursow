package com.morski.springstrefakursow;

import com.morski.springstrefakursow.domain.DragonKillingKnight;
import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.Quest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {
        Knight lancelot = new Knight("Lancelot", 35, new Quest("Uratuj ksiezniczke"));
        System.out.println(lancelot);

        Knight percival = new Knight("Percival", 30);
        System.out.println(percival);
        percival.setQuest(new Quest("Zabij smoka"));
        System.out.println(percival);

    }
}
