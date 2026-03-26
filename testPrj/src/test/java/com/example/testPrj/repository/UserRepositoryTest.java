package com.example.testPrj.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.ActiveProfiles;

import com.example.testPrj.entity.UserEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY) // 내장 DB를 사용하겠다 (H2) 메모리 상에서 동작, 속도 빠름 => 기본값임 보통 생략
@ActiveProfiles("test") // yml 파일 이름이 application-test자너 그래서 괄호에 test를 넣는겨
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository ur;
	
	@Disabled
	@Test
	@DisplayName("사용자 저장 테스트")
	public void saveUser() {
		// given (준비)
		UserEntity user = UserEntity.builder().name("홍길동").email("hong@green.com").password("12345678").build();
		
		// when (실행)
		UserEntity savedUser = ur.save(user);
		System.out.println(savedUser);
		
		// then (결과)
		assertNotNull(savedUser);
		
		assertEquals("홍길동", ur.findById(savedUser.getId()).get().getName());
		
		assertEquals("hong@green.com", savedUser.getEmail());
		
	}
	
	@Test
	@DisplayName("사용자 이메일 찾기 테스트")
	@Disabled
	public void findByEmail() {
		// given (준비)
		UserEntity user = UserEntity.builder().name("홍길동").email("hong@green.com").password("12345678").build();
		ur.save(user);
		
		// when (실행)
		Optional<UserEntity> foundUser = ur.findByEmail("hong@green.com");
		
		// then (결과)
		assertNotNull(foundUser);
		
		assertEquals("홍길동", foundUser.get().getName());
	}
	
	@Test
	@DisplayName("사용자 업데이트 테스트")
	@Disabled
	public void updateUser() {
		
		// given 준비
		UserEntity user = UserEntity.builder().name("홍길동").email("hong@green.com").password("12345678").build();
		ur.save(user);
		
		// when 실행
		System.out.println(user);
		user.updatePassword("00000000");
		UserEntity u = ur.save(user);
		
		// then 결과
		System.out.println(u);
		assertEquals("00000000", u.getPassword());
		assertSame(user, u);
		
	}
	
	@Test
	public void deleteUser() {
		// given 준비
		UserEntity user = UserEntity.builder().name("홍길동").email("hong@green.com").password("12345678").build();
		UserEntity savedUser = ur.save(user);
		System.out.println(savedUser);

		// when 실행
		ur.deleteById(savedUser.getId());
		
		// then 결과
		assertThat(ur.findById(savedUser.getId())).isEmpty();
	}
	
}
