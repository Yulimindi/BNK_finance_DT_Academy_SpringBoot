package com.example.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.transaction.dto.Ticket;
import com.example.transaction.service.TicketService;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String getTicket() {
		return "getTicket";
	}
	
	@Autowired
	TicketService ts;
	
	@PostMapping("/ticket")
	public String ticket(Ticket t, @RequestParam("ERROR") String err, Model m) {
		
		m.addAttribute("id", t.getConsumerId());
		m.addAttribute("amount", t.getAmount());
		if(ts.ticket(t, err) == 1) {
			return "endPage";
		}
		return "/";
	}
}
