package com.example.Thymeleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="m_tbl")
public class Member {
	@Id
	private String id;
	
	@Column(nullable=false, length=50)
	private String pw;
	
	@Column(nullable=false, length=50)
	private String name;
}
