package com.ever.suinocutura.service.carrinhoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ever.suinocutura.model.carrinho.Carrinho;
import com.ever.suinocutura.repository.CarrinhoRepository;

public class CarrinhoServiceImpl implements CarrinhoService{
	
	@Autowired
	CarrinhoRepository carrinhoRepository;

	@Override
	public Carrinho save(Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}

	@Override
	public List<Carrinho> findAll() {
		return carrinhoRepository.findAll();
	}

	@Override
	public Carrinho findById(Long id) {
		return carrinhoRepository.findById(id).get();
	}

	@Override
	public Carrinho update(Long id, Carrinho carrinho) {
		
		return carrinhoRepository.save(carrinho);
	}

	@Override
	public void deleteById(Long id) {
		carrinhoRepository.deleteById(id);
	}
	
	

}
