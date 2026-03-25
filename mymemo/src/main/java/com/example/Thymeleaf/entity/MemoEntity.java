
package com.example.Thymeleaf.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="memo_memo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MemoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mno;
	
	@Column(nullable=false, length=50)
	private String title;
	
	@Column(nullable=false, length=1000)
	private String content;
	
	@ManyToOne
	@JoinColumn(name="writer")
	private MemberEntity member;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regDate;
	
	private int posX; 
    private int posY;
	
	@Builder
	public MemoEntity(String title, String content, String writer, int posX, int posY) {
		member = new MemberEntity();
		this.title = title;
		this.content = content;
		this.member.setUsername(writer);
		this.posX = posX;
		this.posY = posY;
	}
	
}
