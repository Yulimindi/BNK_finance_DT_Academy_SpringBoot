package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.DB;
import com.example.demo.dto.Comment;
import com.example.demo.dto.Member;
import com.example.demo.dto.Post;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	DB db;
	
	// ========== 페이지 이동 ==========
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping("/goJoin")
	public String goJoin() {
		return "join";
	}
	
	@RequestMapping("/goPost")
	public String goPost() {
		return "post";
	}
	
	@RequestMapping("/goPosting")
	public String goPosting() {
		return "posting";
	}
	
	@RequestMapping("/goDetail")
	public String goDetail() {
		return "detail";
	}
	
	@RequestMapping("/goUpdatePost")
	public String goUpdatePost() {
		return "updatePost";
	}
	
	// ========== 회원가입 ==========
	@PostMapping("doJoin")
	public String doJoin(Member m, Model model) {
		int result = db.join(m);
		if(result == 1) {
			model.addAttribute("result", "true");
			return "index";
		} else {
			return "index";
		}
		
	}
	
	// ========== 아이디 중복 확인 ==========
	@PostMapping("/checkId")
	public @ResponseBody String checkId(@RequestParam("id") String id) {
		int result = db.check(id);
		if(result == 0) {
			return "true";
		} else {
			return "false";
		}
	}
	
	// ========== 로그인 ==========
	@PostMapping("/doLogin")
	public String doLogin(Member m, Model model, HttpSession session) {
		int result = db.login(m);
		if(result == 0) {
			model.addAttribute("login", "false");
			return "index";
		} else {
			Member member = db.getMember(m);
			session.setAttribute("id", member.getId());
			session.setAttribute("pw", member.getPw());
			session.setAttribute("name", member.getName());
			return "redirect:/getPost?pagee=1";
		}
		
	}
	
	// ========== 게시글 가져오기(전체) ==========
	@GetMapping("/getPost")
	public String getPost(@RequestParam("pagee") String pagee, Model model) {
		System.out.println("getPost 진입");
		int len = db.getLength();
		System.out.println("getPost len : " + len);
		System.out.println("getPost pagee : " + pagee);
		if(pagee == "1") {
			System.out.println("controller : doLogin : page : 1");
			List<Post> list = db.getPost(1);
			len = len / 10 + 1;
			model.addAttribute("len", len);
			model.addAttribute("list", list);
			return "post";
		} else {
			System.out.println("controller : doLogin : page : else");
			pagee += "0";
			int page = Integer.parseInt(pagee);
			page -= 10;
			List<Post> list = db.getPost(page);
			len = len / 10 + 1;
			model.addAttribute("len", len);
			model.addAttribute("list", list);
			return "post";
		}
		
		
	}
	
	// ========== 게시글 작성 ==========
	@PostMapping("/doPost")
	public String doPost(Post p, HttpSession session) {
		db.createPost(p, session);
		return "redirect:/getPost?pagee=1";
	}
	
	// ========== 게시글 가져오기(하나) ==========
	@GetMapping("/getDetail")
	public String getDetail(@RequestParam("indexx") String indexx, Model m) {
		Post p = db.getOnePost(indexx);
		m.addAttribute("post", p);
		int index = Integer.parseInt(indexx);
		m.addAttribute("comment", db.getComment(index));
		return "detail";
	}
	
	@GetMapping("/getDetail2")
	public String getDetail2(@RequestParam("indexx") String indexx, Model m) {
		Post p = db.getOnePost(indexx);
		m.addAttribute("post", p);
		return "updatePost";
	}
	
	// ========== 게시글 삭제 ==========
	@GetMapping("/doDePost")
	public String doDePost(@RequestParam("indexx") int index, Model m) {
		db.deletePost(index);
		m.addAttribute("delete", "true");
		return "redirect:/getPost?pagee=1";
	}
	
	// ========== 게시글 수정 ==========
	@PostMapping("/doUpPost")
	public String doUpPost(@RequestParam("indexx") int index, @RequestParam("post_title") String post_title, @RequestParam("post_content") String post_content, Model m) {
		db.updatePost(index, post_title, post_content);
		m.addAttribute("update", "true");
		return "redirect:/getPost?pagee=1";
	}
	
	// ========== 댓글 작성 ==========
	@GetMapping("/doComment")
	public @ResponseBody List<Comment> doComment(@RequestParam("indexx") int index, @RequestParam("commentt") String commentt, HttpSession session) {
		db.insertComment(index, (String) session.getAttribute("id"), (String) session.getAttribute("name"), commentt);
		return db.getComment(index);
	}
	
	// ========== 댓글 삭제 ==========
	@GetMapping("/doDeComment")
	public String doDeComment(@RequestParam("name") String name, @RequestParam("commentt") String commentt, @RequestParam("indexx") int index, Model m, HttpSession session) {
		if(session.getAttribute("name").equals(name)) {
			db.deleteComment(index, name, commentt);
		}
		return "redirect:/getDetail?indexx="+index;
	}
	
}
