package com.javaee.philipe.projetofinalphilipe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.philipe.projetofinalphilipe.domain.Comprador;

@Repository
public interface CompradorRepository  extends MongoRepository<Comprador, Long> {

}