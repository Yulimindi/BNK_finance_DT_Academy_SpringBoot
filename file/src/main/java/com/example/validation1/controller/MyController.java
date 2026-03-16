package com.example.validation1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.validation1.entity.FileEntity;
import com.example.validation1.repository.FileRepository;
import com.example.validation1.service.FileService;

@Controller
public class MyController {
	
	@Autowired
	FileService fileService;
	
	@Autowired
	FileRepository file;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws Exception {
		fileService.upload(file);
		return "redirect:/uploadForm";
	}
	
	@PostMapping("/getFile")
	public @ResponseBody String getFile(@RequestParam("id") String id) {
		FileEntity entity = file.get(id);
		String name = entity.getSavedName();
		
		String path = entity.getFilePath();
		path = path.replace("C:", "");
		String realPath = path + name;
		return realPath;
	}
	
}
