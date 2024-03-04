package com.EverDev.Formula1.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.EverDev.Formula1.model.Piloto;

public class LeitorCSV {
	private static final String ARQUIVO = "src/main/resources/arquivos/pilotos.csv";
	private static final String SEPARADOR = ";";

	public static List<Piloto> listaPilotos() throws IOException {
		List<Piloto> lista = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
			String linha;
			int cont = 1;
			while ((linha = br.readLine()) != null) {
				if (cont == 1) {
					cont++;
					continue;
				} else {
					String[] dados = linha.split(SEPARADOR);
					lista.add(new Piloto(dados[1], dados[0], Integer.parseInt(dados[2])));
				}
			}
		}

		return lista;
	}
}
