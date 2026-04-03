package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.MemberEntity;
import com.example.rest.repository.MemberRepository;

@CrossOrigin("*")
@RestController
public class GetController {
	
	@Autowired
	MemberRepository mr;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/members")
	public List<MemberEntity> members() {
		return mr.findAll(); 
	}
	
	@GetMapping("/member")
	public MemberEntity members(@RequestParam("mno") String mno) {
		return mr.findByMnum(mno); 
	}
}
