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

import com.EverDev.Leilao.controller.dto.ConcorrenteDTO;
import com.EverDev.Leilao.controller.form.ConcorrenteForm;
import com.EverDev.Leilao.model.Concorrente;
import com.EverDev.Leilao.repository.ConcorrenteRepository;

@RestController
@RequestMapping("/concorrente/")
public class ConcorrenteController {
	
	@Autowired
	private ConcorrenteRepository concorrenteRepository;
	
	public ConcorrenteController() {}
	
	@GetMapping
	public ResponseEntity<?> getConcorrente() {
		try {
			List<ConcorrenteDTO> concorrentes = concorrenteRepository.findAll().stream().map(ConcorrenteDTO::new).collect(Collectors.toList());
			return ResponseEntity.ok(concorrentes);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getConcorrente(@PathVariable Long id) {
		try {
			ConcorrenteDTO concorrente = new ConcorrenteDTO(concorrenteRepository.getReferenceById(id));
			return ResponseEntity.ok(concorrente);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> postConcorrente(@RequestBody ConcorrenteForm form, UriComponentsBuilder uriBuilder) {
		try {
			Concorrente concorrente = new Concorrente(form.getNome(), form.getCpf());
			concorrenteRepository.save(concorrente);
			URI uri = uriBuilder.path("/concorrente/{id}").buildAndExpand(concorrente.getId()).toUri();
			return ResponseEntity.created(uri).body(new ConcorrenteDTO(concorrente));
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putConcorrente(@PathVariable Long id, @RequestBody ConcorrenteForm form) {
		try {
			Concorrente concorrente = concorrenteRepository.getReferenceById(id);
			concorrente.setNome(form.getNome());
			concorrente.setCpf(form.getCpf());
			concorrenteRepository.save(concorrente);
			return ResponseEntity.ok(new ConcorrenteDTO(concorrente));
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/")
	public ResponseEntity<?> putConcorrente() {
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteConcorrente(@PathVariable Long id) {
		try {
			Concorrente concorrente = concorrenteRepository.getReferenceById(id);
			if (concorrente == null) {
				return ResponseEntity.notFound().build();
			}			
			concorrenteRepository.delete(concorrente);
			return ResponseEntity.ok(new ConcorrenteDTO(concorrente));
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/")
	public ResponseEntity<?> deleteConcorrente() {
		return ResponseEntity.badRequest().build();
	}
	
}
