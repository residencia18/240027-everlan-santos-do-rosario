package com.EverDev.Leilao.controller;

import java.net.URI;
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

import com.EverDev.Leilao.controller.dto.LeilaoDTO;
import com.EverDev.Leilao.controller.form.LeilaoForm;
import com.EverDev.Leilao.model.Leilao;
import com.EverDev.Leilao.repository.LeilaoRepository;

@RestController
@RequestMapping("/leilao/")
public class LeilaoController {
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	
	public LeilaoController() {}
	
	@GetMapping
	public ResponseEntity<?> getLeilao() {
		try {
			List<LeilaoDTO> leiloes = leilaoRepository.findAll().stream().map(LeilaoDTO::new).collect(Collectors.toList());
			return ResponseEntity.ok(leiloes);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLeilao(@PathVariable Long id) {
		try {
			LeilaoDTO leilao = new LeilaoDTO(leilaoRepository.getReferenceById(id));
			return ResponseEntity.ok(leilao);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> postLeilao(@RequestBody LeilaoForm form, UriComponentsBuilder uriBuilder) {
		try {
			Leilao leilao = new Leilao();
			leilao.setDescricao(form.getDescricao());
			leilao.setValorMinimo(form.getValorMinimo());
			leilao.setStatus(form.isStatus());
			leilaoRepository.save(leilao);
			URI uri = uriBuilder.path("/leilao/{id}").buildAndExpand(leilao.getId()).toUri();
			return ResponseEntity.created(uri).body(new LeilaoDTO(leilao));
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putLeilao(@PathVariable Long id, @RequestBody LeilaoForm form) {
		try {
			Leilao leilao = leilaoRepository.getReferenceById(id);
			leilao.setDescricao(form.getDescricao());
			leilao.setValorMinimo(form.getValorMinimo());
			leilao.setStatus(form.isStatus());
			leilaoRepository.save(leilao);
			return ResponseEntity.ok(new LeilaoDTO(leilao));
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<?> putLeilao() {
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLeilao(@PathVariable Long id) {
		try {
			Leilao leilao = leilaoRepository.findById(id).get();
			if (leilao == null) {
				return ResponseEntity.notFound().build();
			}
			leilaoRepository.delete(leilao);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/")
	public ResponseEntity<?> deleteLeilao() {
		return ResponseEntity.badRequest().build();
	}
}
