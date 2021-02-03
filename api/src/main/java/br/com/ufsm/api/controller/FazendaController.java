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

import br.com.ufsm.api.controller.dto.FazendaDto;
import br.com.ufsm.api.controller.form.AtualizacaoFazendaForm;
import br.com.ufsm.api.controller.form.FazendaForm;
import br.com.ufsm.api.model.Fazenda;
import br.com.ufsm.api.repository.CidadeRepository;
import br.com.ufsm.api.repository.FazendaRepository;

@RestController
@RequestMapping("/fazendas")
public class FazendaController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private FazendaRepository fazendaRepository;

	@GetMapping
	public List<FazendaDto> lista(String nomeCidade) {
		if (nomeCidade == null) {
			List<Fazenda> fazendas = fazendaRepository.findAll();
			return FazendaDto.converter(fazendas);
		} else {
			List<Fazenda> fazendas = fazendaRepository.findByCidadeNome(nomeCidade);
			return FazendaDto.converter(fazendas);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FazendaDto> detalhar(@PathVariable Long id) {
		Optional<Fazenda> optional = fazendaRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new FazendaDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<FazendaDto> cadastrar(@RequestBody @Valid FazendaForm form, UriComponentsBuilder uriBuilder) {
		Fazenda fazenda = form.converter(cidadeRepository);
		fazendaRepository.save(fazenda);
		
		URI uri = uriBuilder.path("/fazendas/{id}").buildAndExpand(fazenda.getId()).toUri();
		return ResponseEntity.created(uri).body(new FazendaDto(fazenda));
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FazendaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoFazendaForm form) {
		Optional<Fazenda> optional = fazendaRepository.findById(id);
		if (optional.isPresent()) {
			Fazenda fazenda = form.atualizar(id, fazendaRepository);
			return ResponseEntity.ok(new FazendaDto(fazenda));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Fazenda> optional = fazendaRepository.findById(id);
		if (optional.isPresent()) {
			fazendaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
