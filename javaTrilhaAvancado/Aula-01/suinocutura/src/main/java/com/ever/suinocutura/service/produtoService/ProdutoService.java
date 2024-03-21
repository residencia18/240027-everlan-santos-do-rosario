package com.ever.suinocutura.service.produtoService;

import java.util.List;

import com.ever.suinocutura.model.prouto.Produto;

public interface ProdutoService {
	
	Produto save(Produto produto);

    List<Produto> findAll();

    Produto findById(Long id);

    Produto update(Long id ,Produto produto);

    void deleteById(Long id);
}
