package com.ever.suinocutura.service;

import java.util.List;
import com.ever.suinocutura.model.Produto;

public interface ProdutoService {
	
	Produto save(Produto produto);

    List<Produto> findAll();

    Produto findById(Long id);

    Produto update(Long id ,Produto produto);

    void deleteById(Long id);
}
