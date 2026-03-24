package com.example.Thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/regForm")
	public String regForm() {
		return "regForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm(@RequestParam(required=false, name="fail") String fail, Model model) {
		if(fail != null) {
			model.addAttribute("msg", "로그인 실패");
		}
		return "loginForm";
	}

	@GetMapping("/memoRegForm")
	public String memoRegForm() {
		return "memoRegForm";
	}
	
	
}
