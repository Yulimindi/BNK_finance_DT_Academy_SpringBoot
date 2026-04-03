package com.example.secu.util;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenCleanupScheduler {
	private final JdbcTemplate jdbcTemplate;
	
	@Scheduled(cron = "0 23 14 * * *")
	public void deleteExpiredTokens() {
		jdbcTemplate.update(
				"delete from persistent_logins where last_used < ?",
				new Date(System.currentTimeMillis() - (180 * 1000))
				);
	}
}
