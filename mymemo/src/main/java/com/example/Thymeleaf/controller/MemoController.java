package com.example.Thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Thymeleaf.dto.GetMemo;
import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.dto.Secret;
import com.example.Thymeleaf.dto.SecretDto;
import com.example.Thymeleaf.entity.MemoEntity;
import com.example.Thymeleaf.service.MemoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemoController {
	
	@Autowired
	MemoService ms;
	
	@PostMapping("/createMemo")
	public @ResponseBody GetMemo createMemo(Memo m, @RequestParam(required=false, value="nameList") String nameList, HttpSession session) {
		System.out.println("createMemo 왔어용");
		m.setWriter((String) session.getAttribute("username"));
		if(m.getS().equals(Secret.NO)) {
			Memo memo = ms.createMemo(m).entityToDto();
			return GetMemo.builder().mno(memo.getMno()).title(memo.getTitle()).content(memo.getContent()).writer(memo.getWriter()).regDate(memo.getRegDate()).s(memo.getS()).posX(memo.getPosX()).posY(memo.getPosY()).accessUser(nameList).build();
		}
		Memo memo = ms.createSecretMemo(m, nameList).entityToDto();
		return GetMemo.builder().mno(memo.getMno()).title(memo.getTitle()).content(memo.getContent()).writer(memo.getWriter()).regDate(memo.getRegDate()).s(memo.getS()).posX(memo.getPosX()).posY(memo.getPosY()).accessUser(nameList).build();
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
