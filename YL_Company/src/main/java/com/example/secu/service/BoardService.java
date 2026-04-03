package com.example.secu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.secu.dto.BoardDto;
import com.example.secu.entity.BoardEntity;
import com.example.secu.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository br;
	
	public String createContent(BoardDto dto) {
		br.save(dto.dtoToEntity());
		return "";
	}
	
	public String updateContent(BoardDto dto) {
		return "";
	}
	
	public String deleteContent(BoardDto dto) {
		return "";
	}
	
	public String getMyContent() {
		return "";
	}
	
	public String getForMeContent() {
		return "";
	}
	
	public String getOneContent(Long b_id) {
		return "";
	}
	
	public String acceptContent(BoardDto dto) {
		return "";
	}
	
	public String rejectContent(BoardDto dto) {
		return "";
	}
	
	// 내가 쓴 글 제목, b_id 가져오기
	public List<BoardEntity> getMyContent(String username) {
		return br.findByWriter(username);
	}
	
}
