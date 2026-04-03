package com.example.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.Member;


@RestController
@RequestMapping("/api/v1/put-api/member")
public class PutController {
	
	@Autowired
	DeleteController dc;
	
	@PutMapping("/member")
	public String pubMember(@RequestBody Map<String, Object> putData) {
		StringBuilder sb = new StringBuilder();
		putData.entrySet().forEach(data -> {
			sb.append(data.getKey() + " : " + data.getValue() + "\n");
			
		});
		
		return sb.toString();
	}
	
	@PutMapping("/member2")
	public String pubMember2(Member member) {
		dc.list.add(member);
		return dc.list.toString();
	}
	
}
