package br.com.ufsm.api.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ufsm.api.model.Cidade;
import br.com.ufsm.api.model.Fazenda;
import br.com.ufsm.api.repository.CidadeRepository;

public class FazendaForm {

	@NotNull @NotEmpty @Length(min = 3)
	private String proprietario;
	
	@NotNull @NotEmpty
	private String hectares;
	
	@NotNull @NotEmpty
	private String descricao;
	
	@NotNull @NotEmpty
	private String cidade;
	
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

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Fazenda converter(CidadeRepository cidadeRepository) {
		Cidade cidade = cidadeRepository.findByNome(this.cidade);

		return new Fazenda(proprietario, hectares, descricao, cidade);
	}

}
