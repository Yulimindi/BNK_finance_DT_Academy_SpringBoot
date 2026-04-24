package com.example.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.Member;
import com.example.rest.entity.MemberEntity;
import com.example.rest.service.MemberService;

@RestController
public class TestController {
	
	@Autowired
	MemberService ms;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello! 스프링에서 보낸 응답입니댕";
	}
	
	@PostMapping("/regist")
	public Map<String, String> regist(@RequestBody Member m) {
		System.out.println(m);
		return ms.regist(m);
	}
	
	@GetMapping("/find")
	public String findTeam(@RequestParam("team") String team) {
		return ms.findTeam(team);
	}
	
	@GetMapping("/findAll")
	public List<MemberEntity> findAll() {
		return ms.findAll();
	}
}
