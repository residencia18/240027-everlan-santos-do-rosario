package com.EverDev.CompaniaAerea.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EverDev.CompaniaAerea.controller.dto.AeroportoDTO;
import com.EverDev.CompaniaAerea.model.Aeroporto;
import com.EverDev.CompaniaAerea.repository.AeroportoRepository;

@RestController
@RequestMapping("/aeroportos/")
public class AeroportoController {
	
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@GetMapping
	public List<AeroportoDTO> getAeroportos(String icao) {
		
		List<Aeroporto> aeroportos;
		if (icao != null) {
			aeroportos = aeroportoRepository.findByICAO(icao); 
		}else {
			aeroportos = aeroportoRepository.findAll();
		}
		
		return aeroportos.stream().map(AeroportoDTO::new).collect(Collectors.toList());
	}
}
