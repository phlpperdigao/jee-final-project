package com.javaee.philipe.projetofinalphilipe.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javaee.philipe.projetofinalphilipe.domain.Acao;
import com.javaee.philipe.projetofinalphilipe.repositories.AcaoRepository;

@Component
@Profile({"dev", "prod"})
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AcaoRepository acaoRepository;
	
	public ApplicationBootstrap(AcaoRepository acaoRepository) {
		this.acaoRepository = acaoRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if (acaoRepository.count() == 0L) {
			acaoRepository.deleteAll();
			carregarCategorias();
		}
	}
	
	private void carregarCategorias() {
        Acao acao = new Acao();
        acao.setValorAtual(124);
        acaoRepository.save(acao);
	}
}