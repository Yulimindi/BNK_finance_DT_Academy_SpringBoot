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
@Table(name="tbl_members")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
	
	@Id
	private String username; // 아이디
	
	@Column(nullable=false, length=50)
	private String pw;
	
	@Column(nullable=false, length=50)
	private String nickname;
	
}
