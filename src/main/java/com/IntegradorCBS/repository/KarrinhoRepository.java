package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Karrinho;
import com.IntegradorCBS.models.Estado;

public interface KarrinhoRepository extends CrudRepository<Karrinho, Long>{

    Iterable<Karrinho> findByEstado(Estado id);

    Karrinho findById(long id);

    // Query para a busca
    @Query(value = "select u from Karrinho u where u.cliente like %?1%")
    List<Karrinho> findByclienteKarrinho(String cliente);

}

