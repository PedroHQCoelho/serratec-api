package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello() {
		return "Olá Mundo";
	}
	
	@GetMapping("/ola")
	public String ola() {
		return "Olá pessoas quem vos fala sou eu Maicon Küster, e sejam bem vindos a mais um vídeo no canal favorito do PewDiePie";
	}
	
	@GetMapping("/salve")
	public String salve() {
		return "Salve Salve, Família";
	}
	
	@GetMapping("/maiuscula")
	public String maiuscula(@RequestParam String valor) {
		return valor.toUpperCase();
	}
}
