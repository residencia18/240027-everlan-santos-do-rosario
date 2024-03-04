package com.redesocial.redesocial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	String view = "";
	
	public HelloController() {
		view = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">";
	}
	
	@GetMapping
	public String home() {
		String retorno = view;
		retorno += "<div class=\"container\">";
		retorno += "<div class=\"row\">";
		retorno += "<div class=\"col\">";
		retorno += "<h1>Rede Social</h1>";
		retorno += "</div>";
		retorno += "</div>";
		retorno += "<div class=\"row\">";
		retorno += "<div class=\"col\">";
		retorno += "<a class=\"btn btn-primary\" href=\"/\">Home</a>";
		retorno += "<a class=\"btn btn-primary\" href=\"/usuario/\">Listar Usuários</a>";
		retorno += "</div>";
		retorno += "</div>";
		retorno += "</div>";
		return retorno;
	}
}
