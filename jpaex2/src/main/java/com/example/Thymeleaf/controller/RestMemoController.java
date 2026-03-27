package com.example.Thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Thymeleaf.entity.MemoEntity;
import com.example.Thymeleaf.repository.MemoRepository;

@RestController
@RequestMapping("/api")
public class RestMemoController {

	@Autowired
	private MemoRepository mr;
	// http://localhost:8094/api/memoList/1
	@GetMapping("/memoList/{method}")
	public List<MemoEntity> memoList(@PathVariable("method") int method, Model m) {
		List<MemoEntity> memoList = null;
		
		if(method == 1) {
			memoList = mr.findAll();
		} else if(method == 2) {
			memoList = mr.findAllWithNative();
		} else {
			memoList = mr.findAllWithJpql();
		}
		
		m.addAttribute("memoList", memoList);
		
		return memoList;
	}
	
	@GetMapping("/memo/{mno}/{method}")
	public MemoEntity getMemo(@PathVariable("mno") Long mno, @PathVariable("method") int method) {
		MemoEntity memo = null;
		
		if(method == 1) {
			memo = mr.getMemoWithNative(mno);
		} else if(mno == 2) {
			memo = mr.getMemoWithJpql(mno);
		}
		
		return memo;
	}
}
