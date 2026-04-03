package com.example.secu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.secu.dto.MemberDto;
import com.example.secu.entity.Member;
import com.example.secu.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository mr;
	@Autowired // 빈 등록
	private BCryptPasswordEncoder bpe;
	
	public Member regist(MemberDto memberDto) {
		// Dto -> Entity + Pw 암호화
		if(memberDto.getUsername().equals("admin")) {
			memberDto.setRole("ROLE_ADMIN");
		} else {
			memberDto.setRole("ROLE_MEMBER");
		}
		memberDto.setPassword(bpe.encode(memberDto.getPassword()));
		System.out.println("값 :" + memberDto);
		mr.save(MemberDto.dtoToEntity(memberDto));
		System.out.println("저장");
		return null;
	}
}
