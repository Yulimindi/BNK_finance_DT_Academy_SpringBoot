package com.example.secu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.secu.entity.MemberEntity;
import com.example.secu.repository.MemberRepository;

@Service
public class MemberDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository mr;
	
	@Override
	public UserDetails loadUserByUsername(String mno) throws UsernameNotFoundException {
		MemberEntity entity = mr.findByMno(mno);
		if(entity != null) {
			return new MemberDetails(entity);
		}
		return null;
	}

}
