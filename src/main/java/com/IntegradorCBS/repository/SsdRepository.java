package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Ssd;

public interface SsdRepository extends CrudRepository<Ssd, Long>{
	
	//Iterable<Ssd> findByEstado(Estado id);

	Ssd findById(long id);

	// Query para a busca
	@Query(value = "select u from Ssd u where u.descricao like %?1%")
	List<Ssd> findBydescricaoSsds(String descricao);

}
