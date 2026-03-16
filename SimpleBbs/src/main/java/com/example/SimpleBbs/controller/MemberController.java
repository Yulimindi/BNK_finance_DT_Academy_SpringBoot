package com.example.SimpleBbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SimpleBbs.domain.Member;
import com.example.SimpleBbs.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member/regForm")
	public String regForm() {
		return "/member/regForm";
	}
	
	@PostMapping("/member/regist")
	public String regist(Member m) {
		System.out.println(m);
		memberService.regMember(m);
		
		return "redirect:/";
	}
}
