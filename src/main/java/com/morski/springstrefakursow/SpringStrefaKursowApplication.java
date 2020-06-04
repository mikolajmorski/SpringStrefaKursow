package com.morski.springstrefakursow;


import com.morski.springstrefakursow.domain.Castle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class SpringStrefaKursowApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringStrefaKursowApplication.class, args);
	}

}
