package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MyUserDao;
import com.example.demo.dto.MyUserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	MyUserDao dao;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/check")
	public @ResponseBody String checkID(MyUserDto dto) {
		System.out.println("controller : " + dto.getId());
		int count = dao.checkId(dto.getId());
		if(count == 0) { // 해당 아이디가 없으면
			return "true";
		} else { // 해당 아이디가 사용중이면
			return "false";
		}
		
	}
	
	@RequestMapping("/signup")
	public @ResponseBody String signIn(MyUserDto dto) {
		dao.insert(dto);
		return dto.getId();
	}
	
	@RequestMapping("/login")
	public String login(MyUserDto dto, Model model, HttpSession session) {
		int count = dao.login(dto);
		if(count == 0) {
			model.addAttribute("result", "false");
			return "index";
		} else {
			// 네임 받아오는거 해야함
			session.setAttribute("name", "이유림");
			return "redirect:/list";
		}
	}
	
	@RequestMapping("/list")
	public String showList(Model model) {
		List<MyUserDto> lst = dao.list();
		model.addAttribute("list", lst);
		return "page1";
	}
}
