package com.example.secu00.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth // 허용 할것인지에 대한 설정을 여기서 함
				.requestMatchers("/", "/welcome_guest").permitAll()
				.anyRequest().authenticated()
				);
		return http.build();
	}
}
