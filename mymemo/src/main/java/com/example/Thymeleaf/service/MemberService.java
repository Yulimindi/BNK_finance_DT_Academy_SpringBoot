package com.example.Thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Thymeleaf.dto.Member;
import com.example.Thymeleaf.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository mr;
	
	public boolean checkId(String username) {
		if(mr.existsById(username)) {
			return false;
		}
		return true;
	}
	
	public boolean doSignup(Member m) {
		mr.save(m.dtoToEntity());
		return true;
	}
	
	public boolean doLogin(Member m) {
		if(mr.findByUsernameAndPw(m.getUsername(), m.getPw()) != null) {
			return true;
		}
		return false;
	}
}
