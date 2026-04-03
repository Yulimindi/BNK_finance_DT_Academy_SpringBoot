package com.example.secu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YlCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(YlCompanyApplication.class, args);
	}

}
