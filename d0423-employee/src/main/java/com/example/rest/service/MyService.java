package com.example.rest.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rest.dto.MemberDto;
import com.example.rest.entity.MemberEntity;
import com.example.rest.inter.IMember;
import com.example.rest.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class MyService {
	
	@Autowired
	MemberRepository mr;
	
	@Autowired
	IMember im;
	
	public String login(Long dto, HttpSession session) {
		System.out.println(mr.existsById(dto));
		if(mr.existsById(dto)) {
			System.out.println("있다");
			session.setAttribute("empno", dto);
			return mr.findById(dto).get().getJob();
		} else {
			System.out.println("없다");
			return "false";
		}
	}
	
	public boolean regist(MemberDto dto) {
		System.out.println("저장해보자");
		mr.save(dto.dtoToEntity());
		System.out.println("됐나?");
		return true;
	}
	
	public MemberDto getInfo(Long empno) {
		return mr.findById(empno).get().entityToDto();
	}
	
	public List<MemberDto> getAllInfo(Long empno) {
		return mr.findAll().stream().map(member -> member.entityToDto()).collect(Collectors.toList());
	}
	
	public boolean delete(Long empno) {
		im.deleteUser(empno);
		return true;
	}
	
	public boolean update(MemberDto m) {
		im.updateUser(m.getJob(), m.getSal(), m.getComm(), m.getDeptno(), m.getEmpno());
		return true;
	}
}
