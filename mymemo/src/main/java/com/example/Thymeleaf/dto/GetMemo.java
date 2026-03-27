package com.example.Thymeleaf.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMemo {
	private Integer mno;
	private String title;
	private String content;
	private String writer;
	private String accessUser;
	private LocalDateTime regDate;
	private Secret s;
	private int posX; 
    private int posY;
}
