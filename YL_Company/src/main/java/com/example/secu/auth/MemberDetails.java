package com.example.secu.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.secu.entity.MemberEntity;

public class MemberDetails implements UserDetails {

	private MemberEntity member;
	
	public MemberDetails(MemberEntity member) {
		this.member = member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {
			
			@Override
			public @Nullable String getAuthority() {
				return member.getPosition();
			}
		});
		return collection;
	}

	public String getPw() {
		return member.getPw();
	}

	public String getMno() {
		return member.getMno();
	}
	
	public String getName() {
		return member.getName();
	}
	
	public String getDept() {
		return member.getDept();
	}
	
	public String getPosition() {
		return member.getPosition();
	}

	@Override
	public @Nullable String getPassword() {
		return member.getPw();
	}

	@Override
	public String getUsername() {
		return member.getMno();
	}

	
	
}
