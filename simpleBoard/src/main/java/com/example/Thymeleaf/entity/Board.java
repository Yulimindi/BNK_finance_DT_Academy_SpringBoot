package com.example.Thymeleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="board_tbl")
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bno;
	
	@Column(nullable=false, length=500)
	private String title;
	
	@Column(nullable=false, length=500)
	private String content;
	
	@Column(nullable=false, length=50)
	private String writer;
	
}
