package br.com.ufsm.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ufsm.api.model.Fazenda;

public class FazendaDto {

	private Long id;
	private String proprietario;
	private String hectares;
	private String descricao;
	private String cidade;
	
	public FazendaDto(Fazenda fazenda) {
		this.id = fazenda.getId();
		this.proprietario = fazenda.getProprietario();
		this.hectares = fazenda.getHectares();
		this.descricao = fazenda.getDescricao();
		this.cidade = fazenda.getCidade().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public String getHectares() {
		return hectares;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public static List<FazendaDto> converter(List<Fazenda> fazendas) {
		return fazendas.stream().map(FazendaDto::new).collect(Collectors.toList());
	}
}
