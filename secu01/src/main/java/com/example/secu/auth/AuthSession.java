package com.example.secu.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AuthSession {
	
	private Map<String, MemberDetails> session = new HashMap<>();
	
	public void setAttribute(String username, MemberDetails memberDetails) {
		// 세션에 등록하기
		this.session.put(username, memberDetails);
		
	}
	
	public MemberDetails getAttribute(String username) {
		// 세션에서 Member 정보 얻어내기
		this.session.get(username);
		MemberDetails md = new MemberDetails(this.session.get(username).getUsername(), this.session.get(username).getPassword(), this.session.get(username).getName(), this.session.get(username).getRole());
		return md;
	}
	
	public void removeAttribute(String username) {
		// 세션에서 Member 정보 삭제하기
		this.session.remove(username);
		
	}
	
	public void invalidate() {
		// 세션 내용 비우기
		
	}
}
