package com.redesocial.redesocial.controller.form;

import com.redesocial.redesocial.model.Usuario;

public class UserForme {

	private String name;
	private String email;
	private String senha;
	
	public UserForme() {
		
	}
	
	public UserForme(String name, String email, String senha) {
		setName(name);
		setEmail(email);
		setSenha(senha);
	}
	
	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setName(this.name);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		usuario.setId(null);
		return usuario;
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
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
