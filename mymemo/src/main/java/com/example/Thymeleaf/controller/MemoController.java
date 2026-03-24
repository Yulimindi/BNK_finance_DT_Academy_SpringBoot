package com.example.Thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
		m.setWriter((String) session.getAttribute("username"));
		return ms.createMemo(m);
	}
}
