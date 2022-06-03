package com.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.lojagames.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findAllByPlataformaContainingIgnoreCase(@Param("plataforma") String plataforma);
	public List<Categoria> findAllByPlataformaStartingWith(@Param("plataforma") String plataforma);	

	
}
