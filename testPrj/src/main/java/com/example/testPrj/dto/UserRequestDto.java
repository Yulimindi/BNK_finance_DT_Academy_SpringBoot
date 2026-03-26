package com.example.testPrj.dto;

import com.example.testPrj.entity.UserEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
	
	@NotBlank(message = "이름은 필수입니다.")
	private String name;
	
	@Email(message = "올바른 이메일 형식이 아닙니다.")
	@NotBlank(message = "이메일은 필수입니다.")
	private String email;
	
	@Size(min = 8, message = "비밀번호는 8자 이상이여야 합니다.")
	@NotBlank(message = "비밀번호는 필수입니다.")
	private String password;
	
	// dto를 Entity로 변환
	public UserEntity dtoToEntity() {
		return UserEntity.builder().name(name).email(email).password(password).build();
	}
}
