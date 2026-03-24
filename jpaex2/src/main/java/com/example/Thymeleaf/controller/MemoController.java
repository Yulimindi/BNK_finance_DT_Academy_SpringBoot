package com.example.Thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.entity.MemoEntity;
import com.example.Thymeleaf.repository.MemoRepository;

@Controller
public class MemoController {
	
	@Autowired
	MemoRepository mr;
	
	@GetMapping("/memoList")
	public String memoList(Model m) {
		List<MemoEntity> memoList = mr.findAll();
		if(!memoList.isEmpty()) {
			m.addAttribute("memoList", memoList);
		}
		return "memoList";
	}
	
	// 메모 생성
	@PostMapping("/memoRegist")
	public String memoRegist(Memo memo) {
		mr.save(memo.dtoToEntity());
		return "redirect:/memoList";
	}
	
}
