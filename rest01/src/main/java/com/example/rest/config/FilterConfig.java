package com.example.rest.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest.jwt.JwtAuthFilter;

// @Configuration
public class FilterConfig {
	private final JwtAuthFilter jwtAuthFilter;
	
	public FilterConfig(JwtAuthFilter jwtAuthFilter) {
		this.jwtAuthFilter = jwtAuthFilter;
	}
	
	@Bean
	public FilterRegistrationBean<JwtAuthFilter> jwtFilter() {
		
		FilterRegistrationBean<JwtAuthFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(jwtAuthFilter);
		bean.addUrlPatterns("/api/*");
		bean.setOrder(1);
		return bean;
		
	}
}
