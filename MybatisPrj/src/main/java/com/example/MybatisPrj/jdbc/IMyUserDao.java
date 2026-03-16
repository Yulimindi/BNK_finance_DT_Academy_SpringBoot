package com.example.MybatisPrj.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMyUserDao {
	List<MyUserDto> list();
	MyUserDto getUser(@Param("id")String id);
	void insertUser(String id, String pw);
	void deleteUser(String id);
	void updateUser(String pw, String id);
}
