package com.example.validation3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.validation3.validation.ContentDto;
import com.example.validation3.validation.ContentValidator;

import jakarta.validation.Valid;

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
	
	@PostMapping("/create") // @Valid : 이 객체를 검증하라
	public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result) {
		String page = "createDonePage";
		System.out.println(contentDto);
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDto, result);
//		if(result.hasErrors()) {
//			// 여기서 ModelAttribute 덕분에 createPage로 다시 가도 값이 남아있는거임
//			page = "createPage";
//		}
		if(result.hasErrors()) {
			System.out.println("getAllErrors : " + result.getAllErrors());
			
			if(result.getFieldError("writer") != null) {
				System.out.println("1 : " + result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content") != null) {
				System.out.println("2 : " + result.getFieldError("content").getCode());
			}
			page = "createPage";
		}
		
		return page;
	}
	
	@InitBinder // 프로젝트 시작 시 실행
	protected void initBider(WebDataBinder binder) {
		// 검증기 설정
		binder.setValidator(new ContentValidator());
	}
}
