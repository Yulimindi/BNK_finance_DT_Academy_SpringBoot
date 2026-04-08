package com.example.rest.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.rest.controller.JwtController;
import com.example.rest.utils.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;
	
	public AuthFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		if(!uri.startsWith("/api/")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = request.getHeader("Authorization");
		
		if(token == null || !token.startsWith("Bearer ")) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie c : cookies) {
					if("token".equals(c.getName())) {
						token = c.getValue();
						break;
					}
				}
				if (token == null) {
				    sendError(response, "토큰이 없어용 ㅠㅠ");
				    return;
				}
			} else {
				sendError(response, "토큰이 없어용 ㅠㅠ");
				return;
			}
		}
		
		if(!jwtUtil.isValid(token)) {
			response.sendRedirect("/?msg=notoken");
			return;
		}
		
		if(jwtUtil.isValid(token)) {
	        String username = jwtUtil.getUsername(token);
	        String role = jwtUtil.getRole(token);
	       
	        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
	        UsernamePasswordAuthenticationToken authentication = 
	            new UsernamePasswordAuthenticationToken(username, null, authorities);
	        
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    }
		
		filterChain.doFilter(request, response);
	}
	
	private void sendError(HttpServletResponse response, String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write("{\"message\": \"" + message + "\"}");
	}

}
