package com.example.Thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Thymeleaf.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
