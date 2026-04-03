package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.MemberDto;
import com.example.rest.repository.MemberRepository;

@CrossOrigin("*")
@RestController
public class PostController {

	@Autowired
	MemberRepository mr;
	
	@PostMapping("/member")
	public String member(MemberDto dto) {
		System.out.println("어떻게 들어오냐?" + dto.toString());
		return mr.save(dto.dtoToEntity()).getName() + "학생 가입 완료"; 
	}
}
