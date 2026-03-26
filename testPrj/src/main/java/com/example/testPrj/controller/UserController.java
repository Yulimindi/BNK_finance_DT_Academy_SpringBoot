package com.example.testPrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testPrj.dto.UserRequestDto;
import com.example.testPrj.dto.UserResponseDto;
import com.example.testPrj.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto dto) {
		return ResponseEntity.ok(userService.createUser(dto));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<UserResponseDto> getUserById(@Valid @PathVariable("id") Long id) {
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<UserResponseDto> getUserByEmail(@Valid @PathVariable("email") String email) {
		return ResponseEntity.ok(userService.getUserByEmail(email));
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDto>> getUsers() {
		List<UserResponseDto> list = userService.getUsers();
		return ResponseEntity.ok(list);
	}
}
