package com.example.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction.entity.TicketEntity2;

@Transactional
public interface TicketRepository2 extends JpaRepository<TicketEntity2, Long> {
	@Modifying
	@Query(value = "insert into ticket2 (pk2, CONSUMER_ID, amount) values (ticket2_seq.nextval, :consumerId, :amount)", nativeQuery = true)
	int pay2(@Param("consumerId") String consumerId, @Param("amount") String amount);
}
