package io.github.brenovit.torrebras.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brenovit.torrebras.models.Colaborador;
import io.github.brenovit.torrebras.repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/colaboradores")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ColaboradorRestController {

	private final ColaboradorRepository repository;
		
	@GetMapping	
	public ResponseEntity<List<Colaborador>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}		

	@PostMapping
	public ResponseEntity<Colaborador> create(@Valid @RequestBody Colaborador product) {
		return ResponseEntity.ok(repository.save(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Colaborador> update(@PathVariable Long id, @Valid @RequestBody Colaborador curso) {
		curso.setId(id);
		return ResponseEntity.ok(repository.save(curso));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}