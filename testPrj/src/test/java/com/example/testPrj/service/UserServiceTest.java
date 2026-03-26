package com.example.testPrj.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.testPrj.dto.UserRequestDto;
import com.example.testPrj.dto.UserResponseDto;
import com.example.testPrj.entity.UserEntity;
import com.example.testPrj.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository ur; // 가짜
	
	@InjectMocks
	private UserService us; // 가짜를 주입할거야

	@Test
	@DisplayName("사용자 생성 테스트")
	void createUser() {
		// given
		UserRequestDto request = UserRequestDto.builder().name("홍길동").email("hong@email.com").password("00000000").build();
		UserEntity user = UserEntity.createWithId(100L, request.getName(), request.getEmail());
		System.out.println("1. Before Mock : " + user.getId()); // 100 출력
		// Mock 동작 정의
		given(ur.save(any(UserEntity.class)))
			.willReturn(user); // 어떤 User든 저장한다고 하면 user를 반환
		// => DB에 Insert 쿼리 수행되지 않음
		// => 단순히 미리 정의된 값을 반환함
		
		// when
		UserResponseDto response = us.createUser(request);
		System.out.println("1. After Mock : " + response.getId());
		// then
		assertEquals(100, response.getId());
		
		// 검증 (Mock 동작이 수행 됐는지 검증)
		then(ur).should(times(1)).save(any(UserEntity.class));
		
	}
}
