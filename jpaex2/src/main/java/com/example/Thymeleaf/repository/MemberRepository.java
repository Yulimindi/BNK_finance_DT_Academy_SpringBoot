package com.example.Thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Thymeleaf.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	MemberEntity findByUsernameAndPw(String username, String pw);
}
