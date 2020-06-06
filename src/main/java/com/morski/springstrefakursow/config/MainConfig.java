package com.morski.springstrefakursow.config;

import com.morski.springstrefakursow.domain.Castle;
import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.Quest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
//@PropertySource("classpath:castle.properties")
public class MainConfig {

    @Bean
    public Quest createQuest() {
        return new Quest();
    }

    @Bean("lancelot")
    @Primary
    public Knight knightLancelot() {
        Knight lancelot = new Knight("Lancelot", 30);
        lancelot.setQuest(createQuest());
        return lancelot;
    }

    @Bean("percival")
    public Knight knightPercival() {
        Knight percival = new Knight("Percival", 25);
        percival.setQuest(createQuest());
        return percival;
    }

    /*@Bean(name = "zamek", initMethod = "build", destroyMethod = "tearDown")
    public Castle castle() {
        Castle castle = new Castle(knight());
        castle.setName("East Watch");
        return castle;
    }*/

}
