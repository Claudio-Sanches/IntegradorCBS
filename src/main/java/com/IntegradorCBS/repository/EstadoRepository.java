package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Estado;


public interface EstadoRepository extends CrudRepository<Estado, Long> {
		
	Estado findById(long id);
	
	Estado findBySigla(String sigla);

	// Query para a busca
	@Query(value = "select u from Estado u where u.descricao like %?1%")
	List<Estado> findBydescricao(String descricao);

}
