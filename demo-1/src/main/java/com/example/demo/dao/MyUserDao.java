package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MyUserDto;

@Repository
public class MyUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MyUserDto> list() {
		String query = "select * from myuser";
		
		List<MyUserDto> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<MyUserDto>(MyUserDto.class));
		return list;
	}
	
	public int insert(MyUserDto dto) {		
		String query = "insert into myuser values(?, ?, ?)";
		int result = jdbcTemplate.update(query, dto.getId(), dto.getPw(), dto.getName());
		return result;
	}
	
	public int checkId(String id) {
		int result = 0;
		String query = "select count(*) from myuser where id = ?";
		result = jdbcTemplate.queryForObject(query, Integer.class, id);
	
		return result;
	}
	
	public int login(MyUserDto dto) {
		int result = 0;
		String query = "select count(*) from myuser where id = ? and pw = ?";
		result = jdbcTemplate.queryForObject(query, Integer.class, dto.getId(), dto.getPw());
		return result;
	}
}
