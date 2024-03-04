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

import com.EverDev.Leilao.controller.dto.LanceDTO;
import com.EverDev.Leilao.controller.form.LanceForm;
import com.EverDev.Leilao.model.Concorrente;
import com.EverDev.Leilao.model.Lance;
import com.EverDev.Leilao.model.Leilao;
import com.EverDev.Leilao.repository.ConcorrenteRepository;
import com.EverDev.Leilao.repository.LanceRespository;
import com.EverDev.Leilao.repository.LeilaoRepository;

@RestController
@RequestMapping("/lance/")
public class LanceController {
	
	@Autowired
	private LanceRespository respository;
	@Autowired
	private LeilaoRepository leilaoRepository;
	@Autowired
	private ConcorrenteRepository concorrenteRepository;
	
	public LanceController() {}
	
	@GetMapping
	public ResponseEntity<?> getLance() {
		try {
			List<LanceDTO> lances = respository.findAll().stream().map(LanceDTO::new).collect(Collectors.toList());
			return ResponseEntity.ok(lances);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLance(@PathVariable Long id) {
		try {
			LanceDTO lances = new LanceDTO(respository.getReferenceById(id));
			return ResponseEntity.ok(lances);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> postLance(@RequestBody LanceForm form, UriComponentsBuilder uriBuilder) {
		try {
			Lance lance = new Lance();
			lance.setValor(form.getValor());
			Leilao leilao = leilaoRepository.getReferenceById(form.getId_Leilao());
			if (leilao == null) {
				return ResponseEntity.badRequest().build();
			}else {
				lance.setLeilao(leilao);
			}
			if(!leilao.isStatus()) {
				return ResponseEntity.notFound().build();
			}
			Concorrente concorrente = concorrenteRepository.getReferenceById(form.getId_Concorrente());
			if (concorrente == null) {
				return ResponseEntity.badRequest().build();
			}else {
				lance.setConcorrente(concorrente);
			}
			respository.save(lance);
			URI uri = uriBuilder.path("/lance/{id}").buildAndExpand(lance.getId()).toUri();
			return ResponseEntity.created(uri).body(new LanceDTO(lance));
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putLance(@PathVariable Long id, @RequestBody LanceForm form) {
		try {
			Lance lance = respository.getReferenceById(id);
			lance.setValor(form.getValor());
			Leilao leilao = leilaoRepository.getReferenceById(form.getId_Leilao());
			if (leilao == null) {
				return ResponseEntity.badRequest().build();
			}else {
				lance.setLeilao(leilao);
			}
			if(!leilao.isStatus()) {
				return ResponseEntity.notFound().build();
			}
			Concorrente concorrente = concorrenteRepository.getReferenceById(form.getId_Concorrente());
			if (concorrente == null) {
				return ResponseEntity.badRequest().build();
			}else {
				lance.setConcorrente(concorrente);
			}
			respository.save(lance);
			return ResponseEntity.ok(new LanceDTO(lance));
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<?> putLance() {
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLance(@PathVariable Long id) {
		try {
			Lance lance = respository.findById(id).get();
			if (lance == null) {
				return ResponseEntity.notFound().build();
			}
			respository.delete(lance);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/")
	public ResponseEntity<?> deleteLance() {
		return ResponseEntity.badRequest().build();
	}
}
