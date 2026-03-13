package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.DB;
import com.example.demo.dto.Code;

@Controller
public class CodeController {
	
	@Autowired
	DB db;
	
	@GetMapping("/getCode")
	public String getCode(Model m) {
		List<Code> lst = db.getCode();
		m.addAttribute("list", lst);
		return "codeLookup";
	}
}
