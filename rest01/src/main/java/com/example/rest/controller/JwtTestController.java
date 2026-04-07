package com.example.rest.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.LoginRequest;
import com.example.rest.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/jwt-test")
@RequiredArgsConstructor
public class JwtTestController {
	
	private final JwtUtil jwtUtil;
	
	@GetMapping("/generate")
	public Map<String, String> generate(@RequestParam(name = "username", defaultValue = "user1") String username, @RequestParam(name = "role", defaultValue = "GUEST") String role, HttpServletResponse response) {
		log.info("Generate");
		String token = jwtUtil.generateToken(username, role);
		
		// 응답 헤더 또는 요청 헤더에는 jwt임을 명시하기 위해 토큰 앞에 Bearer를 붙이고 그걸 달고 가는게 Authorization으로 정해져 있음
		// Bearer 뒤부터 토큰이라는 것을 알리기 위해 반드시 Bearer 뒤에 띄어쓰기 해야함!
		// addHeader도 있음 (얘는 추가되는거. 덮어씌워지는게 아님)
		response.setHeader("Authorization", "Bearer " + token);
		
		log.info("Authorization 헤더 설정 확인 : {}", response.getHeader("Authorization"));
		
		return Map.of("username", username, "role", role, "token", token);
	}
	
	// loginRequest라는 객체를 만들어서 요청을 처리하라
	
	@PostMapping("/login")
	public Map<String, String> login(LoginRequest lr, HttpServletResponse response) {
		System.out.println(lr.toString());
		String token = jwtUtil.generateToken(lr.getUsername(), lr.getRole());
		response.setHeader("Authorization", "Bearer " + token);
		lr.setToken(token);
		return Map.of("username", lr.getUsername(), "role", lr.getRole(), "token", token);
	}
	
	@GetMapping("/protected")
	public String protect(HttpServletRequest request) {
		System.out.println(request.getHeader("Authorization"));
		String token = request.getHeader("Authorization").substring(7).trim();
		if(jwtUtil.isValid(token)) {
			return jwtUtil.getUsername(token);
		} else {
			return "잘안됐으용";
		}
		
		
	}
}
