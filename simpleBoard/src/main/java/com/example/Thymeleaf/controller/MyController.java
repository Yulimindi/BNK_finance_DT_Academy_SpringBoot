package com.example.Thymeleaf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Thymeleaf.*;
import com.example.Thymeleaf.entity.Board;
import com.example.Thymeleaf.entity.Member;
import com.example.Thymeleaf.repository.BoardRepository;
import com.example.Thymeleaf.repository.MemberRepository;

@Controller
public class MyController {

	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/registPage")
	public String registPage() {
		return "regist";
	}
	
	@Autowired
	MemberRepository mr;
	
	
	// 로그인
	@PostMapping("/login")
	public String login(Member m) {
		Optional<Member> mm = mr.findById(m.getId());
		if(mm.get().getPw().equals(m.getPw())) {
			return "redirect:/home";
		} else {
			return "redirect:/";
		}	
	}
	
	// 아이디 중복 체크
	
	
	// 회원가입
	@PostMapping("/regist")
	public String regist(Member m) {
		mr.save(m);
		return "redirect:/";
	}
	
	
	// =========================== 게시글
	
	@Autowired
	BoardRepository br;
	
	// 홈페이지
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	// 게시글 작성 페이지
	@GetMapping("/createPage")
	public String createPage() {
		return "create";
	}
	
	// 게시글 생성
	@PostMapping("/createPost")
	public String createPost(Board b) {
		br.save(b);
		return "redirect:/getPost";
	}
	
	// 전체 게시글 가져오기
	@GetMapping("/getPost")
	public String getPost(Board b, Model m) {
		System.out.println("getPost 진입");
		List<Board> op = br.findAll();
		m.addAttribute("posts", op);
		System.out.println("여기까지 ㅇㅋ");
		return "get";
	}
	
	@GetMapping("/getDetail")
	public String getDetail(@RequestParam("bno") int bno, Model model) {
		System.out.println("getDetail 진입");
		model.addAttribute("post", br.findById(bno).get());
		System.out.println("여기까지 ㅇㅋ");
		return "detail";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int no) {
		System.out.println("삭제 진입");
		br.deleteById(no);
		return "redirect:/getPost";
	}
	
	// 업데이트 페이지
	@GetMapping("/updatePage")
	public String updatePage(@RequestParam("bno") int bno, Model m) {
		m.addAttribute("post", br.findById(bno).get());
		return "update";
	}
	
	// 업데이트
	@PostMapping("/update")
	public String update(Board b) {
		br.save(b);
		return "redirect:/getPost";
	}
	
}
