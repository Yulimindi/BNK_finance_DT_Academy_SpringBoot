package com.example.Thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Thymeleaf.entity.MemoEntity;

public interface MemoRepository extends JpaRepository<MemoEntity, Long>{
	
	@Query(value = "select * from tbl_memos", nativeQuery = true)
	List<MemoEntity> findAllWithNative();
	
	@Query(value = "select memo from MemoEntity memo")
	List<MemoEntity> findAllWithJpql();
	
	@Query(value = "select * from tbl_memos where mno = :mno", nativeQuery = true)
	MemoEntity getMemoWithNative(@Param("mno") Long mno);
	
	@Query(value = "select memo from MemoEntity memo where memo.mno = :mno")
	MemoEntity getMemoWithJpql(@Param("mno") Long mno);
	
	@Query(value = "select memo from MemoEntity memo")
	List<MemoEntity> findAllJoinWithJpql();
	
	// 조인은 JPA가 알아서 해줌
	@Query(value ="select m.mno, m.message, m.writer, mb.nickname, m.reg_date, m.modify_date from tbl_memos m " +
			"inner join tbl_members mb on m.writer = mb.username"
			 , nativeQuery = true)
	List<MemoEntity> findAllJoinWithNative();
}
