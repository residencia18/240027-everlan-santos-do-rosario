package com.controleacademico.controleacademico.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleacademico.controleacademico.controller.dto.UserDTO;
import com.controleacademico.controleacademico.modelo.User;

//@Controller
@RestController
public class UserController {
	private int valor = 68;
	@RequestMapping("/listarusuarios")
//	@ResponseBody
	public List<UserDTO> Listar() {
		List<UserDTO> list = new ArrayList<>();
		User u1 = new User("João", "joao@joao", "123");
		u1.setId(1);
		list.add(new UserDTO(u1));
		User u2 = new User("Maria", "maria@maria", "123");
		u2.setId(2);
		list.add(new UserDTO(u2));
		User u3 = new User("Pedro", "pedro@pedro", "123");
		u3.setId(3);
		list.add(new UserDTO(u3));
		User u4 = new User("Ana", "ana@ana", "123");
		u4.setId(4);
		list.add(new UserDTO(u4));
		User u5 = new User("Paulo", "paulo@paulo", "123");
		u5.setId(5);
		list.add(new UserDTO(u5));
		User u6 = new User("Paula", "paula@paula", "123");
		u6.setId(6);
		list.add(new UserDTO(u6));
		User u7 = new User("Paulo", "paulo@paulo", "123");
		u7.setId(7);
		list.add(new UserDTO(u7));
		return list;
	}
	
	@RequestMapping("/oi")
//	@ResponseBody
	public String oi() {
//		Dados do arquivo
		String s = "";
		try {
			s = Files.readString(Path.of("test.json"));	
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return s;
	}
	
	@RequestMapping("/valor")
	public int valor() {
		return valor;
	}
}
