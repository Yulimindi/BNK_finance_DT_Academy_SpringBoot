package com.example.Thymeleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="memo_member")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
	
	@Id
	private String username;
	
	@Column(length=50, nullable=false)
	private String pw;
	
	@Column(length=50, nullable=false)
	private String nickname;
	
}
