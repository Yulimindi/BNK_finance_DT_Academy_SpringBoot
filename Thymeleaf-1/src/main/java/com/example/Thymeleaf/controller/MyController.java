package com.example.Thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Thymeleaf.dto.Product;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("greet", "반가웡");
		return "index";
	}
	
	@GetMapping("/ex01")
	public String ex01Page(Model model) {
		model.addAttribute("info", new Product(1l, "공책", 1000, true));
		return "ex01";
	}
	
	// 요청 url : /ex02
	// Product 정보 10개를 생성하여 각각 데이터를 세팅하여 뷰에 한꺼번에 전달 후 보여주기
	@GetMapping("/ex02")
	public String ex02Page(Model model) {
		Long[] longg = {1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l};
		String[] name = {"공책", "연필", "공책", "연필", "공책", "연필", "공책", "연필", "공책", "연필"};
		int[] price = {1000, 500, 1000, 500, 1000, 500, 1000, 500, 1000, 500};
		Product p;
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < 10; i++) {
			p = new Product(longg[i], name[i], price[i], true);
			list.add(p);
		}
		model.addAttribute("list", list);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03Page(Model model) {
		Long[] longg = {1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l};
		String[] name = {"공책", "연필", "공책", "연필", "공책", "연필", "공책", "연필", "공책", "연필"};
		int[] price = {1000, 500, 1000, 500, 1000, 500, 1000, 500, 1000, 500};
		Product p;
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < 10; i++) {
			p = new Product(longg[i], name[i], price[i], false);
			list.add(p);
		}
		model.addAttribute("list", list);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04Page(Model model) {
		Long[] longg = {1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l};
		String[] name = {"공책", "연필", "공책", "연필", "공책", "연필", "공책", "연필", "공책", "연필"};
		int[] price = {1000, 500, 1000, 500, 1000, 500, 1000, 500, 1000, 500};
		Product p;
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < 5; i++) {
			p = new Product(longg[i], name[i], price[i], true);
			list.add(p);
		}
		model.addAttribute("list", list);
		return "ex04";
	}
	
	@PostMapping("/ex05")
	public String ex05(@RequestParam("param") String param, @RequestParam("param2") String param2, Model model) {
		model.addAttribute("parameter", param);
		model.addAttribute("parameter2", param2);
		return "ex05";
	}
	
	@GetMapping("/ex")
	public String exPage(@RequestParam("param") int param, Model model) {
		
		if(param == 1) {
			return "ex02";
		} else if(param == 2) {
			return "ex03";
		} else {
			return "ex04";
		}
	}
	
	@PostMapping("/ex06")
	public String ex06(@ModelAttribute("info") Product p) {
		System.out.println("open : " + p.getOpen());
		return "ex06";
	}
	
	@GetMapping("/ex08")
	public String ex08() {
		return "ex08";
	}
	
}
