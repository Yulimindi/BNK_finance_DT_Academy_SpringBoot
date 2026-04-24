package com.example.rest.entity;

import java.time.LocalDate;

import com.example.rest.dto.MemberDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="emp")
public class MemberEntity {
	
	@Id
	@Column(name = "empno")
	Long empno;
	
	@Column(name = "ename")
	String ename;
	
	@Column(name = "job")
	String job;
	
	@Column(name = "mgr")
	Long mgr;
	
	@Column(name = "hiredate")
	LocalDate hiredate;
	
	@Column(name = "sal")
	Long sal;
	
	@Column(name = "comm")
	Long comm;
	
	@Column(name = "deptno")
	Long deptno;
	
	public MemberDto entityToDto() {
		return MemberDto.builder().empno(empno).ename(ename).job(job).mgr(mgr).hiredate(hiredate).sal(sal).comm(comm).deptno(deptno).build();
	}
}
