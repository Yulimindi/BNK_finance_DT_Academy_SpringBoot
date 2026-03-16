package com.example.SimpleBbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SimpleBbs.domain.Member;
import com.example.SimpleBbs.service.LoginService;
import com.example.SimpleBbs.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/member/main")
	public String main() {
		return "/member/main";
	}
	
	@Autowired
	LoginService service;
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {
		System.out.println(id + ", " + pw);
		if(service.login(id, pw) == 1) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			System.out.println(session.getAttribute("id"));
			session.setAttribute("isLogin", true);
			return "redirect:/member/main";
		} else {
			return "redirect:/loginForm";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.setAttribute("isLogin", false);
		return "redirect:/";
	}
}
