package com.example.Thymeleaf.service;

import java.util.List;
import java.util.Optional;

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
		System.out.println("메모 엔티티 : " + m);
		return mr.save(m.dtoToEntity());
	}
	
	public List<MemoEntity> getAllMemo() {
		return mr.findAll();
	}
	
	public boolean deleteMemo(int mno, String username) {
		Optional<MemoEntity> op = mr.findById(mno);
		if(op.get().getMember().getUsername().equals(username)) {
			mr.deleteById(mno);
			return true;
		}
		
		return false;
	}
}
