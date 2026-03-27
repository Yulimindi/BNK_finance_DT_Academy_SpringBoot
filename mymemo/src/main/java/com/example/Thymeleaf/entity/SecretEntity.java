package com.example.Thymeleaf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="memo_secret")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecretEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sno;
	
	@ManyToOne
	@JoinColumn(name="mno")
	private MemoEntity mno;
	
	private String accessUser;
	
	@Builder
	public SecretEntity(Integer mno, String accessUser) {
		this.mno = new MemoEntity();
		this.mno.setMno(mno);
		this.accessUser = accessUser;
	}
	
}
