package com.example.secu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.secu.dto.MemberDto;
import com.example.secu.entity.Member;
import com.example.secu.repository.MemberRepository;

@Service
public class JoinService {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	MemberRepository mr;
	
	public Member regist(MemberDto memberDto) {
		// 실제 DB에 저장하게 하는 메소드
		memberDto.setPassword(bCryptPasswordEncoder.encode(memberDto.getPassword()));
		if(memberDto.getUsername().equals("admin")) {
			memberDto.setRole("ROLE_ADMIN");
		} else {
			memberDto.setRole("ROLE_MEMBER");
		}
		System.out.println("!!!!!!!!!!!!!!!!!" + mr.save(MemberDto.dtoToEntity(memberDto)));
		return mr.save(MemberDto.dtoToEntity(memberDto));
	}
}
