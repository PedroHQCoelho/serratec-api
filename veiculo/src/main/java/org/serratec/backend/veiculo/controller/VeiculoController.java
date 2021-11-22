package org.serratec.backend.veiculo.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.veiculo.domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")

public class VeiculoController {
	private static List<Veiculo> lista = new ArrayList<Veiculo>();
	
	static {
		lista.add(new Veiculo(1L, "Renault", "Sandero"));
		lista.add(new Veiculo(2L, "FIAT", "Uno"));
		lista.add(new Veiculo(3L, "Chevrolet", "Celta"));
		lista.add(new Veiculo(4L, "Ford", "Fiesta"));
		lista.add(new Veiculo(5L, "Mitsubishi", "Pajero"));
	}
	
	@GetMapping
	public List<Veiculo> listar(){
		return lista;
	}
	
	@GetMapping("{id}")
	public Veiculo buscar(@PathVariable Long id) {
		for (Veiculo veiculo : lista) {
			if(veiculo.getId().equals(id)) {
				return veiculo;
			}
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	}
	
	@DeleteMapping ("{id}")
	public void deletar(@PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getId().equals(id)) {
				lista.remove(i);
			}
		}
	}
	
	@PutMapping("{id}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				Veiculo v = new Veiculo(id, veiculo.getMarca(), veiculo.getModelo());
				lista.set(i, v);
				return v;
			}
		}
		return null;
	}
}
