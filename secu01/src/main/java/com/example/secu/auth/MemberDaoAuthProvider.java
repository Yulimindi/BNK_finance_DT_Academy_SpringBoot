package com.example.secu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoAuthProvider {
	
	@Autowired
	private AuthSession session;
	@Autowired
	private PasswordEncoder pe;
	@Autowired
	MemberDetailsService mds;
	
	public MemberDetails getMemberDetails(String username) {
		return mds.loadMemberByUsername(username);
	}
	
	public boolean loginCheck(String username, String password) {
		// 비밀번호 암호화 해서 로그인 처리 해야함
		// 로그인 성공 시 세션에 등록
		if(getMemberDetails(username).getPassword().equals(password)) {
			session.setAttribute(username, mds.loadMemberByUsername(username));
			return true;
		} else {
			return false;
		}
	}
}
