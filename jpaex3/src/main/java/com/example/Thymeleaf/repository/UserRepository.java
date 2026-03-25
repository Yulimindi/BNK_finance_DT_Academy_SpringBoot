package com.example.Thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Thymeleaf.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	public List<UserEntity> findByAgeBetween(int start, int end);
	public List<UserEntity> findByEmailOrName(String email, String name);
	public List<UserEntity> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
	public List<UserEntity> findByNameContainingIgnoreCase(String name);
}
