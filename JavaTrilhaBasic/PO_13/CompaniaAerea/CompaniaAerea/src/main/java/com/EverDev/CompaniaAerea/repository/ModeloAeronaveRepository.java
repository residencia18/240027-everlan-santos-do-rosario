package com.EverDev.CompaniaAerea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EverDev.CompaniaAerea.model.ModeloAeronave;

public interface ModeloAeronaveRepository extends JpaRepository<ModeloAeronave, Long> {
	
	List<ModeloAeronave> findByFabricante(String fabricante);

	List<ModeloAeronave> findByNome(String nome);
	
}
