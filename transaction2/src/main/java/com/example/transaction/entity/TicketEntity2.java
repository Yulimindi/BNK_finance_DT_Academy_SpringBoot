package com.example.transaction.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity@Data@Builder@Table(name="ticket2")
public class TicketEntity2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pk2;
	
	private String consumerId;
	
	@Column(nullable = false)
	private String amount;
}
