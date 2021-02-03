package br.com.ufsm.api.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ufsm.api.model.Cidade;
import br.com.ufsm.api.repository.CidadeRepository;

public class AtualizacaoCidadeForm {

	@NotNull @NotEmpty @Length(min = 2)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 2)
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
	
	public Cidade atualizar(Long id, CidadeRepository cidadeRepository) {
		Cidade cidade = cidadeRepository.getOne(id);
		
		cidade.setNome(this.nome);
		cidade.setCep(this.cep);
			
		return cidade;
	}
}
