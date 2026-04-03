package com.example.secu.dto;

import java.time.LocalDateTime;

import com.example.secu.entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private Long b_id;
	private String title;
	private String detail;
	private LocalDateTime post_date;
	private String writer;
	private String reader;
	private String state;
	
	public BoardEntity dtoToEntity() {
		return BoardEntity.builder().b_id(b_id).title(title).detail(detail).post_date(post_date).writer(writer).reader(reader).state(state).build();
	}
}
