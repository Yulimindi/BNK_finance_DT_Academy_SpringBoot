package com.example.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction.entity.TicketEntity;

@Transactional
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
	@Modifying
	@Query(value = "insert into ticket1 (pk1, consumer_Id, amount) values (ticket1_seq.nextval, :consumerId, :amount)", nativeQuery = true)
	int pay(@Param("consumerId") String consumerId, @Param("amount") String amount);
}
