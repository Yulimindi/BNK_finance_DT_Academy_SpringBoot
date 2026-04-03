package com.example.secu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.secu.entity.Member;
import com.example.secu.repository.MemberRepository;

@Service
public class MemberDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository mr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = mr.findByUsername(username);
		if(member != null) {
			return new MemberDetails(member);
		}
		return null;
	}
	
}
