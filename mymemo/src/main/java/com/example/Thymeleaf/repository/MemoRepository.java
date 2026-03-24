package com.example.Thymeleaf.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Thymeleaf.entity.MemoEntity;

@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, Integer>{


}
