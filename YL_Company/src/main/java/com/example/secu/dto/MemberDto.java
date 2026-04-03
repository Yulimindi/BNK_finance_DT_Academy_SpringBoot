package com.example.secu.dto;

import com.example.secu.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private Long id;
	private String mno;
	private String name;
	private String position;
	private String dept;
	private String pw;
	
	public MemberEntity dtoToEntity() {
		return MemberEntity.builder().id(id).mno(mno).name(name).position(position).dept(dept).pw(pw).build();
	}
}
