package com.example.Thymeleaf.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long pno;
	private String pName;
	private int price;
	private Boolean open;
//	private MultipartFile imagefile;
}
