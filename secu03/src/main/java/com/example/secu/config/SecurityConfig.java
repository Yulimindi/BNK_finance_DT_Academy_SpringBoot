package com.example.secu.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.example.secu.auth.MemberDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final DataSource dataSource;
	private final MemberDetailsService memberDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf(auth -> auth.disable()); // 이걸 주석 치면 포스트 방식의 통신이 안됨 (csrf : 해킹 방어 차원에서 사용함)
		
		http.authorizeHttpRequests(auth -> auth
					.requestMatchers("/", "/login", "/regist", "/registProc").permitAll()
					.requestMatchers("/members/**").hasAnyRole("ADMIN", "MEMBER")
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()
				);
		
		http.formLogin(auth -> auth
				.loginPage("/login")
				.loginProcessingUrl("/loginProc")
				.defaultSuccessUrl("/success")
				.failureUrl("/login?error")
				.usernameParameter("username")
				.passwordParameter("password")
				);
		
		http.logout(auth -> auth
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				);
		
		http.rememberMe(auth -> auth
				.key("12345678")
				.tokenRepository(persistentTokenRepository())
				.userDetailsService(memberDetailsService)
				.tokenValiditySeconds(60 * 3) // 3분, 자동 로그인 해제, DB에서 삭제됨
				
				);
		
		return http.build();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
}
