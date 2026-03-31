package com.example.secu.config;

import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // 이 반환값을 빈으로 등록
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // 스태틱 폴더 안에 있는 것들은 모두 허용하겠다
					.requestMatchers("/", "/login", "/regist", "/registProc").permitAll()
					.requestMatchers("/members/**").hasAnyRole("MEMBER", "ADMIN")
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated())
					.formLogin(Customizer.withDefaults())
					.logout(Customizer.withDefaults());
		http.csrf(AbstractHttpConfigurer::disable);
					
		
		return http.build();
	}
}
