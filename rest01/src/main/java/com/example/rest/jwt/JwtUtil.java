package com.example.rest.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final SecretKey secretKey;
	private final long expiration;
	
	// expiration : 토큰 만료 시간, secretKey : 서버가 가지고 있는 비밀 키. 토큰을 확인하기 위함
	// Value : 내 컴퓨터의 설정 파일(application.property)의 값을 가져올 때 사용
	public JwtUtil(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") long expiration) {
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		this.expiration = expiration;
	}
	
	// 토큰 생성 (사용자 조건을 담고있음)
	// claim : jwt 안에 적히는 각각의 정보들을 가져올 수 있음
	public String generateToken(String username, String role) { // issuedAt : 발생 시점, expiration : 유효 기간
		return Jwts.builder().subject(username).claim("role", role).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + expiration)).signWith(secretKey).compact();
	}
	
	// 토큰 파싱
	public Claims parseToken(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
	}
	
	// 유효성 검사
	public boolean isValid(String token) {
		System.out.println("값 볼까? " + token);
		try {
			parseToken(token);
			return true;
		} catch(JwtException | IllegalIdentifierException e) {
			return false;
		}
	}
	
	// Claims에서 username 꺼내기
	public String getUsername(String token) {
		return parseToken(token).getSubject();
	}
	
	// Claims에서 role 꺼내기
	public String getRole(String token) {
		return parseToken(token).get("role", String.class);
	}
	
	
}
