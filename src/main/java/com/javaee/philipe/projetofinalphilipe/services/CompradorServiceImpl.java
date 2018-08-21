package com.javaee.philipe.projetofinalphilipe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.philipe.projetofinalphilipe.domain.Comprador;
import com.javaee.philipe.projetofinalphilipe.repositories.CompradorRepository;

@Service
public class CompradorServiceImpl implements CompradorService {
	private CompradorRepository compradorRepository;
	
	public CompradorServiceImpl(CompradorRepository compradorRepository) {
		this.compradorRepository = compradorRepository;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removerPorId(Long id) {
		compradorRepository.deleteById(id);
	}

	@Override
	public Comprador obterPorId(Long id) {
		Optional<Comprador> comprador = compradorRepository.findById(id);

        if (!comprador.isPresent()) {
            throw new IllegalArgumentException("Comprador nao encontrado para o ID: " + id.toString() );
        }
        return comprador.get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Comprador cadastrar(Comprador comprador) {
		return compradorRepository.save(comprador);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Comprador salvar(Long id, Comprador comprador) {
		comprador.setId(id);
		Comprador compradorSalvo = compradorRepository.save(comprador);
		return compradorSalvo;
	}

	@Override
	public List<Comprador> obterTodos() {
		List<Comprador> compradores = new ArrayList<>();
		this.compradorRepository.findAll().iterator().forEachRemaining(compradores::add);
		return compradores;
		
	}
}