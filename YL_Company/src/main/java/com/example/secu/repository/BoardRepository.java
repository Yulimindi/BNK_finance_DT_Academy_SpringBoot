package com.example.secu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.secu.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	List<BoardEntity> findByWriter(String username);
}
