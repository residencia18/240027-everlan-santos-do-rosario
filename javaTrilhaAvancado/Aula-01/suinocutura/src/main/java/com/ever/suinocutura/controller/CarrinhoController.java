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

import com.ever.suinocutura.model.carrinho.Carrinho;
import com.ever.suinocutura.service.carrinhoService.CarrinhoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@GetMapping
	public ResponseEntity<List<Carrinho>> findAll(){
		try {
			List<Carrinho> list = carrinhoService.findAll();
			if(list.isEmpty()) {
				log.info("Carrinhos não encontrados \n Lista de carrinhos vazia !!");
				return ResponseEntity.noContent().build();
			}
			log.info("Carrinhos encontrados com sucesso");
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> findById(@PathVariable Long id){
		try {
			Carrinho obj = carrinhoService.findById(id);
			if(obj == null) {
				log.info("Carrinho não encontrado com o id: " + id);
				return ResponseEntity.notFound().build();
			}
			log.info("Carrinho encontrado com sucesso");
			return ResponseEntity.ok(obj);
		}catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Carrinho> create(@RequestBody Carrinho carrinho){
		try {
			log.info("Carrinho criado com sucesso");
			return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.save(carrinho));
		}catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Carrinho> update(@PathVariable Long id, @RequestBody Carrinho carrinho){
		try {
			if(carrinhoService.findById(id) == null) {
				log.info("Carrinho não encontrado com o id: " + id);
				return ResponseEntity.notFound().build();
			}
			log.info("Carrinho atualizado com sucesso");
			return ResponseEntity.ok(carrinhoService.update(id, carrinho));
		}catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		try {
			carrinhoService.deleteById(id);
			log.info("Carrinho deletado com sucesso");
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
}
