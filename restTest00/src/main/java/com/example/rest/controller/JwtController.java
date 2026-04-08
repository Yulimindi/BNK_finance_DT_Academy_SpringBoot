package com.example.rest.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.Member;
import com.example.rest.mapper.IMemberDao;
import com.example.rest.utils.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class JwtController {
	
	final IMemberDao dao;
	final JwtUtil jwt;
	final BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) {

		Member m = dao.selectId(username);
		if(m != null && passwordEncoder.matches(password, m.getPassword())) {
			String token = jwt.geterateToken(username, m.getRole(), m.getNickname());
			Cookie cookie = new Cookie("token", token);
			cookie.setPath("/"); //공부요망
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60 * 60); 
			
			response.addCookie(cookie);
			response.addHeader("Authorized", token);
			return ResponseEntity.ok(Map.of("username", username, "role", m.getRole(), "nickname", m.getNickname() , "token", token)) ;
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		            .body(Map.of("message", "아이디 또는 비밀번호가 틀렸습니다."));
		}
		
		
	}
	
	
	
}
