package com.ever.suinocutura.service;

import java.util.List;
import java.util.Optional;

import com.ever.suinocutura.model.Produto;

public interface ProdutoService {
	
	Produto save(Produto produto);

    List<Produto> findAll();

    Optional<Produto> findById(Long id);

    Produto update(Produto produto);

    void deleteById(Long id);
}
