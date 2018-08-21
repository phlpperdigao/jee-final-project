package com.javaee.philipe.projetofinalphilipe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.philipe.projetofinalphilipe.domain.Acao;

@Repository
public interface AcaoRepository extends MongoRepository<Acao, Long> {
	
}