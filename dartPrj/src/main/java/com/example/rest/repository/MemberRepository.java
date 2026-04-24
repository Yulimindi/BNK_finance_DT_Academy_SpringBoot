package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.rest.entity.MemberEntity;

//import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
	
//	@Modifying
//	@Transactional
//	@Query(value = "insert into m_tbl values (:name, :age, :gender, :team)", nativeQuery = true)
//	int saveMember(@Param("name") String name, @Param("age") String age, @Param("gender") String gender, @Param("team") String team);
}
