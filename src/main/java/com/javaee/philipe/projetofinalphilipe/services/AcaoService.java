package com.javaee.philipe.projetofinalphilipe.services;

import java.util.List;
import com.javaee.philipe.projetofinalphilipe.domain.Acao;

public interface AcaoService {
	List<Acao> obterTodas();
	
	Acao obterPorId(Long id);
	
	Acao cadastrar(Acao acao);
	
	Acao salvar(Long id, Acao acao);
}
