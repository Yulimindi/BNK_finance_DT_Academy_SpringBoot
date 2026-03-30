package com.example.testPrj.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction1Dao {
	public void pay(String consumerid, int amount);
}
