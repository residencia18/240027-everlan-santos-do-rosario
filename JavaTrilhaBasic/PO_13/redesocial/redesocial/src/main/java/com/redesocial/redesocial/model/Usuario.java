package com.redesocial.redesocial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	//@Column(unique = true)
	private String email;
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String name, String email, String password) {
		setId(id);
		setName(name);
		setEmail(email);
		setSenha(password);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	@Override
	public String toString() {
		return "User [\n name = " + name + "\n email = " + email + "\n senha = " + senha + "\n]";
	}
	
	
}
