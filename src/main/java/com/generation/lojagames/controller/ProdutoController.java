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

import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Produto>> getByGenero(@PathVariable String genero) {
		return ResponseEntity.ok(produtoRepository.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	@GetMapping("/precomenorque/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoMenorQue(@PathVariable Double preco){
		return ResponseEntity.ok(produtoRepository.findByPrecoLessThanEqual(preco));
	}
	
	@GetMapping("/precomaiorque/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoMaiorQue(@PathVariable Double preco){
		return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThanEqual(preco));
	}
	
	@GetMapping("/preco_inicial/{inicio}/preco_final/{fim}")
	public ResponseEntity<List<Produto>> getByPrecoIntervalo(@PathVariable Double inicio, @PathVariable Double fim){
		return ResponseEntity.ok(produtoRepository.findByPrecoBetween(inicio, fim));
	}
	
	@GetMapping("/disponiveis")
	public ResponseEntity<List<Produto>> getByProdutoDisponivel(){
		return ResponseEntity.ok(produtoRepository.findByDispTrue());
	}
	
	@GetMapping("/indisponiveis")
	public ResponseEntity<List<Produto>> getByProdutoIndisponivel(){
		return ResponseEntity.ok(produtoRepository.findByDispFalse());
	}

	@PostMapping
	public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resposta -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
