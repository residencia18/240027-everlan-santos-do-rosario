package com.ever.suinocutura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ever.suinocutura.model.Produto;
import com.ever.suinocutura.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		try {
			return ResponseEntity.ok(service.findAll());
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(service.findById(id));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Produto> save(Produto produto){
		try {
			return ResponseEntity.created(null).body(service.save(produto));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Produto> update(Produto produto){
		try {
			return ResponseEntity.ok(service.update(produto));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		try {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
}
