package com.example.rest.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.rest.dto.Member;

@Mapper
public interface IMemberDao {
	Member login(String username, String password);
	Member selectId(String username);
	void regist(String username, String password, String nickname, String role);
}
