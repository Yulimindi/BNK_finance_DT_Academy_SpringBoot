package com.example.rest.dto;

import com.example.rest.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member {
	Long username;
	String name;
	String age;
	String gender;
	String team;
	
	public MemberEntity dtoToEntity() {
		return MemberEntity.builder().username(username).name(name).age(age).gender(gender).team(team).build();
	}
}
