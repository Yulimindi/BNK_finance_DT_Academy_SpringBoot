package com.example.Thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Thymeleaf.dto.GetMember;
import com.example.Thymeleaf.dto.Member;
import com.example.Thymeleaf.entity.MemberEntity;
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
	
	public GetMember getUser(String nickname) {
		MemberEntity me = mr.findByNickname(nickname);
		if(me != null) {
			return GetMember.builder().nickname(me.getNickname()).username(me.getUsername()).build();
		}
		return GetMember.builder().nickname("null").username("null").build();
	}
}
