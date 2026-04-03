package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.MemberDto;
import com.example.rest.repository.MemberRepository;

@CrossOrigin("*")
@RestController
public class PutController {
	
	@Autowired
	MemberRepository mr;
	
	@PutMapping("/member")
	public String member(MemberDto dto) {
		System.out.println("어떻게 들어오냐?" + dto.toString());
		return mr.save(dto.dtoToEntity()).getName() + "학생 수정 완료"; 
	}
}
