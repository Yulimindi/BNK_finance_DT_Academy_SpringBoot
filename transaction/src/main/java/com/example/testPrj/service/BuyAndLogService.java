package com.example.testPrj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BuyAndLogService {
	@Autowired
	BuyTicketService buyTicket;
	
	@Autowired
	LogWriteService logWrite;
	
	public int buy(String consumerid, int amount, String error) {
		try {
			buyTicket.buy(consumerid, amount, error);
			if(error.equals("2")) {
				int n = 10 / 0;
			}
			logWrite.write(consumerid, amount);
			return 1;
		} catch(Exception e) {
			System.out.println("[Transaction Propagation #1] Rollback");
			return 0;
		}
	}
}