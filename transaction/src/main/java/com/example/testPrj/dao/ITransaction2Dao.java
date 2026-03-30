package com.example.testPrj.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaction2Dao {
	public void pay(String consumerid, int amount);
}
