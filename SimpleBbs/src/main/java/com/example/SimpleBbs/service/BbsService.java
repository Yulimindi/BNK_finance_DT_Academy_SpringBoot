package com.example.SimpleBbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SimpleBbs.dao.BbsDao;
import com.example.SimpleBbs.domain.Board;

@Service
public class BbsService {
	
	@Autowired
	BbsDao bbsDao;
	
	public void regist(Board board) {
		bbsDao.insert(board);
	}
	
	public List<Board> getList() {
		List<Board> list = bbsDao.getList();
		return list;
	}
	
	public Board getBoard(int bno) {
		return bbsDao.getBoard(bno);
	}
}
