package com.ever.suinocutura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ever.suinocutura.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("AuthorizationService: " + username);
		UserDetails user = repository.findByLogin(username);
		return user;
	}

}
