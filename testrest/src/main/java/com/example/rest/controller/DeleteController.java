package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.MemberDto;
import com.example.rest.repository.MemberRepository;

@CrossOrigin("*")
@RestController
public class DeleteController {

	@Autowired
	MemberRepository mr;
	
	@DeleteMapping("/member")
	public String member(MemberDto dto) {
		String name = dto.getName();
		mr.deleteById(dto.getMnum());
		return name + "학생 삭제 완료"; 
	}
}
