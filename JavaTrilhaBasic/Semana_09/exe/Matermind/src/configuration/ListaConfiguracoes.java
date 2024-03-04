package configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListaConfiguracoes {

	public static final String CAMINHO = "." + File.separator + "Arquivos" + File.separator + "configuracoes.json";

	ArrayList<Configuracao> configuracaos;
	String caminho;

	public ListaConfiguracoes() {
		this.configuracaos = new ArrayList<>();
		this.caminho = CAMINHO;
		System.out.println(caminho);
	}

	public void addConfiguracao(Configuracao configuracao) throws IOException {
		if (this.configuracaos.size() == 0) {
			this.configuracaos.add(configuracao);
			salvar();
		} else {
			if (VerificarRecuperacao(configuracao.getNome())) {
				throw new IllegalArgumentException("Nome de configuração já existe");
			} else{
				this.configuracaos.add(configuracao);
				salvar();
			}
		}

	}

	public boolean VerificarRecuperacao(String Nome) {
		for (Configuracao configuracao : configuracaos) {
			if (configuracao.getNome().equals(Nome)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Configuracao> getLista() {
		return this.configuracaos;
	}

	protected void salvar() throws IOException {
		File file = new File(caminho);
		FileWriter fileOut = new FileWriter(file);
		
		JSONArray jsons = geraJson(this.configuracaos);
		
		fileOut.write(jsons.toString());
		
		fileOut.close();
	}

	private static JSONArray geraJson(ArrayList<Configuracao> configuracaos) {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Configuracao c : configuracaos) {
			json.put("Nome", c.getNome());
			json.put("Alfabeto", c.getAlfabeto());
			json.put("TamanhoSenha", c.getTamanhoSenha());
			json.put("MaxTentativas", c.getMaxTentativas());
			array.put(json);
		}
		return array;
	}

	protected void recuperar() {

	}
}
