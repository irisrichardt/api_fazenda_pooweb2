package br.com.ufsm.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ufsm.api.model.Cidade;


public class CidadeDto {

	private Long id;
	private String nome;
	private String cep;
	
	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.cep = cidade.getCep();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCep() {
		return cep;
	}

	public static List<CidadeDto> converter(List<Cidade> cidades) {
		return cidades.stream().map(CidadeDto::new).collect(Collectors.toList());
	}
}
