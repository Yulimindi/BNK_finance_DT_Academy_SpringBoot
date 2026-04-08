package com.example.rest.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rest.dto.Member;
import com.example.rest.mapper.IMemberDao;
import com.example.rest.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@Controller
@RequiredArgsConstructor
public class NormalController {
	
	final IMemberDao dao;
	final JwtUtil jwt;
	final BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String index(Model m, @RequestParam(required = false, value="msg") String notoken) {
		if(notoken != null) {
			m.addAttribute("notoken", notoken);
		}
		return "index";
	}

	@GetMapping("/api/member/goMember")
	public String goMember(@CookieValue(name = "token", required = false) String token, Model m) {
		String nickname = jwt.getNickname(token);
		m.addAttribute("name", nickname);
		return "memberpage";
	}
	
	@GetMapping("/api/admin/goAdmin")
	public String goAdmin (@CookieValue(name = "token", required = false) String token, Model m) {
		String nickname = jwt.getNickname(token);
		m.addAttribute("name", nickname);
		return "adminpage";
	}
	
	@PostMapping("/regist")
	public String regist(Member m) {
		m.setPassword(passwordEncoder.encode(m.getPassword()));
		m.setRole("ROLE_" + m.getRole());
		dao.regist(m.getUsername(), m.getPassword(), m.getNickname(), m.getRole());
		return "redirect:/";
	}
}
