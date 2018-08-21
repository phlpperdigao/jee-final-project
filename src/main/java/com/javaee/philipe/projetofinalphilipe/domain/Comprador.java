package com.javaee.philipe.projetofinalphilipe.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Comprador {
 	@Id
	private Long id;
	
	private String primeiroNome;
	
	private String sobrenome;
	
	private String endereco;
	
	private String email;
	
	@DBRef
	private Set<Acao> acoes = new HashSet<>();	
}