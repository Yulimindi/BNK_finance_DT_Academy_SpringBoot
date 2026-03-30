package com.example.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transaction.entity.TicketEntity;

public interface Pay extends JpaRepository<TicketEntity, Long>{

}
