package com.example.Thymeleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_member")
@Data
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mno;
	@Column(nullable = false, unique = true, length = 50)
	private String id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 20)
	private String pw;
}
