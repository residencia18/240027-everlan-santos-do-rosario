package com.redesocial.redesocial.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.redesocial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByName(String name);
	
//	List<Usuario> findById(Long id);

	List<Usuario> findByEmail(String email);
	
}
