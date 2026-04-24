package com.example.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.ItemDto;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ItemController {
	
	List<ItemDto> lst = Arrays.asList(
		new ItemDto(1L, "MacBook Pro", "Apple 노트북 16인치"),
		new ItemDto(2L, "iPhone 15", "최신 스마트폰"),
		new ItemDto(3L, "Galaxy Buds", "무선 이어폰"),
		new ItemDto(4L, "LG 모니터", "27인치 4K")
	);
	
	
	@GetMapping("/items")
	public List<ItemDto> getItems() {
		return lst;
	}
	
	@GetMapping("/items/{id}")
	public ItemDto getItem(@PathVariable("id") int id) {
		ItemDto dto = lst.get(id-1);
		return dto;
				
	}
}
