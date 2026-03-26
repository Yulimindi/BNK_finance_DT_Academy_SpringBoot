package com.example.testPrj.dto;

import com.example.testPrj.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
	private Long id;
	private String name;
	private String email;
	
	// Entity를 Dto로 변환
	public static UserResponseDto entityToDto(UserEntity user) {
		return UserResponseDto.builder().id(user.getId()).name(user.getName()).email(user.getName()).build();
	}
}
