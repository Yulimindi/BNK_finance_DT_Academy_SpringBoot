package com.example.rest.inter;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMember {
	void deleteUser(Long empno);
	void updateUser(String job, Long sal, Long comm, Long deptno, Long empno);
}
