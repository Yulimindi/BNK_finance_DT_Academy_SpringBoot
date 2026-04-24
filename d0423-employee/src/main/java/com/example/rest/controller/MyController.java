package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rest.dto.MemberDto;
import com.example.rest.service.MyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	MyService ms;
	
	
	@GetMapping("/")
	public String index(@RequestParam(required = false, value="result") String result, Model m) {
		if(result != null) {
			m.addAttribute("result", result);
			return "index";
		}
		return "index";
	}
	
	@GetMapping("/registPage")
	public String registPage(@RequestParam(required = false, value="result") String result, Model m) {
		if(result != null) {
			m.addAttribute("result", result);
			return "index";
		}
		
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(MemberDto dto) {
		
		if(ms.regist(dto)) {
			return "redirect:/";
		} else {
			return "redirect:/result=true";
		}
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("empno") Long dto, HttpSession session) {
		String result = ms.login(dto, session);
		if(!result.equals("false")) { // 성공
			if(result.equals("PRESIDENT")) {
				return "redirect:/adminPage";
			} else {
				return "redirect:/memberPage";
			}
		} else { // 실패
			return "redirect:/result=fail";
		}
	}
	
	@GetMapping("/memberPage")
	public String memberPage(HttpSession session, Model m) {
		m.addAttribute("info", ms.getInfo((Long) session.getAttribute("empno")));
		return "member";
	}
	
	@GetMapping("/adminPage")
	public String adminPage(HttpSession session, Model m, @RequestParam(required = false, value="update") String update, @RequestParam(required = false, value="delete") String delete) {
		m.addAttribute("info", ms.getAllInfo((Long) session.getAttribute("empno")));
		return "admin";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("empno") Long empno) {
		ms.delete(empno);
		return "redirect:/adminPage?delete=ok";
	}
	
	@GetMapping("/updatePage")
	public String updatePage(@RequestParam("empno") Long empno, Model m) {
		m.addAttribute("info", ms.getInfo(empno));
		return "update";
	}
	
	@PostMapping("/update")
	public String update(MemberDto m) {
		ms.update(m);
		return "redirect:/adminPage?update=ok";
	}
}
