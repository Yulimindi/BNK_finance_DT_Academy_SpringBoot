package com.example.validation1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.upload.path}")
	private String uploadPath;
	
	@Value("${file.upload.url}")
	private String uploadUrl;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(uploadUrl + "**") // file.upload.path=C:/upload/
				.addResourceLocations("file:///" + uploadPath); // file.upload.url=/upload/
	}
}
