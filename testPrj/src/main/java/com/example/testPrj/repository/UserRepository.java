package com.example.testPrj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testPrj.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByEmail(String email);
}
