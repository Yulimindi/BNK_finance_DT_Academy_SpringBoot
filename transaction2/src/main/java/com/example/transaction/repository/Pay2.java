package com.example.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transaction.entity.TicketEntity;
import com.example.transaction.entity.TicketEntity2;

public interface Pay2 extends JpaRepository<TicketEntity2, Long>{
	
}
