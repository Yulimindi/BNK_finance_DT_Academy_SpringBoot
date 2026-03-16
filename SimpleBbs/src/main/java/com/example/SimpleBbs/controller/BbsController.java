package com.example.SimpleBbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SimpleBbs.domain.Board;
import com.example.SimpleBbs.service.BbsService;

@Controller
public class BbsController {
	
	@Autowired
	BbsService bbsService;
	
	@GetMapping("/board/regForm")
	public String regForm() {
		return "/board/regForm";
	}
	
	@PostMapping("/board/regist")
	public String regist(Board board) {
		bbsService.regist(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public String list(Model model) {
		List<Board> list = bbsService.getList();
		model.addAttribute("boardList", list);
		return "/board/list";
	}
	
	@GetMapping("/board/detail")
	public String detail(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", bbsService.getBoard(bno));
		return "/board/detail";
	}
}
