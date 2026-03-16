package com.example.validation1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.validation1.pojo.Member;

@Controller
public class MyController {
	
	// 1번
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	// 2번 5번
	@GetMapping("/getData")
	public String getData(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		String member = "getData의 아이디는 " + id + " 비밀번호는 " + pw;
		model.addAttribute("str", member);
		return "index";
	}
	
	// 3번
	@PostMapping("/getParam")
	public @ResponseBody String getParam(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		String member = "getParam의 아이디는 " + id + " 비밀번호는 " + pw;
		return member;
	}
	
	// 4번
	@PostMapping("/getCommand")
	public @ResponseBody String getCommand(@RequestBody Member m) {
		String member = "getCommand의 아이디는 " + m.getId() + " 비밀번호는 " + m.getPw();
		return member;
	}
}
