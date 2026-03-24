package com.example.Thymeleaf.dto;

import com.example.Thymeleaf.entity.MemberEntity;

import lombok.Data;

@Data
public class Member {
	private String username;
	private String pw;
	private String nickname;
	
	public MemberEntity memberToEntity() {		
		return MemberEntity.builder().username(username).pw(pw).nickname(nickname).build();
	}
}
