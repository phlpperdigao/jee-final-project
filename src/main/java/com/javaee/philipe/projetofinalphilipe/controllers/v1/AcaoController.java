package com.javaee.philipe.projetofinalphilipe.controllers.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.philipe.projetofinalphilipe.domain.Acao;
import com.javaee.philipe.projetofinalphilipe.services.AcaoService;

@RestController
@RequestMapping(AcaoController.BASE_URL)
public class AcaoController {
	public static final String BASE_URL = "/api/v1/acoes";
	private final AcaoService acaoService;
	
	public AcaoController(AcaoService acaoService) {
		this.acaoService = acaoService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Acao> obterTodas(){
		return acaoService.obterTodas();
	}
	
	@GetMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public Acao obterPorId(@PathVariable Long id){
		return acaoService.obterPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Acao cadastrar(@RequestBody Acao acao){
		return acaoService.cadastrar(acao);
	}
	
	@PutMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public Acao atualizar(@PathVariable Long id, @RequestBody Acao acao){
		return acaoService.salvar(id, acao);
	}
}