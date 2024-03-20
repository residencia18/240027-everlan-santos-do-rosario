package com.ever.suinocutura.service.produtoService;

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
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);		
		return obj.get();
	}

	@Override
	public Produto update(Long id ,Produto produto) {
		Produto obj = repository.getReferenceById(id);
		obj.setName(produto.getName());
		obj.setAmount(produto.getAmount());
		obj.setValue(produto.getValue());
		obj.setDescription(produto.getDescription());
		return repository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
