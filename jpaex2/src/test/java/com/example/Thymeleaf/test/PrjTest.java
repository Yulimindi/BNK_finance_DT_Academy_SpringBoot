package com.example.Thymeleaf.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.entity.MemberEntity;
import com.example.Thymeleaf.entity.MemoEntity;
import com.example.Thymeleaf.repository.MemberRepository;

@SpringBootTest
public class PrjTest {
	
	@Autowired
	MemberRepository mr;
	
	@Test
	void testMemberRepository() {
		MemberEntity result = mr.findByUsernameAndPw("qwe", "1234");
		assertNull(result);
//		assertEquals("qwe", result.getUsername());
	}
	
	@Test
	void memoDtoToEntityTest() {
		Memo m = new Memo();
		m.setWriter("홍길동");
		MemoEntity entity = m.dtoToEntity();
		assertEquals("홍길동", entity.getMember().getUsername());
	}
}
