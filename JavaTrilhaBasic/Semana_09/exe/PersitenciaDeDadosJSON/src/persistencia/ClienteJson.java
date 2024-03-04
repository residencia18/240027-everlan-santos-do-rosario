package persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Cliente;

public class ClienteJson {
	public static void SalvarCliente(ArrayList<Cliente> cliente, String arquivo) throws IOException {
		try {
			FileOutputStream file = new FileOutputStream(arquivo+".json");
			JSONArray jsons = geraStringJson(cliente);
			
			file.write(jsons.toString().getBytes());
			
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static JSONArray geraStringJson(ArrayList<Cliente> cliente) {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Cliente c : cliente) {
			json.put("Nome",c.getNome());
			json.put("CPF",c.getCpf());
			json.put("CNH",c.getCnh());
			array.put(json);
		}
		return array;
	}
}
