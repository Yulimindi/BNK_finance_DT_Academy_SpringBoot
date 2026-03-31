package com.example.secu.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.secu.entity.Member;

public class CustomUserDetails implements UserDetails {

	private Member member; // 사용할 클래스를 필드에 두고 외부에 꺼내기 위해 게터 사용
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // GrantedAuthority을 상속 받은 것들만 들어올 수 있음
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {	
			@Override
			public @Nullable String getAuthority() {
				return member.getRole();
			}
		});
		
		return collection;
	}

	@Override
	public @Nullable String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}
	
	public String getName() {
		return member.getName();
	}
	
	public String getRole() {
		return member.getRole();
	}
	
	public String getEmail() {
		return member.getEmail();
	}
	
}
