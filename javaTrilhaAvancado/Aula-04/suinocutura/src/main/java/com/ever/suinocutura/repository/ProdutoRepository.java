package com.ever.suinocutura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ever.suinocutura.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
}
