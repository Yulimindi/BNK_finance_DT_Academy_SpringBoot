package com.example.secu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.secu.dao.IMemberDao;
import com.example.secu.domain.Member;

@Service
public class MemberDetailsService {
	
	@Autowired
	private IMemberDao memberDao;
	
	public MemberDetails loadMemberByUsername(String username) {
		// DB에서 멤버 가져오기
		Member m = memberDao.findByUsername(username);
		if(memberDao.findByUsername(username) != null) {
			MemberDetails md = new MemberDetails(m.getUsername(), m.getPassword(), m.getName(), m.getRole());
			return md;
		}
		// 멤버가 있으면 리턴하기
		return null;
	}
}
