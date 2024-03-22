package com.ever.suinocutura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ever.suinocutura.model.carrinho.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
	

}
