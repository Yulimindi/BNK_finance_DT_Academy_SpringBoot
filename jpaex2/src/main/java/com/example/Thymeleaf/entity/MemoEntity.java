package com.example.Thymeleaf.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_memos")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MemoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long mno;
	
	@Column(nullable = false, length=500)
	private String message;
	
	// 작성자 (외래키)
	@ManyToOne // 다대일 관계다 (메모 기준)
	@JoinColumn(name="writer")
	private MemberEntity member;
	
	// 작성일자
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDate;
	
	// 수정 일자
	@LastModifiedDate
	private LocalDateTime modifyDate;
	
	@Builder
	public MemoEntity(String message, String writer) {
		member = new MemberEntity();
		this.message = message;
		this.member.setUsername(writer);
	}
	
	
}
