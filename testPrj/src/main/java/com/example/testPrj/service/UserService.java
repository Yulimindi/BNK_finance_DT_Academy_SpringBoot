package com.example.testPrj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.testPrj.dto.UserRequestDto;
import com.example.testPrj.dto.UserResponseDto;
import com.example.testPrj.entity.UserEntity;
import com.example.testPrj.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository ur;
	
	public UserResponseDto createUser(UserRequestDto request) {
		return UserResponseDto.entityToDto(ur.save(request.dtoToEntity()));
	}
	
	public UserResponseDto getUser(Long id) {
		Optional<UserEntity> op = ur.findById(id);
		return UserResponseDto.entityToDto(op.get());
	}
	
	public UserResponseDto getUserByEmail(String email) {
		UserEntity user = ur.findByEmail(email).get();
		return UserResponseDto.entityToDto(user);
	}
	
	
	public List<UserResponseDto> getUsers() {
		List<UserEntity> users = ur.findAll();
		List<UserResponseDto> list = new ArrayList<>();
		UserResponseDto dto;
		for(UserEntity i : users) {
			list.add(UserResponseDto.entityToDto(i));
		}
		
		// forEach 방식
//		users.stream().forEach(user -> {
//			list.add(UserResponseDto.from(user));
//		});
		
		// 메서드 참조 방식
//		List<UserResponseDto> list = users.stream().map(UserResponseDto::entityToDto).collect(Collectors.toList());
		
		return list;
	}
	
}
