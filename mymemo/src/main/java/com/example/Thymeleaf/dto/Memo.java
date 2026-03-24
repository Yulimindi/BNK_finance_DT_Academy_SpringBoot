package com.example.Thymeleaf.dto;

import java.time.LocalDateTime;

import com.example.Thymeleaf.entity.MemoEntity;

import lombok.Data;

@Data
public class Memo {
	Integer mno;
	String title;
	String writer;
	String content;
	LocalDateTime regDate;
	int posX;
	int posY;
	
	public MemoEntity dtoToEntity() {
		return MemoEntity.builder().title(title).writer(writer).content(content).build();
	}
}
