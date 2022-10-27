package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Opedido;
import com.IntegradorCBS.models.Estado;

public interface OpedidoRepository extends CrudRepository<Opedido, Long> {

	Iterable<Opedido> findByEstado(Estado id);

	Opedido findById(long id);

	Opedido findByDescricao(String descricao);

	// Query para a busca
	@Query(value = "select u from Pedido u where u.cliente like %?1%")
	List<Opedido> findByCliente(String cliente);

    Object findBydescOpedido(String buscarGes);
}
