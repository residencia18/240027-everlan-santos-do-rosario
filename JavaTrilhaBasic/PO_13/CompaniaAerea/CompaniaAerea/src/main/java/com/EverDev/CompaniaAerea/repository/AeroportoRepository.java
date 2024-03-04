package com.EverDev.CompaniaAerea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EverDev.CompaniaAerea.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {

	List<Aeroporto> findByICAO(String icao);
}
