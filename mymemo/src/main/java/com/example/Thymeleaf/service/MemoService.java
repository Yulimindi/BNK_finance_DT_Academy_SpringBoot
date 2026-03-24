package com.example.Thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.entity.MemoEntity;
import com.example.Thymeleaf.repository.MemoRepository;

@Service
public class MemoService {
	
	@Autowired
	MemoRepository mr;
	
	public MemoEntity createMemo(Memo m) {
		return mr.save(m.dtoToEntity());
	}
}
