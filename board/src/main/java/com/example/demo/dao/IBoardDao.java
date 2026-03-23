package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.BoardDto;

@Mapper
public interface IBoardDao {
	public List<BoardDto> getList();
	public List<BoardDto> getList2(@Param("type")String type, @Param("keyword")String keyword);
	public List<BoardDto> getList3(@Param("type")String type, @Param("keyword")String keyword);
}
