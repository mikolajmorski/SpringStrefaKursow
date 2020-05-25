package com.morski.springstrefakursow;

import com.morski.springstrefakursow.domain.Castle;
import com.morski.springstrefakursow.domain.DragonKillingKnight;
import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {

        System.out.println(castle);


    }
}
