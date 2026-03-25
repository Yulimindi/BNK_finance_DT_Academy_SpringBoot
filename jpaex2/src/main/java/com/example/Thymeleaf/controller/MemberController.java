package com.example.Thymeleaf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Thymeleaf.dto.Member;
import com.example.Thymeleaf.entity.MemberEntity;
import com.example.Thymeleaf.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository mr;
	
	
	@PostMapping("/regist")
	public String regist(Member m) {
		MemberEntity save = mr.save(m.memberToEntity());
		if(save == null) return "redirect:/regForm";
		return "success";
	}
	
	@PostMapping("/login")
	public String login(Member m, HttpSession session) {
//		if(mr.existsById(m.getUsername())) {
//			Optional<MemberEntity> op = mr.findById(m.getUsername());
//			if(op.get().getPw().equals(m.getPw())) {
//				return "success";
//			} else {
//				return "redirect:/loginForm";
//			}
//		} else {
//			return "redirect:/loginForm";
//		}
		
		MemberEntity member = mr.findByUsernameAndPw(m.getUsername(), m.getPw());
		System.out.println("login : " + member);
		if(member == null) {
			return "redirect:/loginForm?fail=1";
		}
		session.setAttribute("username", member.getUsername());
		
		String redirectURL = (String) session.getAttribute("redirectURL");
		System.out.println("로그인 후 원래 가려던" + redirectURL);
		if(redirectURL != null || redirectURL.isBlank()) {
			return "redirect:" + redirectURL;
		}
		
		return "success";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/";
	}
	
	
}
