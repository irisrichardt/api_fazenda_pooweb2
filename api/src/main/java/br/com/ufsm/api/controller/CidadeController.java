package br.com.ufsm.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ufsm.api.controller.dto.CidadeDto;
import br.com.ufsm.api.controller.form.AtualizacaoCidadeForm;
import br.com.ufsm.api.controller.form.CidadeForm;
import br.com.ufsm.api.model.Cidade;
import br.com.ufsm.api.repository.CidadeRepository;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping
	public List<CidadeDto> lista(String nomeCidade) {
		if (nomeCidade == null) {
			List<Cidade> cidades = cidadeRepository.findAll();
			return CidadeDto.converter(cidades);
		} else {
			List<Cidade> cidades = cidadeRepository.caregarPorNomeDaCidade(nomeCidade);
			return CidadeDto.converter(cidades);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CidadeDto> detalhar(@PathVariable Long id) {
		Optional<Cidade> optional = cidadeRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new CidadeDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CidadeDto> cadastrar(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriBuilder) {
		Cidade cidade = form.converter(cidadeRepository);
		cidadeRepository.save(cidade);
		
		URI uri = uriBuilder.path("/cidades/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).body(new CidadeDto(cidade));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CidadeDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCidadeForm form) {
		Optional<Cidade> optional = cidadeRepository.findById(id);
		if (optional.isPresent()) {
			Cidade cidade = form.atualizar(id, cidadeRepository);
			return ResponseEntity.ok(new CidadeDto(cidade));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Cidade> optional = cidadeRepository.findById(id);
		if (optional.isPresent()) {
			cidadeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
