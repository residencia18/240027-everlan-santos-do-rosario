package com.redesocial.redesocial.controller.dto;

import com.redesocial.redesocial.model.Usuario;

public class UserDTO {

	Usuario user;
	private Long id;
	private String name;
	private String email;
	
	
	public UserDTO(Usuario user) {
		this.user = user;
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
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

	public String getEmail() {
		return email;
	}

	
	@Override
	public String toString() {
		return "[\n name=" + name + "\n email=" + email + "\n ID=" + id + "\n]";
	}
	
	
}
