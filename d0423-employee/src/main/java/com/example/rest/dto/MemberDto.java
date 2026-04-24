package com.example.rest.dto;

import java.time.LocalDate;

import com.example.rest.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
	Long empno;
	String ename;
	String job;
	Long mgr;
	LocalDate hiredate;
	Long sal;
	Long comm;
	Long deptno;
	
	public MemberEntity dtoToEntity() {
		return MemberEntity.builder().empno(empno).ename(ename).job(job).mgr(mgr).hiredate(hiredate).sal(sal).comm(comm).deptno(deptno).build();
	}
}
