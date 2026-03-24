package com.example.Thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Thymeleaf.entity.MemoEntity;

public interface MemoRepository extends JpaRepository<MemoEntity, Long>{

}
