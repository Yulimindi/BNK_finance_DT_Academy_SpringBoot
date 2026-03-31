package com.example.secu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.secu.auth.AuthSession;
import com.example.secu.auth.MemberDaoAuthProvider;
import com.example.secu.auth.MemberDetails;
import com.example.secu.auth.PasswordEncoder;
import com.example.secu.dao.IMemberDao;
import com.example.secu.domain.Member;

@Controller
public class MainController {
	
	@Autowired
	MemberDaoAuthProvider mdap;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	IMemberDao memberDao;
	
	@Autowired
	AuthSession session;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	// 1. 등록 폼 열기("/registForm")
	@GetMapping("/registForm")
	public String registForm(@RequestParam(value = "fail", required = false) String fail, Model m){
		if(fail != null) {
			m.addAttribute("fail", "아이디가 중복됩니다.");
		}
		return "registForm";
	}
	
	// 2. 등록 처리 ("/regist")
	// 등록 시 패스워드 암호화 필수, role 필드 값은 "ROLE_MEMBER"로 설정
	// 등록 성공 시 로그인 폼으로 이동, 실패 시 등록 폼으로 이동
	@PostMapping("/regist")
	public String regist(Member m) {
		if(memberDao.findByUsername(m.getUsername()) == null) {
			m.setRole("ROLE_MEMBER");
			m.setPassword(passwordEncoder.passwordEncoder(m.getPassword()));
			memberDao.regist(m);
			return "redirect:/loginForm";
		} else {
		  return "redirect:/registForm?fail=true";
		}
	}
	
	// 3. 로그인 폼 열기
	@GetMapping("/loginForm")
	public String loginForm(@RequestParam(value = "fail", required = false) String fail, Model m) {
		if(fail != null) {
			m.addAttribute("fail", "아이디 또는 비밀번호가 틀렸습니다.");
		}
		return "loginForm";
	}
	
	// 4. 로그인 처리 ("/login")
	// 로그인 성공 시 /member/main으로 이동, 실패 시 로그인 폼으로 이동 - 다시 로그인 하라고 안내하기
	@PostMapping("/login")
	public String login(Member m) {
		m.setPassword(passwordEncoder.passwordEncoder(m.getPassword()));
		if(mdap.getMemberDetails(m.getUsername()) != null) {
			Member member = memberDao.findByUsername(m.getUsername());
			if(mdap.loginCheck(member.getUsername(), m.getPassword())) {
				return "redirect:/members/main?username=" + member.getUsername();
			} else {
				return "redirect:/loginForm?fail=true";
			}
		} else {
			return "redirect:/loginForm?fail=true";
		}
		
	}
	
	// 5. 회원 전용 메인 페이지 열기 ("/members/main")
	// 세션에 저장된 회원정보 화면에 출력하기
	@GetMapping("/members/main")
	public String members_main(@RequestParam("username") String username, Model m) {
		m.addAttribute("user", session.getAttribute(username));
		return "members/main";
	}
	
}
