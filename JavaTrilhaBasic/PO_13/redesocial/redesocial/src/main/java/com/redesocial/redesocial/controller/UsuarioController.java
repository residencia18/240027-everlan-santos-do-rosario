package com.redesocial.redesocial.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.redesocial.redesocial.controller.dto.UserDTO;
import com.redesocial.redesocial.controller.form.UserForme;
import com.redesocial.redesocial.model.Usuario;
import com.redesocial.redesocial.model.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	String view = "";

	@Autowired
	private UsuarioRepository userRepository;

	public UsuarioController() {
		view = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">";
	}

	@GetMapping
	public String listar(String name) {
		List<Usuario> usuarios;
		if (name != null) {
			usuarios = (ArrayList<Usuario>) userRepository.findByName(name);
		} else {
			usuarios = (ArrayList<Usuario>) userRepository.findAll();
		}
		List<UserDTO> users = usuarios.stream().map(UserDTO::new).collect(Collectors.toList());

		String retorno = view;
		retorno += "<div class=\"container\">";
		retorno += "<div class=\"row\">";
		retorno += "<div class=\"col\">";
		retorno += "<h1>Rede Social</h1>";
		retorno += "</div>";
		retorno += "</div>";
		retorno += "<div class=\"row\">";
		retorno += "<div class=\"col\">";
		retorno += "<a class=\"btn btn-primary\" href=\"../\">Home</a>";
		retorno += "<a class=\"btn btn-primary\" href=\"/usuario/\">Listar Usuários</a>";
		retorno += "</div>";
		retorno += "</div>";
		retorno += "<div class=\"row\">";
		retorno += "<div class=\"col\">";
		retorno += "<table class=\"table\">";
		retorno += "<thead>";
		retorno += "<tr>";
		retorno += "<th scope=\"col\">#ID</th>";
		retorno += "<th scope=\"col\">Nome</th>";
		retorno += "<th scope=\"col\">Email</th>";
		retorno += "</tr>";
		retorno += "</thead>";
		retorno += "<tbody>";
		for (UserDTO user : users) {
			retorno += "<tr>";
			retorno += "<td>" + user.getId() + "</td>";
			retorno += "<td>" + user.getName() + "</td>";
			retorno += "<td>" + user.getEmail() + "</td>";
			if (name == null) {
				retorno += "<td><a class=\"btn btn-primary\" href=\"/usuario/?name=" + user.getName()
						+ "\">Visualizar</a><td>";
			}
			retorno += "</tr>";
		}
		retorno += "</tbody>";
		retorno += "</table>";
		retorno += "</div>";
		retorno += "</div>";
		retorno += "</div>";
		return retorno;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		try {
			Usuario usuario = userRepository.getReferenceById(id);
			return ResponseEntity.ok(new UserDTO(usuario));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<UserDTO> inserir(@RequestBody UserForme user, UriComponentsBuilder uriBuilder) {
		Usuario usuario = user.toUsuario();
		// Verificar se o nome ja existe
		if (userRepository.findByName(user.getName()).size() > 0
				&& userRepository.findByEmail(user.getEmail()).size() > 0) {
			System.out.println("Ja existe");
			return ResponseEntity.badRequest().body(null);
		}
		userRepository.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDTO(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody UserForme user) {
		
		try {
			Usuario usuario = userRepository.getReferenceById(id);
			usuario.setName(user.getName());
			usuario.setEmail(user.getEmail());
			usuario.setSenha(user.getSenha());
			userRepository.save(usuario);
			return ResponseEntity.ok(new UserDTO(usuario));
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<?> alterar(@RequestBody UserForme user) {
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		try {
			Usuario usuario = userRepository.getReferenceById(id);
			if (usuario == null) {
				return ResponseEntity.notFound().build();
			}
			userRepository.delete(usuario);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/")
	public ResponseEntity<?> deletar() {
		return ResponseEntity.badRequest().build();
	}
}
