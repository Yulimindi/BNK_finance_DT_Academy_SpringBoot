package com.example.rest.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@GetMapping("/hello")
	public ResponseEntity<Map<String, String>> hello(Authentication authentication) {
		String username = authentication.getName();
		return ResponseEntity.ok(Map.of("message", "안녀어어어엉 멤버 " + username + "님!"));
	}
	
	@GetMapping("api/mypage")
	public ResponseEntity<Map<String, String>> mypage(Authentication authentication) {
		String username = authentication.getName();
		return ResponseEntity.ok(Map.of("message", "오케이이이잉 " + username + "(이)의 마이페이지양"));
	}
}
