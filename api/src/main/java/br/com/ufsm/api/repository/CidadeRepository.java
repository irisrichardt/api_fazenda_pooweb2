package br.com.ufsm.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ufsm.api.model.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	Cidade findByNome(String nome);
		
	@Query("SELECT t FROM Cidade t WHERE t.nome = :nomeCidade")
	List<Cidade> caregarPorNomeDaCidade(@Param("nomeCidade")String nomeCidade);
		
}
	

