package br.com.ufsm.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufsm.api.model.Fazenda;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

	List<Fazenda> findByCidadeNome(String nomeCidade);
}
