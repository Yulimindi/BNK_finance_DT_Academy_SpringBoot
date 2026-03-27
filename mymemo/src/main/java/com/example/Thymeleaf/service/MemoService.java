package com.example.Thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.dto.Secret;
import com.example.Thymeleaf.dto.SecretDto;
import com.example.Thymeleaf.entity.MemoEntity;
import com.example.Thymeleaf.entity.SecretEntity;
import com.example.Thymeleaf.repository.MemoRepository;
import com.example.Thymeleaf.repository.SecretRepository;


@Service
public class MemoService {
	
	@Autowired
	MemoRepository mr;
	
	@Autowired
	SecretRepository sr;
	
	public MemoEntity createMemo(Memo m) {
		System.out.println("메모 엔티티 : " + m);
		return mr.save(m.dtoToEntity());
	}
	
	public MemoEntity createSecretMemo(Memo m, String nameList) {
		String[] list = nameList.split(",");
		MemoEntity me = mr.save(m.dtoToEntity());
		System.out.println(me.getMno());
		for(String l : list) {
			sr.save(SecretDto.builder().mno(me.getMno()).accessUser(l).build().dtoToEntity());
		}
		return me;
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
