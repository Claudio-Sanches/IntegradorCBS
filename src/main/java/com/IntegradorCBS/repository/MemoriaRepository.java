package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Memoria;
import com.IntegradorCBS.models.Estado;

public interface MemoriaRepository extends CrudRepository<Memoria, Long>{
	
	//Iterable<Memoria> findByEstado(Estado estado);
	
	//List<Memoria> findByDescricao(String descricao);

	Memoria findById(long id);

	// Query para a busca
	//@Query(value = "select u from Memoria u where u.descriçãoMemoria like %?1%")
	//List<Memoria> findBydescricaoMemoria(String descricaoMemoria);

}
