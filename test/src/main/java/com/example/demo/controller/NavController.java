package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping("/goRegister")
	public String goRegister() {
		return "registerOrder";
	}
	
	@RequestMapping("/goOrderList")
	public String goOrderList() {
		return "redirect:/selectOrder";
	}
	
	@RequestMapping("/goOrderStatus")
	public String goOrderStatus() {
		return "redirect:/selectStatus";
	}
	
	@RequestMapping("/goCode")
	public String goCode() {
		return "redirect:/getCode";
	}
}
