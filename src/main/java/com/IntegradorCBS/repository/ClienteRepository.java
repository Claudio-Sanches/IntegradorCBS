package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Cliente;
import com.IntegradorCBS.models.Estado;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	Iterable<Cliente> findByEstado(Estado id);

	Cliente findBySenha(String senha);

	Cliente findById(long id);
		
	Cliente findByNome(String nome);
		
	Cliente findByCpfcnpj(String cpfcnpj);

	// Query para a busca
	@Query(value = "select u from Cliente u where u.nome like %?1%")
	List<Cliente> findByNomes(String nome);
}
