package com.example.rest.dto;

import com.example.rest.entity.MemberEntity;

import lombok.Data;

@Data
public class MemberDto {
	String mnum;
	String name;
	String phone;
	Integer grade;
	String gender;
	
	public MemberEntity dtoToEntity() {
		return MemberEntity.builder().mnum(mnum).name(name).phone(phone).grade(grade).gender(gender).build();
	}
}
