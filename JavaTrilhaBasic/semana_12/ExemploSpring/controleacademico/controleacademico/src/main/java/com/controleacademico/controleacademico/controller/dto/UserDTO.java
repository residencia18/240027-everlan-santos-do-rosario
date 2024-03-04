package com.controleacademico.controleacademico.controller.dto;

import com.controleacademico.controleacademico.modelo.User;

public class UserDTO {
	private int id;
	private String name;
	private String email;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getNome();
		this.email = user.getEmail();		
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	
}
