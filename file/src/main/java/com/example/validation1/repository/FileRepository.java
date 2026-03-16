package com.example.validation1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.validation1.entity.FileEntity;

@Repository
public class FileRepository {

	@Autowired
	JdbcTemplate jt;
	
	public void save(FileEntity file) {
		String sql = "insert into files values (files_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		jt.update(sql, file.getOriginalName(), file.getSavedName(), file.getFilePath(), file.getFileSize());
	}
	
	public FileEntity get(String id) {
		String sql = "select saved_name, file_path from files where id = ?";
		FileEntity file = jt.queryForObject(sql, new BeanPropertyRowMapper<FileEntity>(FileEntity.class), id);
		return file;
	}
}
