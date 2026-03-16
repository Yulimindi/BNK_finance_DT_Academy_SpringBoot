package com.example.SimpleBbs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SimpleBbs.domain.Member;

@Repository
public class MemberDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	// 등록
	public int insert(Member m) {
		int result = 0;
		String query = "insert into memberTbl values (?, ?, ?)";
		result = jdbc.update(query, m.getId(), m.getPw(), m.getPw());
		return result;
	}
	
	
}
