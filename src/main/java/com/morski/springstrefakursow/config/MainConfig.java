package com.morski.springstrefakursow.config;

import com.morski.springstrefakursow.domain.Castle;
import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.Quest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
@PropertySource("classpath:castle.properties")
public class MainConfig {

    @Bean
    public Quest createQuest() {
        return new Quest();
    }

    @Bean
    public Knight knight() {
        Knight knight = new Knight("Lancelot", 30);
        knight.setQuest(createQuest());
        return knight;
    }

    @Bean(name = "zamek", initMethod = "build", destroyMethod = "tearDown")
    public Castle castle() {
        Castle castle = new Castle(knight());
        castle.setName("East Watch");
        return castle;
    }

}
