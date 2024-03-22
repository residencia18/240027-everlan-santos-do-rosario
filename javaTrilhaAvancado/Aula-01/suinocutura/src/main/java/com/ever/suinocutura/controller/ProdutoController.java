package com.ever.suinocutura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ever.suinocutura.model.prouto.Produto;
import com.ever.suinocutura.service.produtoService.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		try {
			List<Produto> list = service.findAll();
			if(list.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		try {
			Produto obj = service.findById(id);
			if(obj == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(obj);
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produto));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id ,@RequestBody Produto produto){
		try {
			return ResponseEntity.ok(service.update(id,produto));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		try {
			service.findById(id);
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
}
