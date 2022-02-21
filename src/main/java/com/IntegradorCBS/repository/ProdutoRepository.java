package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Estado;
import com.IntegradorCBS.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	//Iterable<Produto> findByEstado(Estado id);

	Produto findById(long id);

	// Query para a busca
	//@Query(value = "select u from Produto u where u.descricaoProduto like %?1%")
	//List<Produto> findBydescricaoProduto(String descricaoProduto);

}
