package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Estado;
import com.IntegradorCBS.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	Iterable<Produto> findByEstado(Estado id);

	Produto findById(long id);

	Produto findByDescricao(String descricao);

	// Query para a busca
	@Query(value = "select u from Produto u where u.aplicacao like %?1%")
	List<Produto> findByaplicacao(String aplicacao);

}