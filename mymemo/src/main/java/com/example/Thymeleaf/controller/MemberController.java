package com.example.Thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Thymeleaf.dto.GetMember;
import com.example.Thymeleaf.dto.Member;
import com.example.Thymeleaf.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	// 아이디 중복 체크
	@PostMapping("/checkId")
	public @ResponseBody String checkId(@RequestParam("username") String username) {
		if(ms.checkId(username)) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@PostMapping("/doLogin")
	public String doLogin(Member m, HttpSession session) {
		if(ms.doLogin(m)) {
			session.setAttribute("username", m.getUsername());
			session.setAttribute("nickname", m.getNickname());
			return "redirect:/board";
		}
		return "redirect:/?result=fail";
	}
	
	@PostMapping("/doSignup")
	public String doSignup(Member m) {
		ms.doSignup(m);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("nickname");
		return "redirect:/";
	}
	
	@GetMapping("/getUser")
	public @ResponseBody GetMember getUser(@RequestParam("nickname") String nickname) {
		GetMember m = ms.getUser(nickname);
		if(m.getNickname().equals(nickname)) {
			return m;
		} else {
			return GetMember.builder().nickname("null").username("null").build();
		}
		
	}
}
