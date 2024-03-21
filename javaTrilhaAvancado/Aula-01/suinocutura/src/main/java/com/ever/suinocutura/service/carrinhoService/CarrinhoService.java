package com.ever.suinocutura.service.carrinhoService;

import java.util.List;

import com.ever.suinocutura.model.carrinho.Carrinho;

public interface CarrinhoService {
	Carrinho save(Carrinho carrinho);
	
	List<Carrinho> findAll();
	
	Carrinho findById(Long id);
	
	Carrinho update(Long id, Carrinho carrinho);
	
	void deleteById(Long id);

}
