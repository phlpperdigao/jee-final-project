package com.javaee.philipe.projetofinalphilipe.services;

import java.util.List;

import com.javaee.philipe.projetofinalphilipe.domain.Comprador;

public interface CompradorService {
	List<Comprador> obterTodos();
	
	Comprador obterPorId(Long id);
	
	Comprador cadastrar(Comprador comprador);
	
	Comprador salvar(Long id, Comprador comprador);
	
	void removerPorId(Long id);
}
