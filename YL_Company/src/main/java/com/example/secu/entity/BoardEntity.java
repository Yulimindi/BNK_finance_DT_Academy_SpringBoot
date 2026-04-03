package com.example.secu.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="company_board_tbl")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long b_id;
	
	@Column
	private String title;
	
	@Column
	private String detail;
	
	@Column(updatable=false)
	@LastModifiedDate
	private LocalDateTime post_date;
	
	@Column
	private String writer;
	
	@Column
	private String reader;
	
	@Column
	private String state;
}
