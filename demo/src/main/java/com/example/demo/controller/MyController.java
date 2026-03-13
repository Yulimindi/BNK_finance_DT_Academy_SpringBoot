package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dto.Member;
import com.example.demo.dto.NewMember;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	ArrayList<NewMember> lst = new ArrayList<>();
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root!!!!!!!!!!");
		return "index";
	}
	
	@RequestMapping("/a")
	public String rootA() {
		System.out.println("A!!!!!!!!!!");
		return "a";
	}
	
	@RequestMapping("/b")
	public String rootB(HttpServletRequest request) {
		System.out.println("BBBBB");
		String x = request.getParameter("x");
		System.out.println("x = " + x);
		return "b";
	}
	
	@RequestMapping("/c")
	public String rootC(@RequestParam("x") String x) {
		System.out.println("CCCCCCCCC");
		System.out.println("x = " + x);
		return "c";
	}
	
	@RequestMapping("/d")
	public @ResponseBody Member rootD(@RequestParam("no") int no, @RequestParam("name") String name, @RequestParam("phone") String phone) {
		System.out.println("DDDDDDDDDDD");
		Member m = new Member(no, name, phone);
		System.out.println(m);
		return m;
	}
	
	
	@RequestMapping("/e")
	public Member rootD(Member m, Model model) {
		System.out.println("EEEEEEE");
		System.out.println(m);
		model.addAttribute("name", m.getName());
		return m;
	}
	
	@RequestMapping("/f")
	public Member rootf(Member m, Model model, HttpServletRequest request) {
		System.out.println("EEEEEEE");
		System.out.println(m);
		model.addAttribute("name", m.getName());
		HttpSession session = request.getSession();
		session.setAttribute("name", m.getName());
		return m;
	}
	
	// http://localhost:8080/test/hong/홍길동
	@RequestMapping("/test/{id}/{name}")
	public String test(@PathVariable("id") String id, @PathVariable("name") String name, Model model) {
		System.out.println("TEST " + id + ", " + name);
		model.addAttribute("id", id);
		return "test";
	}
	
	@RequestMapping("/amember")
	public @ResponseBody Member amember(Member m) {
		System.out.println(m);
		return m;
	}
	
	@RequestMapping("/member")
	public String member() {
		System.out.println("member 페이지");
		return "member";
	}
	
	@RequestMapping("/checkData")
	public @ResponseBody ArrayList<NewMember> checkData (NewMember m) {
		System.out.println("===== 체크 =====");
		for(int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i).getId());
		}
		System.out.println("===============");
		return lst;
	}
	
	@RequestMapping("/getData")
	public @ResponseBody ArrayList<NewMember> getData (NewMember m) {
		lst.add(m);
		
		System.out.println("===== 더하기 =====");
		for(int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i).getId());
		}
		System.out.println("===============");
		return lst;
	}
	
	@RequestMapping("/login")
	public @ResponseBody ArrayList<NewMember> login (NewMember m) {
		return lst;
	}
	
	
}
