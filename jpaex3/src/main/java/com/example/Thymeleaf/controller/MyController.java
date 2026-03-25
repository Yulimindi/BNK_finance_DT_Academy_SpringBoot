package com.example.Thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Thymeleaf.repository.UserRepository;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@Autowired
	UserRepository ur;
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("리스트 진입");
		model.addAttribute("list", ur.findAll());
		model.addAttribute("find", ur.findByAgeBetween(3, 25));
		model.addAttribute("finds", ur.findByEmailOrName("dld3@naver.com", "lele1"));
		model.addAttribute("contain", ur.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase("1", "2"));
		model.addAttribute("containname", ur.findByNameContainingIgnoreCase("1"));
		return "list";
	}
	
	
	
	
}
