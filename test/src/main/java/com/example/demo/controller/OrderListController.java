package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.DB;
import com.example.demo.dto.OrderList;

@Controller
public class OrderListController {
	@Autowired
	DB db;
	
	@GetMapping("/selectOrder")
	public String selectOrder(Model model) {
		List<OrderList> list = db.getOrder();
		model.addAttribute("list", list);
		return "orderListInquiry";
	}
}
