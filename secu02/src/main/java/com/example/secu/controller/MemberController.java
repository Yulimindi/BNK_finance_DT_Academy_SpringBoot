package com.example.secu.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.secu.auth.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/members")
public class MemberController {
	
	@GetMapping("/welcome")
	public String welcome(Model m, Principal principal, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
		log.info("환영해용");
		// SecurityContextHolder 여기가 시큐리티가 사용하는 세션
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		m.addAttribute("username", userDetails.getUsername());
		m.addAttribute("name", userDetails.getName());
		m.addAttribute("role", userDetails.getRole());
		
		// Principal 객체 주입
		m.addAttribute("username2", principal.getName());
		m.addAttribute("principal", principal.toString());
		
		// @AuthenticationPrincipal 사용
		m.addAttribute("username3", customUserDetails.getUsername());
		m.addAttribute("name3", customUserDetails.getName());
		m.addAttribute("role3", customUserDetails.getRole());
		
		return "members/welcome";
	}
}
