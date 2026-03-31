package com.example.secu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.secu.dto.MemberDto;
import com.example.secu.entity.Member;
import com.example.secu.service.JoinService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyController {
	
	@Autowired
	private JoinService js;
	
	@GetMapping("/")
	public String index() {
		log.info("인덱스로 숑~");
		return "index";
	}
	
	@GetMapping("/regist")
	public String regist() {
		log.info("가입하러 숑~");
		return "registForm";
	}
	
	@PostMapping("/registProc")
	public String registProc(MemberDto memberDto) {
		Member m = js.regist(memberDto);
		if(m == null) {
			return "redirect:/regist";
		}
		log.info("회원 등록 성공!");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		log.info("로그인하러 숑~");
		return "loginForm";
	}
	
	@PostMapping("/loginProc")
	public String loginProc(MemberDto MemberDto) {
		return "redirect:/members/welcome";
	}
}
