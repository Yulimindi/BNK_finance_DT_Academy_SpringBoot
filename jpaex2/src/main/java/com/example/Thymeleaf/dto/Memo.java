package com.example.Thymeleaf.dto;

import com.example.Thymeleaf.entity.MemoEntity;

import lombok.Data;

@Data
public class Memo {
	String message;
	String writer;
	
	public MemoEntity dtoToEntity() {
		return MemoEntity.builder().message(message).writer(writer).build();
	}
}
