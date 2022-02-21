package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Pedido;
import com.IntegradorCBS.models.Estado;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	Iterable<Pedido> findByEstado(Estado id);

	Pedido findById(long id);

	Pedido findByDescricao(String descricao);

	// Query para a busca
	@Query(value = "select u from Pedido u where u.cliente like %?1%")
	List<Pedido> findByCliente(String cliente);

}
