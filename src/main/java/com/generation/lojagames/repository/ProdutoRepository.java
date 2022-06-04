package com.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.lojagames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByPlataformaContainingIgnoreCase(@Param("plataforma") String plataforma);
	public List<Produto> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	public List<Produto> findByPrecoLessThanEqual(@Param("preco") Double preco);
	public List<Produto> findByPrecoGreaterThanEqual(@Param("preco") Double preco);
	public List<Produto> findByPrecoBetween(@Param("preco") Double inicio, @Param("preco2") Double fim);
	public List<Produto> findByDispTrue();
	public List<Produto> findByDispFalse();
	
}
