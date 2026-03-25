package com.example.Thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.entity.MemoEntity;
import com.example.Thymeleaf.service.MemoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemoController {
	
	@Autowired
	MemoService ms;
	
	@PostMapping("/createMemo")
	public @ResponseBody MemoEntity createMemo(Memo m, HttpSession session) {
		System.out.println("createMemo 왔어용");
		m.setWriter((String) session.getAttribute("username"));
		return ms.createMemo(m);
	}
	
	@GetMapping("/board")
	public String getAllMemo(Model m) {
		m.addAttribute("memo", ms.getAllMemo());
		return "board";
	}
	
	@GetMapping("/deleteMemo")
	public @ResponseBody boolean deleteMemo(@RequestParam("mno") int mno, HttpSession session) {
		if(ms.deleteMemo(mno, (String) session.getAttribute("username"))) {
			return true;
		}
		return false;
	}
}
