package com.example.rest.jwt;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
public class JwtAuthFilter extends OncePerRequestFilter { // 요청당 1번만 수행되게 하는 필터

	private final JwtUtil jwtUtil;
	
	public JwtAuthFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		// /api/** 경로만 토큰 검사
		if(!uri.startsWith("/api/")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		// Authorization 헤더에서 토큰 추출
		String header = request.getHeader("Authorization");
		if(header == null || !header.startsWith("Bearer ")) {
			sendError(response, "토큰이 없당께...");
			return;
		}
		
		String token = header.substring(7);
		if(!jwtUtil.isValid(token)) {
			sendError(response, "토큰이 만료되었거나 유효하지 않아용");
			return;
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	private void sendError(HttpServletResponse response, String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write("{\"message\": \"" + message + "\"}");
	}

}
