package com.example.secu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.secu.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByUsername(String username);
}
