package com.example.secu00.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/welcome_admin")
	public String welcomeAdmin() {
		return "/admin/welcome_admin";
	}
	
	@GetMapping("/welcome_guest")
	public String welcomeGuest() {
		return "/guest/welcome_guest";
	}
	
	@GetMapping("/welcome_member")
	public String welcomeMember() {
		return "/member/welcome_member";
	}
}
