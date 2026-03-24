package com.example.Thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MymemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymemoApplication.class, args);
	}

}
