package com.example.transaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyController {
	
	@GetMapping("/")
	public String index() {
		log.trace("TRACE log가 출력됩니다.");
		log.debug("DEBUG log가 출력됩니다.");
		log.info("INFO log가 출력됩니다.");
		log.warn("WARN log가 출력됩니다.");
		log.error("ERROR log가 출력됩니다.");
		return "index";
	}
	
	@GetMapping("/ex01")
	public String ex01(@RequestParam("username") String username, Model model) {
		log.info("입력 받은 파라미터 : {}", username);
		model.addAttribute("username", username);
		return "ex01";
	}
	
	@GetMapping("/order1")
	public String order1() {
		log.info("[CLICK_EVENT] | 우유");
		return "order1";
	}
	
	@GetMapping("/order2")
	public String order2() {
		log.info("[CLICK_EVENT] | 탄산");
		return "order2";
	}
	
	@GetMapping("/milk1")
	public String milk1(Model m) {
		log.info("[MILK] | 흰우유");
		m.addAttribute("drink", "흰우유 드릴게요");
		return "finish";
	}
	
	@GetMapping("/milk2")
	public String milk2(Model m) {
		log.info("[MILK] | 초코우유");
		m.addAttribute("drink", "초코우유 드릴게요");
		return "finish";
	}
	
	@GetMapping("/milk3")
	public String milk3(Model m) {
		log.info("[MILK] | 딸기우유");
		m.addAttribute("drink", "딸기우유 드릴게요");
		return "finish";
	}
	
	@GetMapping("/drink1")
	public String drink1(Model m) {
		log.info("[DRINK] | 콜라");
		m.addAttribute("drink", "콜라 드릴게요");
		return "finish";
	}
	
	@GetMapping("/drink2")
	public String drink2(Model m) {
		log.info("[DRINK] | 사이다");
		m.addAttribute("drink", "사이다 드릴게요");
		return "finish";
	}
	
	@GetMapping("/drink3")
	public String drink3(Model m) {
		log.info("[DRINK] | 환타");
		m.addAttribute("drink", "환타 드릴게요");
		return "finish";
	}
	
	
}
