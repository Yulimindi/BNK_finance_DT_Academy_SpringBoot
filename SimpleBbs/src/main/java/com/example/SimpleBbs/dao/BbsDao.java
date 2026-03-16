package com.example.SimpleBbs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SimpleBbs.domain.Board;

@Repository
public class BbsDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	// 등록
	public void insert(Board board) {
		String query = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate)";
		jdbc.update(query, board.getTitle(), board.getContent(), board.getWriter());
	}
	
	// 목록 조회
	public List<Board> getList() {
		String query = "select * from board";
		List<Board> list = jdbc.query(query, new BeanPropertyRowMapper<Board>(Board.class));
		return list;
	}
	
	// 상세 조회
	public Board getBoard(int bno) {
		String query = "select * from board where bno = ?";
		Board b = jdbc.queryForObject(query, new BeanPropertyRowMapper<Board>(Board.class), bno);
		return b;
	}
	
	// 수정
	public void modify(Board board) {
		String query = "";
	}
	
	// 삭제
	public void delete(int bno) {
		String query = "";
	}
}
