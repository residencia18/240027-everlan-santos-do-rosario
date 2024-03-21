package com.ever.suinocutura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ever.suinocutura.model.user.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	UserDetails findByLogin(String login);
}
