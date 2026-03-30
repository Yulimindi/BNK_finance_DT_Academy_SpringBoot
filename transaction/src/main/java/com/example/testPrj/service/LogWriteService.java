package com.example.testPrj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.testPrj.dao.ITransaction3Dao;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class LogWriteService {
	@Autowired
	ITransaction3Dao transaction3;
	
	public int write(String consumerid, int amount) {
		try {
			transaction3.pay(consumerid, amount);
			return 1;
		} catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
}
