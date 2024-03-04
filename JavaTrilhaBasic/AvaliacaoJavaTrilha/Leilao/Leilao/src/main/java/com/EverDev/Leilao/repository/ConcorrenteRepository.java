package com.EverDev.Leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EverDev.Leilao.model.Concorrente;

public interface ConcorrenteRepository extends JpaRepository<Concorrente, Long> {

	Concorrente findByCpf(String cpf);
	
	Concorrente findByNome(String nome);
	
}
