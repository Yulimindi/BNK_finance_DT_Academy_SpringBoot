package com.example.SimpleBbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SimpleBbs.dao.MemberDao;
import com.example.SimpleBbs.domain.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDao db;
	
	public void regMember(Member m) {
		db.insert(m);
	}
	
}
