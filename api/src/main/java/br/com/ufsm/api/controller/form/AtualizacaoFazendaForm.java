package br.com.ufsm.api.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ufsm.api.model.Fazenda;
import br.com.ufsm.api.repository.FazendaRepository;

public class AtualizacaoFazendaForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String proprietario;
	
	@NotNull @NotEmpty @Length(min = 2)
	private String hectares;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	
	
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getHectares() {
		return hectares;
	}

	public void setHectares(String hectares) {
		this.hectares = hectares;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fazenda atualizar(Long id, FazendaRepository fazendaRepository) {
		Fazenda fazenda = fazendaRepository.getOne(id);
		
		fazenda.setProprietario(this.proprietario);
		fazenda.setHectares(this.hectares);
		fazenda.setDescricao(this.descricao);	
		
		return fazenda;
	}
}
