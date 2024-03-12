package com.ever.suinocutura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ever.suinocutura.model.Produto;
import com.ever.suinocutura.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Override
	public Produto save(Produto produto) {
		return repository.save(produto);
	}

	@Override
	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Produto> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public Produto update(Produto produto) {
		return repository.save(produto);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
