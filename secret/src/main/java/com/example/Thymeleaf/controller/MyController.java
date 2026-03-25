package com.example.Thymeleaf.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Thymeleaf.dto.MemberDto;
import com.example.Thymeleaf.entity.MemberEntity;
import com.example.Thymeleaf.pojo.Secret;
import com.example.Thymeleaf.repository.MemberRepository;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@Autowired
	MemberRepository mr;
	
	@PostMapping("/regist")
	public String regist(MemberDto dto) {
		dto.setPw(Secret.Encryption(dto.getPw()));
		mr.save(dto.dtoToEntity());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(MemberDto dto) {
		System.out.println("진입");
		dto.setPw(Secret.Encryption(dto.getPw()));
		System.out.println("변환 : " + dto.getPw());
		
		if(mr.existsById(dto.getId())) {
			Optional<MemberEntity> op = mr.findById(dto.getId());
			if(op.get().getPw().equals(dto.getPw())) {
				return "success";
			}
		}
		return "redirect:/";
	}
}
