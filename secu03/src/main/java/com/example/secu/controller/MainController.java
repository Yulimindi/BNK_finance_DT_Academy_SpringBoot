package com.example.secu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.secu.dto.MemberDto;
import com.example.secu.entity.Member;
import com.example.secu.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	MemberService ms;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "regist";
	}
	
	@PostMapping("/registProc")
	public String registProc(MemberDto member) {
		System.out.println("진입");
		Member mem = ms.regist(member);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginForm(@RequestParam(value = "logout", required = false) String logout, Model m) {
		if(logout != null) {
			m.addAttribute("logout", logout);
		}
		return "login";
	}
	
	// 로그인 실패
	@GetMapping(value = "/login", params = "error")
	public String loginError(Model model) {
		model.addAttribute("errorMsg", "아이디 또는 비밀번호가 틀렸습니다.");
		return "login";
	}
	
	// 로그아웃 후
//	@GetMapping(value="/login", params = "logout")
//	public String loginLogout(Model model) {
//		model.addAttribute("logoutMsg", "로그아웃 되었습니다.");
//		return "login";
//	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'MEMBER')")
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}

	
}
