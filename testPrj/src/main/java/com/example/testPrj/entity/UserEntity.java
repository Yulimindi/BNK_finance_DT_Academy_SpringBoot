package com.example.testPrj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Builder
	public UserEntity(String name, String email, String password) {
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 필수입니다.");
		}
		if(email == null || !email.contains("@")) {
			throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
		}
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	public void updateName(String name) {
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 필수입니다.");
		}
		this.name = name;
	}
	
	public void updatePassword(String password) {
		if(password == null || password.trim().isEmpty()) {
			throw new IllegalArgumentException("비밀번호는 필수입니다.");
		}
		this.password = password;
	}
	
	// 테스트용 정적 메서드
	public static UserEntity createWithId(Long id, String name, String email) {
		UserEntity user = UserEntity.builder().name(name).email(email).build();
		user.id = id;
		return user;
	}
}
