package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.IBoardDao;
import com.example.demo.dto.BoardDto;

@Controller
public class MyController2 {
	
	@GetMapping("/index2")
	public String goIndex2() {
		System.out.println("index2 진입");
		return "index2";
	}
	
	@Autowired
	IBoardDao board;
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list 진입");
		model.addAttribute("list", board.getList());
		return "list";
	}
	
	@GetMapping("/list2")
	public String list2(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) {
		List<BoardDto> list = board.getList2(type, keyword);
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/list3")
	public String list3(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) {
		List<BoardDto> list = board.getList3(type, keyword);
		model.addAttribute("list", list);
		return "list";
	}
}
