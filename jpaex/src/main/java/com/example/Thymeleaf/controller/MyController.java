package com.example.Thymeleaf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Thymeleaf.entity.MemberEntity;
import com.example.Thymeleaf.repository.MemberRepository;

@Controller
public class MyController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/registForm")
	public String registForm() {
		return "registForm";
	}
	
	// 등록
	@PostMapping("/regist")
	public String regist(MemberEntity member) {
		System.out.println(member);
		MemberEntity m = memberRepository.save(member);
		System.out.println(m);
		return "redirect:/";
	}
	
	// 조회
	@PostMapping("/member")
	public String getMember(Model model, @RequestParam("id") Long id) {
		Optional<MemberEntity> op = memberRepository.findById(id);
		if(op.isPresent()) {
			MemberEntity member = op.get();
			model.addAttribute("member", member);
		}
		
		// 간단한 코드로 변경
//		MemberEntity member = op.orElse(null);
//		model.addAttribute("member", member);

		return "member";
	}
	
	@GetMapping("/members")
	public String getMembers(Model model) {
		List<MemberEntity> members = memberRepository.findAll();
		model.addAttribute("count", members.size());
		model.addAttribute("members", members);
		return "member";
	}
	
	@GetMapping("/detail")
	public String getMemberDetail(Model model, @RequestParam("mno") Long mno) {
		Optional<MemberEntity> op = memberRepository.findById(mno);
		MemberEntity member = op.orElse(null);
		model.addAttribute("member", member);
		return "detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("mno") Long mno) {
		memberRepository.deleteById(mno);
		return "redirect:/members";
	}
	
	@PostMapping("/update")
	public String update(MemberEntity m) {
		memberRepository.save(m);
		return "redirect:/members";
	}
	
}
