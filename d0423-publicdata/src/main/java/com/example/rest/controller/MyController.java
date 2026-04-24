package com.example.rest.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.example.rest.dto.Culture;

@Controller
public class MyController {
	@GetMapping("/")
	public String hello() {
		return "index";
	}
	
	@GetMapping("/view")
	public String view(@RequestAttribute("info") ArrayList<Culture> item, Model m) {
		m.addAttribute("info", item);
		System.out.println(item.get(0));
		return "view";
	}
}
