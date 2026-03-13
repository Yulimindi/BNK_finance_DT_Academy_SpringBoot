package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	String id;
	String pw;
	String name;
	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}
