package com.generation.lojagames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.generation.lojagames.model.Categoria;
import com.generation.lojagames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
//		return categoriaRepository.findById(id)
//				.map(resposta -> ResponseEntity.ok(resposta))
//				.orElse(ResponseEntity.notFound().build());
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
		return categoriaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
//		if (categoriaRepository.procurarCategoriaPorId(id) != null)
//			return ResponseEntity.ok().body(categoriaRepository.procurarCategoriaPorId(id));
//		return ResponseEntity.notFound().build();
//	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> getBytipo(@PathVariable String tipo) {
		if (!categoriaRepository.findAllByTipoContainingIgnoreCase(tipo).isEmpty())
			return ResponseEntity.ok(categoriaRepository.findAllByTipoContainingIgnoreCase(tipo));
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/tipo_start/{tipo}")
	public ResponseEntity<List<Categoria>> getByNomeStart(@PathVariable String tipo) {
		return ResponseEntity.ok(categoriaRepository.findAllByTipoStartingWith(tipo));
	}

	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria) {		
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.ok().body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return categoriaRepository.findById(id).map(resposta -> {
			categoriaRepository.deleteById(id);
			System.out.println(resposta.toString());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
