package com.example.testPrj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.testPrj.dao.ITransaction1Dao;
import com.example.testPrj.dao.ITransaction2Dao;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BuyTicketService implements IBuyTicketService{
	
	@Autowired
	ITransaction1Dao dao1;
	
	@Autowired
	ITransaction2Dao dao2;
	
	@Override
	public int buy(String consumerid, int amount, String error) {
		try {
			dao1.pay(consumerid, amount);
			// 에러 발생 시키기
			if(error.equals("1")) {
				int n = 10 / 0;
			}
			dao2.pay(consumerid, amount);
			return 1;
		} catch(Exception e) {
			System.out.println(e);
			throw new RuntimeException();
//			return 0;
		}
	}

}
