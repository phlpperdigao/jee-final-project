package com.javaee.philipe.projetofinalphilipe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.philipe.projetofinalphilipe.domain.Comprador;
import com.javaee.philipe.projetofinalphilipe.domain.Acao;
import com.javaee.philipe.projetofinalphilipe.email.EmailSender;
import com.javaee.philipe.projetofinalphilipe.repositories.CompradorRepository;
import com.javaee.philipe.projetofinalphilipe.repositories.AcaoRepository;

@Service
public class AcaoServiceImpl implements AcaoService{
	
	private AcaoRepository acaoRepository;
	private CompradorRepository compradorRepository;


	public AcaoServiceImpl(AcaoRepository acaoRepository,CompradorRepository compradorRepository) {
		this.acaoRepository = acaoRepository;
		this.compradorRepository = compradorRepository;
	}


	@Override
	public Acao obterPorId(Long id) {
		Optional<Acao> acao = acaoRepository.findById(id);

		if (!acao.isPresent()) {
			throw new IllegalArgumentException("Acao nao encontrada para o ID: " + id.toString() );
		}
		return acao.get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao cadastrar(Acao acao) {
		return acaoRepository.save(acao);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao salvar(Long id, Acao acao) {
		acao.setId(id);
		Acao acaoAntiga = obterPorId(id);
		if (acao.getCompradorId()!=acaoAntiga.getCompradorId()) {
			Comprador compradorAntigo = compradorRepository.findById(acaoAntiga.getCompradorId()).get();
			EmailSender.send(compradorAntigo.getEmail(),
					EmailSender.ASSUNTO_SUCESSO_VENDA ,
					EmailSender.CORPO_SUCESSO_VENDA);
			Comprador novoComprador = compradorRepository.findById(acao.getCompradorId()).get();
			EmailSender.send(novoComprador.getEmail(),
					EmailSender.ASSUNTO_SUCESSO_AQUISICAO ,
					EmailSender.CORPO_SUCESSO_AQUISICAO);
		}
		Acao acaoSalva = acaoRepository.save(acao);
		return acaoSalva;
	}

	@Override
	public List<Acao> obterTodas() {
		List<Acao> acoes = new ArrayList<>();
		this.acaoRepository.findAll().iterator().forEachRemaining(acoes::add);
		return acoes;

	}
}
