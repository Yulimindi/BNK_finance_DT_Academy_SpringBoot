package com.example.validation1.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity {
	private Long id;
	private String originalName;
	private String savedName;
	private String filePath;
	private Long fileSize;
	private Date regdate;
}
