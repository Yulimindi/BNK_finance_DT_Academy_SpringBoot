package com.example.Thymeleaf.dto;

import java.time.LocalDateTime;

import com.example.Thymeleaf.entity.MemoEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Memo {
	Integer mno;
	String title;
	String writer;
	String content;
	LocalDateTime regDate;
	Secret s;
	int posX;
	int posY;
	
	public MemoEntity dtoToEntity() {
		return MemoEntity.builder().title(title).writer(writer).content(content).posX(posX).posY(posY).s(s) .build();
	}
}
