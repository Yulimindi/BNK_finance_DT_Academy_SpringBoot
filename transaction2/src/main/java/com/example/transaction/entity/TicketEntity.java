package com.example.transaction.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@Builder@Table(name="ticket1")@AllArgsConstructor@NoArgsConstructor
public class TicketEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pk1;
	
	private String consumerId;
	
	@Column(nullable = false)
	private String amount;
}
