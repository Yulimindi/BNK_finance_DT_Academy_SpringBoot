package com.example.secu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.secu.auth.MemberDetails;
import com.example.secu.dto.BoardDto;
import com.example.secu.service.BoardService;

@Controller
public class Board_Controller {
	
	@Autowired
	BoardService bs;
	
	@PostMapping("/createContent")
	public String createContent(BoardDto dto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MemberDetails userDetails = (MemberDetails) authentication.getPrincipal();
		dto.setWriter(userDetails.getMno());
		dto.setState("wait");
		bs.createContent(dto);
		
		
		if(userDetails.getPosition().equals("ROLE_EMPLOYEE")) {
			return "redirect:/employee_page";
		} {
			return "redirect:/manager_page";
		}
	}
	
	@PostMapping("/updateContent")
	public String updateContent(BoardDto dto) {
		return "";
	}
	
	@PostMapping("/deleteContent")
	public String deleteContent(BoardDto dto) {
		return "";
	}
	
	@GetMapping("/getMyContent")
	public String getMyContent(Model m) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MemberDetails details = (MemberDetails) authentication.getPrincipal();		
		m.addAttribute("list", bs.getMyContent(details.getUsername()));
		return "getMyContent_page";
	}
	
	@GetMapping("/getForMeContent")
	public String getForMeContent() {
		return "";
	}
	
	@GetMapping("/getOneContent")
	public String getOneContent(Long b_id) {
		System.out.println("보드 넘버 : " + b_id);
		return "";
	}
	
	@PostMapping("/acceptContent")
	public String acceptContent(BoardDto dto) {
		return "";
	}
	
	@PostMapping("/rejectContent")
	public String rejectContent(BoardDto dto) {
		return "";
	}
	
}
