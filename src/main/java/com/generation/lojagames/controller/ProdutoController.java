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
import com.generation.lojagames.repository.CategoriaRepository;
import com.generation.lojagames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	//procurar pelo nome do jogo(titulo)
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(produtoRepository.findAllByPlataformaContainingIgnoreCase(titulo));
	}
	
	// procurar pela plataforma se é ps4, ps5...

	@GetMapping("/plataforma/{plataforma}")
	public ResponseEntity<List<Produto>> getByplataforma(@PathVariable String plataforma) {
		return ResponseEntity.ok(produtoRepository.findAllByPlataformaContainingIgnoreCase(plataforma));
	}

	// filtar por preco menor que
	
	@GetMapping("/precomenorque/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoMenorQue(@PathVariable Double preco) {
		return ResponseEntity.ok(produtoRepository.findByPrecoLessThanEqual(preco));
	}

	
	// filtar por preco maior que
	
	@GetMapping("/precomaiorque/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoMaiorQue(@PathVariable Double preco) {
		return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThanEqual(preco));
	}

	// filtrar por intervalo de preços
	
	@GetMapping("/preco_inicial/{inicio}/preco_final/{fim}")
	public ResponseEntity<List<Produto>> getByPrecoIntervalo(@PathVariable Double inicio, @PathVariable Double fim) {
		return ResponseEntity.ok(produtoRepository.findByPrecoBetween(inicio, fim));
	}

	// verificar produtos disponiveis para compra
	
	@GetMapping("/disponiveis")
	public ResponseEntity<List<Produto>> getByProdutoDisponivel() {
		return ResponseEntity.ok(produtoRepository.findByDispTrue());
	}

	// ver produtos indisponiveis no momento
	
	@GetMapping("/indisponiveis")
	public ResponseEntity<List<Produto>> getByProdutoIndisponivel() {
		return ResponseEntity.ok(produtoRepository.findByDispFalse());
	}

	@PostMapping
	public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {
		if (produtoRepository.existsById(produto.getId())) {
			return categoriaRepository.findById(produto.getCategoria().getId())
					.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)))
					.orElse(ResponseEntity.badRequest().build());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resposta -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
