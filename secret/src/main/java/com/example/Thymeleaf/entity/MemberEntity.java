package com.example.Thymeleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="secret_Tbl")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {
	
	@Id
	String id;
	
	@Column(nullable = false, length = 100)
	String pw;
}
