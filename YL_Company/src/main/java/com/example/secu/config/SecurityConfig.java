package com.example.secu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	CustomLoginSuccessHandler ch;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers("/", "/login_page", "/login").permitAll()
				.requestMatchers("/createMember", "/regist_page", "/admin_page", "/member_detail").hasRole("ADMIN")
				.requestMatchers("/president_page").hasRole("PRESIDENT")
				.requestMatchers("/employee_page").hasRole("EMPLOYEE")
				.requestMatchers("/manager_page").hasRole("MANAGER")
				.requestMatchers("/personal_page", "/content_detail").hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE", "PRESIDENT")
				.requestMatchers("/update_content", "/create_content").hasAnyRole("MANAGER", "EMPLOYEE")
				.anyRequest().authenticated()
				);
		
		http.formLogin(login -> login
				.loginPage("/login_page")
				.loginProcessingUrl("/loginProc")
				.failureUrl("/login_page?error")
				.usernameParameter("mno")
				.passwordParameter("pw")
				.successHandler(ch)
				.permitAll()
				);
		
		http.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/?logout")
				);
		
		return http.build();
	}
}
