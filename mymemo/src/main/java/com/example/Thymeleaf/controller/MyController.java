package com.example.Thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String index(@RequestParam(required=false, name="result") String result, Model model) {
		if(result != null) {
			model.addAttribute("result", "아이디 또는 비밀번호가 틀렸습니다.");
		}
		System.out.println(result);
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
}
