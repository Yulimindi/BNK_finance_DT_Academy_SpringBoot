package com.example.secu.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		var authorities = authentication.getAuthorities();
		
		String redirectUrl = null;
		
		for(var auth : authorities) {
			if(auth.getAuthority().equals("ROLE_ADMIN")) {
				redirectUrl = "/admin_page";
				break;
			} else if(auth.getAuthority().equals("ROLE_MANAGER")) {
				redirectUrl = "/manager_page";
				break;
			} else if(auth.getAuthority().equals("ROLE_EMPLOYEE")) {
				redirectUrl = "/employee_page";
				break;
			} else {
				redirectUrl = "/president_page";
				break;
			}
		}
		
		response.sendRedirect(redirectUrl);
	}
}
