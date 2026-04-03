package com.example.secu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.secu.dto.MemberDto;
import com.example.secu.entity.MemberEntity;
import com.example.secu.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	@Autowired
	MemberRepository mr;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	public String createMember(MemberDto memberDto) {
		System.out.println("createMember 들어왔어");
		memberDto.setPw(encoder.encode(memberDto.getPw()));
		System.out.println(memberDto.getPw());
		MemberEntity entity = mr.save(memberDto.dtoToEntity());
		System.out.println("저장 : " + entity);
		return "";
	}
	
	public String updateMember() {
		
		return "";
	}
	
	public String deleteMember() {
		
		return "";
	}
	
	public String getMembers() {
		
		return "";
	}
	
	public String getOneMembers() {
		
		return "";
	}
	
	public List<MemberEntity> getBoss(String dept) {
		return mr.findByDept(dept); 
	}
}
