package com.example.Thymeleaf.dto;

import com.example.Thymeleaf.entity.MemberEntity;

import lombok.Data;

@Data
public class MemberDto {
	private String id;
	private String pw;
	
	public MemberEntity dtoToEntity() {
		return MemberEntity.builder().id(id).pw(pw).build();
	}
}
