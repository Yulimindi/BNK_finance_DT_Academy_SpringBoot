package com.example.rest.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;

@SpringBootTest
public class JwtTest {
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Test
	@Disabled
	public void testGenerateToken() {
		String token = jwtUtil.generateToken("user1", "Member");
		System.out.println("token : " + token);
		
		Claims claims = jwtUtil.parseToken(token);
		String username = claims.getSubject();
		
		assertEquals(username, "user1");
	}
	
	@Test
	public void testGenerateToken2() {
		
		try {
			String token = jwtUtil.generateToken("user1", "Member");

			Thread.sleep(5000);

			assertEquals(jwtUtil.parseToken(token).getSubject(), "user1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
