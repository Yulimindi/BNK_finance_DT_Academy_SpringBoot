package com.example.Thymeleaf.dto;

import com.example.Thymeleaf.entity.SecretEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecretDto {
	private Integer mno;
	private String accessUser;
	
	public SecretEntity dtoToEntity() {
		return SecretEntity.builder().mno(mno).accessUser(accessUser).build();
	}
}
