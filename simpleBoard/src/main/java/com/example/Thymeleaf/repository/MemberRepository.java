package com.example.Thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Thymeleaf.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

}
