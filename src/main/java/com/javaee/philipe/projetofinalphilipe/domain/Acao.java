package com.javaee.philipe.projetofinalphilipe.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao {
	@Id
	private Long id;
	
	private Long compradorId;
	
	private double valorInicial;
	
	private double valorAtual;
	
	private Date dataCompra;	
}