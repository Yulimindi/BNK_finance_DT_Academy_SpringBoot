package com.example.secu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.secu.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
	MemberEntity findByMno(String mno);
	
	@Query(value = "select * from company_tbl where dept = :dept and position = 'ROLE_MANAGER'", nativeQuery = true)
	List<MemberEntity> findByDept(@Param("dept") String dept);
	
}
