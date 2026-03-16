package com.example.validation1.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.validation1.entity.FileEntity;
import com.example.validation1.repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	FileRepository fileRepository;
	
	private String uploadDir = "C:/upload/";
	
	public void upload(MultipartFile file) throws Exception {
		String originalName = file.getOriginalFilename();
		System.out.println("originalName" + originalName);
		String savedName = UUID.randomUUID() + "_" + originalName; // 파일 이름이 중복되지 않게 랜덤 값을 추가하여 파일 이름을 저장
		System.out.println("savedName : " + savedName);
		
		File saveFile = new File(uploadDir + savedName);
		file.transferTo(saveFile);
		
		FileEntity entity = new FileEntity();
		entity.setOriginalName(originalName);
		entity.setSavedName(savedName);
		entity.setFilePath(uploadDir);
		entity.setFileSize(file.getSize());
		
		fileRepository.save(entity);
	}
	
	
	
}
