package com.morski.springstrefakursow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:knightRepository.properties")
public class SpringStrefaKursowApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringStrefaKursowApplication.class, args);
	}

}
