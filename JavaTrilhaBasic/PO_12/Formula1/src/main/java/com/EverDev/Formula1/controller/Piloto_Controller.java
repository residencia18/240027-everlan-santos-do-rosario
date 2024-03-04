package com.EverDev.Formula1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EverDev.Formula1.model.Piloto;
import com.EverDev.Formula1.util.LeitorCSV;

@RestController
public class Piloto_Controller {
	
	private List<Piloto> pilotos;
	private String vencedor = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">";
	private String retorno;
	public Piloto_Controller() throws IOException {
		vencedor += "<H1>Pilotos Formula 1</H1><br>";
		this.pilotos = LeitorCSV.listaPilotos();
	}
	
	@GetMapping("/todos")
	public String vencedor() throws IOException {
		vencedor += "<h2>Lista de todos os pilotos:</h2>";
		vencedor += "<table class=\"table table-striped\">";
		vencedor += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		this.pilotos.forEach(piloto -> {
			vencedor += "<tr><td>" + piloto.getNome() + "</td><td>" + piloto.getPais() + "</td><td>" + piloto.getVitorias() + "</td></tr>";
		});
		vencedor += "</table>";
		return vencedor;
	}
	
	@GetMapping("/brasileiros")
	public String brasileiros() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Pilotos Brasileiros:</h2>";
		retorno += "<table class=\"table\">";
		retorno += "<thead class=\"table-dark\">";
		retorno += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		retorno += "</thead>";
		pilotos.forEach(piloto -> {
			if (piloto.getPais().equalsIgnoreCase("Brasil")) {
				retorno += "<tr><td>" + piloto.getNome() + "</td><td>" + piloto.getPais() + "</td><td>" + piloto.getVitorias() + "</td></tr>";
			}
		});
		retorno += "</table>";
		return retorno;
	}
	
	@GetMapping("/top5")
	public String top5() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Top 5 dos pilotos com mais vitorias:</h2>";
		retorno += "<table class=\"table table-dark table-hover\">";
		retorno += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		pilotos.sort((p1, p2) -> p2.getVitorias() - p1.getVitorias());
		for (int i = 0; i < 5; i++) {
			retorno += "<tr><td>" + pilotos.get(i).getNome() + "</td><td>" + pilotos.get(i).getPais() + "</td><td>" + pilotos.get(i).getVitorias() + "</td></tr>";
		}
		retorno += "</table>";
		return retorno;
	}
	
	@GetMapping("/top10")
	public String top10() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Top 5 dos pilotos com mais vitorias:</h2>";
		retorno += "<table class=\"table table-striped table-hover\">";
		retorno += "<tr><th>Nome</th><th>Pais</th><th>Vitorias</th></tr>";
		pilotos.sort((p1, p2) -> p2.getVitorias() - p1.getVitorias());
		for (int i = 0; i < 10; i++) {
			retorno += "<tr><td>" + pilotos.get(i).getNome() + "</td><td>" + pilotos.get(i).getPais() + "</td><td>" + pilotos.get(i).getVitorias() + "</td></tr>";
		}
		retorno += "</table>";
		return retorno;
	}
	
	@GetMapping("/porPais")
	public String porPais() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Pilotos por Pais:</h2>";
		retorno += "<table class=\"table table-striped table-hover\">";
		retorno += "<tr><th>Pais</th><th>Vitorias</th></tr>";
		Map<String, Integer> vitoriasPorPais = getPorPais();
		for (Map.Entry<String, Integer> entry : vitoriasPorPais.entrySet()) {
			retorno += "<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>";
		}
		retorno += "</table>";
	    return retorno;
	}
	
	@GetMapping("/mediaporpais")
	public String mediaPorPais() throws IOException {
		retorno = vencedor;
		retorno += "<h2>Media de vitorias por Pais:</h2>";
		retorno += "<table class=\"table table-striped table-hover\">";
		retorno += "<tr><th>Pais</th><th>Media</th></tr>";
		Map<String, Double> mediaPorPais = getMediaPorPais();
		for (Map.Entry<String, Double> entry : mediaPorPais.entrySet()) {
			retorno += "<tr><td>" + entry.getKey() + "</td><td>" + String.format("%.2f", entry.getValue()).replace(",", ".") + "</td></tr>";
		}
		retorno += "</table>";
	    return retorno;
	}
	
	private Map<String, Integer> getPorPais() throws IOException {
	    Map<String, Integer> vitoriasPorPais = new HashMap<>();
	    for (Piloto piloto : pilotos) {
	        String pais = piloto.getPais();
	        int vitorias = piloto.getVitorias();

	        vitoriasPorPais.put(pais, vitoriasPorPais.getOrDefault(pais, 0) + vitorias);
	    }

	    // Ordena o mapa por número de vitórias (decrescente)
	    vitoriasPorPais = sortByValue(vitoriasPorPais);

	    return vitoriasPorPais;
	}

	private Map<String, Double> getMediaPorPais() throws IOException {
	    Map<String, Integer> vitoriasPorPais = getPorPais();
	    Map<String, Integer> vencedoresPorPais = getVencedoresPorPais();

	    Map<String, Double> mediaPorPais = new HashMap<>();
	    for (Map.Entry<String, Integer> entry : vitoriasPorPais.entrySet()) {
	        String pais = entry.getKey();
	        int vitorias = entry.getValue();
	        int vencedores = vencedoresPorPais.get(pais);

	        mediaPorPais.put(pais, (double) vitorias / vencedores);
	    }

	    // Ordena o mapa por média de vitórias (decrescente)
	    mediaPorPais = sortByValue(mediaPorPais);

	    return mediaPorPais;
	}
	
	private Map<String, Integer> getVencedoresPorPais() throws IOException {
	    Map<String, Integer> vencedoresPorPais = new HashMap<>();
	    for (Piloto piloto : pilotos) {
	        String pais = piloto.getPais();
	        vencedoresPorPais.put(pais, vencedoresPorPais.getOrDefault(pais, 0) + 1);
	    }

	    return vencedoresPorPais;
	}
	
	private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
	    list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

	    Map<K, V> result = new LinkedHashMap<>();
	    for (Map.Entry<K, V> entry : list) {
	        result.put(entry.getKey(), entry.getValue());
	    }

	    return result;
	}
}
