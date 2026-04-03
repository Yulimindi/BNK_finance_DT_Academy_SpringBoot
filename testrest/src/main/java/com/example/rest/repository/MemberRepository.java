package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	public MemberEntity findByMnum(String mno);
}
