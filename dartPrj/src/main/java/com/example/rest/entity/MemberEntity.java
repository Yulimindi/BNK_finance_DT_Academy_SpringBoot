package com.example.rest.entity;

import com.example.rest.dto.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="m_tbl")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long username;
	
	@Column
	String name;
	
	@Column
	String age;
	
	@Column
	String gender;
	
	@Column
	String team;
	
	public Member entityToDto() {
		return Member.builder().username(username).name(name).age(age).gender(gender).team(team).build();
	}
}
