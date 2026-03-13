package com.example.validation1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.validation1.validation.ContentDto;
import com.example.validation1.validation.ContentValidator;

@Controller
public class MyController {
	@GetMapping("/")
	public String root() {
		System.out.println("ROOT");
		return "index";
	}
	
	@GetMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	@PostMapping("/create")
	public String insert2(@ModelAttribute("dto") ContentDto contentDto, BindingResult result) {
		String page = "createDonePage";
		System.out.println(contentDto);
		
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto, result);
		if(result.hasErrors()) {
			// 여기서 ModelAttribute 덕분에 createPage로 다시 가도 값이 남아있는거임
			page = "createPage";
		}
		return page;
	}
}
