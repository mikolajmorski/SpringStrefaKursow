package com.morski.springstrefakursow.config;

import com.morski.springstrefakursow.domain.repository.DBKnightRepository;
import com.morski.springstrefakursow.domain.repository.InMemoryKnightRepository;
import com.morski.springstrefakursow.domain.repository.KnightRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MainConfig {

    /*@Bean(name="inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repository = new InMemoryKnightRepository();
        return repository;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        KnightRepository repository = new DBKnightRepository();
        return repository;
    }*/

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("user1").roles("USER")
                .and()
                .withUser("user2").password("user2").roles("ADMIN");
    }

}
