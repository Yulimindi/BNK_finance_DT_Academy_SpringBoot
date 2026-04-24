package com.example.rest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.dto.Member;
import com.example.rest.entity.MemberEntity;
import com.example.rest.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository mr;
	
	String[] group = {"Gryffindor", "Slytherin", "Ravenclaw", "Hufflepuff"};
	
	public Map<String, String> regist(Member m) {
		Map<String, String> member = new HashMap<>();
		
		int num = (int) (Math.random() * 4); 
		m.setTeam(group[num]);
		Member newM = mr.save(m.dtoToEntity()).entityToDto();
		
		member.put("username", newM.getUsername().toString());
		member.put("team", newM.getTeam());
		
		return member;
	}
	
	public String findTeam(String team) {
		if(mr.existsById(Long.parseLong(team))) {
			Member m = mr.findById(Long.parseLong(team)).get().entityToDto();
			return m.getTeam();
		}
		return "no";
	}
	
	public List<MemberEntity> findAll() {
		return mr.findAll();
	}
}
