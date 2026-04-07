package com.example.rest.jwt;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private final JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = header.substring(7);
		
		if(!jwtUtil.isValid(token)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String username = jwtUtil.getUsername(token);
		String role = jwtUtil.getRole(token);
		
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
		
		// userDetails 안 만들고 약식으로 이렇게 했대용 그래서 정작 중요한 패스워드가 없어용
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		filterChain.doFilter(request, response);
		
		
	}
	
}
