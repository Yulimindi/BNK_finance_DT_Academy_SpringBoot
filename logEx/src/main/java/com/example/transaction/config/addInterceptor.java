package com.example.transaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.transaction.interceptor.CheckInterceptor;

@Configuration
public class addInterceptor implements WebMvcConfigurer {
	@Autowired
	private CheckInterceptor inter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(inter)
		.addPathPatterns("/**")
		.excludePathPatterns("/");
	}
	
	
}
