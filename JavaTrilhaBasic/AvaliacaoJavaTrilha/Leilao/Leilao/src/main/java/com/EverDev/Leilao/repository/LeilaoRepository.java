package com.EverDev.Leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EverDev.Leilao.model.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

}
