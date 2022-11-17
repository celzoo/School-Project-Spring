package com.example.mvc.school.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mvc.school.dao.UserDataRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDataRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByname(username);
		if(user==null) {
			throw new UsernameNotFoundException("nao achou o nome");
		}
		
			return new CustomUserDetails(user);
		
	}
}
