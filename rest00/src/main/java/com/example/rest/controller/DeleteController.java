package com.example.rest.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.Member;

@RestController
@RequestMapping("/api/v1/delete")
public class DeleteController {
	
//	Member m1 = new Member("이름1", "mail1", "회사");
//	Member m2 = new Member("이름2", "mail2", "회사");
//	Member m3 = new Member("이름3", "mail3", "회사");
	ArrayList<Member> list = new ArrayList<>();
	
	@DeleteMapping("/member/{email}")
	public String deleteMember(@PathVariable("email") String email) {
		list.removeIf(member -> member.getEmail().equals(email));
		return list.toString();
	}
}
