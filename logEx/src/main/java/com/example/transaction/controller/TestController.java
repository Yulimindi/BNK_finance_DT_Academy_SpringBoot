package com.example.transaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	@GetMapping("/test")
	public @ResponseBody String test() {
		log.info(">> test controller 실행! <<");
		return "test controller";
	}
}
