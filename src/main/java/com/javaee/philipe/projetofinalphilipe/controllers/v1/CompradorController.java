package com.javaee.philipe.projetofinalphilipe.controllers.v1;

import java.util.List;

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

import com.javaee.philipe.projetofinalphilipe.domain.Comprador;
import com.javaee.philipe.projetofinalphilipe.services.CompradorService;

@RestController
@RequestMapping(CompradorController.BASE_URL)
public class CompradorController {
	public static final String BASE_URL = "/api/v1/compradores";
 	private final CompradorService compradorService;
	
	public CompradorController(CompradorService compradorService) {
	this.compradorService = compradorService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Comprador> obterTodos(){
		return compradorService.obterTodos();
	}
	
	@GetMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public Comprador obterPorId(@PathVariable Long id){
	return compradorService.obterPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Comprador cadastrar(@RequestBody Comprador comprador){
		return compradorService.cadastrar(comprador);
	}
	
	@PutMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public Comprador atualizar(@PathVariable Long id, @RequestBody Comprador comprador){
		return compradorService.salvar(id, comprador);
	}
	
	@DeleteMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public void remover(@PathVariable Long id){
		compradorService.removerPorId(id);
	}
}