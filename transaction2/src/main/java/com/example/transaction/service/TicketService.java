package com.example.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction.dto.Ticket;
import com.example.transaction.repository.TicketRepository;
import com.example.transaction.repository.TicketRepository2;

@Service
@Transactional
public class TicketService {
	
	@Autowired
	TicketRepository tr1;
	@Autowired
	TicketRepository2 tr2;
	
	public int ticket(Ticket t, String err) {
		System.out.println(err);
		tr1.pay(t.getConsumerId(), t.getAmount());
		if(err.equals("1")) {
			int result = 10 / 0;
			System.out.println(result);
		}
		tr2.pay2(t.getConsumerId(), t.getAmount()); 
		
		return 1;
	}
	
	
}
