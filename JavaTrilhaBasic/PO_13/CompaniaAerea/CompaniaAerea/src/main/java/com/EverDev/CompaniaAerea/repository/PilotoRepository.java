package com.EverDev.CompaniaAerea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EverDev.CompaniaAerea.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Integer> {

	List<Piloto> findByNome(String nome);
	
}
