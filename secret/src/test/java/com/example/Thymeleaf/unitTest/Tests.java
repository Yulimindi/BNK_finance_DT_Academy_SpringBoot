package com.example.Thymeleaf.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Thymeleaf.entity.MemberEntity;
import com.example.Thymeleaf.pojo.Secret;
import com.example.Thymeleaf.repository.MemberRepository;

@SpringBootTest
public class Tests {
	
	@Autowired
	MemberRepository mr;
	
	@Test
	void test() {
		Optional<MemberEntity> op = mr.findById("qwerqwer");
		assertEquals("q1w2e3r4", Secret.Decryption(op.get().getPw()));
	}
	
	@Test
	void testEncry() {
		assertEquals("u7{8i9v:8", Secret.Encryption("q1w2e3r4"));
	}
	
	@Test
	void testDecry() {
		assertEquals("q1w2e3r4", Secret.Decryption("u7{8i9v:8"));
	}
	
	
}
