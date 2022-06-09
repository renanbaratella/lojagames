package com.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojagames.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	
//	@Query(value = "select * from tb_categorias c where c.id = :id", nativeQuery = true)
//	public Categoria procurarCategoriaPorId(Long id);
	
	public List<Categoria> findAllByTipoContainingIgnoreCase(@Param("tipo") String tipo);
	public List<Categoria> findAllByTipoStartingWith(String tipo);	

	
}
