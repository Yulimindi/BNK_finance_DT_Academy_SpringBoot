package com.example.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_tbl")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
	
	@Id
	String mnum;
	
	@Column
	String name;
	
	@Column
	String phone;
	
	@Column
	Integer grade;
	
	@Column
	String gender;
}
