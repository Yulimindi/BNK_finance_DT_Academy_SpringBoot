package com.example.SimpleBbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SimpleBbs.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public int login(String id, String pw) {
		return loginDao.login(id, pw);
	}
}
