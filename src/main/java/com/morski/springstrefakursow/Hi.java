package com.morski.springstrefakursow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Hi implements CommandLineRunner {
    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {
        System.out.println("Hello world");
    }
}
