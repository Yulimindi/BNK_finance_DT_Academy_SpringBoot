package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.DB;
import com.example.demo.dto.Store;

@Controller
public class OrderStatusController {
	
	@Autowired
	DB db;
	
	@GetMapping("/selectStatus")
	public String selectStatus(Model m) {
		List<Store> lst = db.getStore();
		m.addAttribute("list", lst);
		return "orderStatus";
	}
	
}
