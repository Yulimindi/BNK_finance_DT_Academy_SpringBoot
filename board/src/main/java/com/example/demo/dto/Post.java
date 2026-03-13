package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	int indexx;
	String id;
	String name;
	String post_title;
	String post_content;
	String post_date;
	
	public Post(String post_title, String post_date) {
		this.post_title = post_title;
		this.post_date = post_date;
	}
}
