package com.example.secu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="company_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String mno;
	
	@Column
	private String name;
	
	@Column
	private String pw;
	
	@Column
	private String position;
	
	@Column
	private String dept;
	
	@PrePersist
	public void generatemno() {
		if(this.mno == null) {
			this.mno = "EMP" + String.format("%04d", id);
		}
	}
}
