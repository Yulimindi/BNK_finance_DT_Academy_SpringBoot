
package com.example.Thymeleaf.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.dto.Secret;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@Enumerated(EnumType.STRING) // 문자열로 매핑
	@Column(nullable=false, name="status", columnDefinition = "VARCHAR2(10) CHECK (status IN ('YES', 'NO'))")
	private Secret s;
	
	private int posX; 
    private int posY;
	
	@Builder
	public MemoEntity(String title, String content, String writer, Secret s ,int posX, int posY) {
		member = new MemberEntity();
		this.title = title;
		this.content = content;
		this.member.setUsername(writer);
		this.posX = posX;
		this.posY = posY;
		this.s = s;
	}
	
	public Memo entityToDto() {
		return Memo.builder().mno(mno).title(title).writer(member.getNickname()).content(content).regDate(regDate).s(s).posX(posX).posY(posY).build();
	}
	
}
