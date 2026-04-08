package com.example.rest.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final SecretKey sk;
	private final long expiration;
	
	public JwtUtil(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") long expiration) {
		this.sk = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		this.expiration = expiration;
	}
	
	public String geterateToken(String username, String role, String nickname) {
		return Jwts.builder().subject(username).claim("role", role).claim("nickname", nickname).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + expiration)).signWith(sk).compact();
	}
	
	public Claims parseToken(String token) {
		return Jwts.parser().verifyWith(sk).build().parseSignedClaims(token).getPayload();
	}
	
	public boolean isValid(String token) {
		try {
			parseToken(token);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public String getUsername(String token) {
		return parseToken(token).getSubject();
	}
	
	public String getRole(String token) {
		return parseToken(token).get("role", String.class);
	}
	
	public String getNickname(String token) {
		return parseToken(token).get("nickname", String.class);
	}
}
