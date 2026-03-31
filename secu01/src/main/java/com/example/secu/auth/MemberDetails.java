package com.example.secu.auth;

import com.example.secu.domain.Member;

public class MemberDetails {
	private Member member;
	
	// 생성자 주입
	public MemberDetails(String username, String password, String name, String role) {
		member = new Member();
		member.setUsername(username);
		member.setPassword(password);
		member.setName(name);
		member.setRole(role);
	}
	
	// username 반환하기
	public String getUsername() {
		return member.getUsername();
	}
	// password 반환하기
	public String getPassword() {
		return member.getPassword();
	}
	// name 반환하기
	public String getName() {
		return member.getName();
	}
	// role 반환하기
	public String getRole() {
		return member.getRole();
	}
}
