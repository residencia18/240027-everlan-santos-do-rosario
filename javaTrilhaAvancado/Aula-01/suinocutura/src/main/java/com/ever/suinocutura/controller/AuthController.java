package com.ever.suinocutura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ever.suinocutura.controller.dto.AuthDTO;
import com.ever.suinocutura.controller.dto.LoginResponseDTO;
import com.ever.suinocutura.controller.dto.RegisterDTO;
import com.ever.suinocutura.model.user.Usuario;
import com.ever.suinocutura.repository.UserRepository;
import com.ever.suinocutura.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthDTO authDTO) {
//		authDTO = new AuthDTO("juca", "123456789");
//		System.out.println("Login: " + authDTO.login());
		var usernamePassword = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password());
//		System.out.println("Credenciais: " + usernamePassword.getCredentials());
		var auth = this.authenticationManager.authenticate(usernamePassword);
//		System.out.println("ESSE É o Usuario: " + auth.getPrincipal());
		var token = this.tokenService.generateToken((Usuario)auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO) {
		if(this.repository.findByLogin(registerDTO.login()) != null) {
			return ResponseEntity.badRequest().build();
		}
		String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
		Usuario newuser = new Usuario(registerDTO.login(), encryptedPassword, registerDTO.role());
		this.repository.save(newuser);
		return ResponseEntity.ok().build();
	}
	
	
}
