package com.example.secu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.secu.dto.MemberDto;
import com.example.secu.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Member_Controller {

	@Autowired
	MemberService ms;

	@PostMapping("/createMember")
	public String createMember(MemberDto m) {
		System.out.println(m.getName());
		System.out.println(m.getPw());
		ms.createMember(m);
		return "redirect:/regist_page?ok";
	}
	
	@PostMapping("/updateMember")
	public String updateMember() {
		ms.updateMember();
		return "";
	}
	
	@PostMapping("/deleteMember")
	public String deleteMember() {
		ms.deleteMember();
		return "";
	}
	
	@PostMapping("/getMembers")
	public String getMembers() {
		ms.getMembers();
		return "";
	}
	
	@PostMapping("/getOneMembers")
	public String getOneMembers() {
		ms.getOneMembers();
		return "";
	}
}
