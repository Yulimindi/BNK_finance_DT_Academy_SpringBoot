package com.example.MybatisPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MybatisPrj.jdbc.IMyUserDao;

@Controller
public class MyController {

	@Autowired
	private IMyUserDao userDao;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("users", userDao.list());
		return "userList";
	}
	
	@GetMapping("/getUser")
	public String getUser(@RequestParam("id") String id, Model model) {
		model.addAttribute("user", userDao.getUser(id));
		return "user";
	}
	
	@GetMapping("/insertUser")
	public String insertUser(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		userDao.insertUser(id, pw);
		return "redirect:/list";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") String id) {
		userDao.deleteUser(id);
		return "redirect:/list";
	}
	
	@GetMapping("/updateUser")
	public String updateUser(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		userDao.updateUser(pw, id);
		return "redirect:/list";
	}
}
