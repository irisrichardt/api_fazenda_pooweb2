package br.com.ufsm.api.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ufsm.api.model.Cidade;
import br.com.ufsm.api.repository.CidadeRepository;

public class CidadeForm {

	
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	
	@NotNull @NotEmpty
	private String cep;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Cidade converter(CidadeRepository cidadeRepository) {
		
		return new Cidade(nome, cep);
	}
}
