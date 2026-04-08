package com.example.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.rest.filter.AuthFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
	
private final AuthFilter af;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 세션 사용 안함 (JWT는 STATELESS)
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// CSRF 비활성 - REST API는 불필요
		http.csrf(csrf -> csrf.disable());
		
		// 기본 폼 로그인 비활성
		http.formLogin(form -> form.disable());
		http.httpBasic(AbstractHttpConfigurer::disable); // basic -> basic.disable()와 같은 것!
		
		http.authorizeHttpRequests(auth -> auth
					.requestMatchers("/", "/login", "/regist").permitAll()
					.requestMatchers("/api/member/**").hasRole("MEMBER")
					.requestMatchers("/api/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				);
		
		// JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 앞에 삽입
		http.addFilterBefore(af, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
