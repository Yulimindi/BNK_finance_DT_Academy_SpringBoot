package com.example.Thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Jpaex2Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpaex2Application.class, args);
	}

}
