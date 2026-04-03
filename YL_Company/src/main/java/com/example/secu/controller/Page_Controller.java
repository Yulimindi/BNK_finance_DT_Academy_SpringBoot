package com.example.secu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.secu.auth.MemberDetails;
import com.example.secu.entity.BoardEntity;
import com.example.secu.service.BoardService;
import com.example.secu.service.MemberService;

@Controller
public class Page_Controller {
	
	@Autowired
	MemberService ms;
	
	@Autowired
	BoardService bs;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/employee_page")
	public String employee_page() {
		return "employee_page";
	}
	
	@GetMapping("/manager_page")
	public String manager_page() {
		return "manager_page";
	}
	
	@GetMapping("/president_page")
	public String president_page() {
		return "president_page";
	}
	
	@GetMapping("/personal_page")
	public String personal_page() {
		return "personal_page";
	}
	
	@GetMapping("/create_content")
	public String create_content() {
		return "create_content";
	}
	
	@GetMapping("/update_content")
	public String update_content() {
		return "update_content";
	}
	
	@GetMapping("/content_detail")
	public String content_detail() {
		return "content_detail";
	}
	
	@GetMapping("/admin_page")
	public String admin_page() {
		return "admin_page";
	}
	
	@GetMapping("/member_detail")
	public String member_detail() {
		return "member_detail";
	}
	
	@GetMapping("/regist_page")
	public String regist_page(@RequestParam(value="ok", required = false) String ok, Model m) {
		if(ok != null) {
			m.addAttribute("message", "가입 완료");
		}
		return "regist_page";
	}
	
	@GetMapping("/login_page")
	public String login_page() {
		return "login_page";
	}
	
	@GetMapping("/createContent_page")
	public String createContent_page(Model m) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MemberDetails userDetails = (MemberDetails) authentication.getPrincipal();
		m.addAttribute("list", ms.getBoss(userDetails.getDept()));
		return "createContent_page";
	}
}
