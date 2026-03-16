package com.example.SimpleBbs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	
	@Autowired
	JdbcTemplate jdbc;
	// 로그인
	public int login(String id, String pw) {
		int result = 0;
		String query = "select count(*) from memberTbl where id = ? and pw = ?";
		result = jdbc.queryForObject(query, Integer.class, id, pw);
		return result;
	}
}
