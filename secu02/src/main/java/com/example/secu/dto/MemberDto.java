package com.example.secu.dto;

import com.example.secu.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private Long id;
	private String username;
	private String password;
	private String role;
	private String name;
	private String email;
	
	public static Member dtoToEntity(MemberDto dto) {
		return Member.builder().username(dto.username).password(dto.password).role(dto.role).name(dto.name).email(dto.email).build();
	}
}
