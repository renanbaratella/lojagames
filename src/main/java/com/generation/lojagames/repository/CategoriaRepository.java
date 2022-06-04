package com.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.lojagames.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findAllByTipoContainingIgnoreCase(@Param("plataforma") String tipo);
	public List<Categoria> findAllByTipoStartingWith(@Param("plataforma") String tipo);	

	
}
