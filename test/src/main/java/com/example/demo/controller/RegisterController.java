package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.DB;
import com.example.demo.dto.Order;

@Controller
public class RegisterController {
	
	@Autowired
	DB db;
	
	@PostMapping("insertOrder")
	public @ResponseBody String insertOrder(@RequestBody Order o) {

		int result = db.insert(o);
		if(result == 1) {
			System.out.println("result = 1");
			return "yes";
		} else {
			System.out.println("result = 0");
			return "no";
		}
	}
	
}
