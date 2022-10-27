package com.IntegradorCBS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.IntegradorCBS.models.Tabela;

public interface TabelaRepository extends CrudRepository<Tabela, Long> {

    Tabela findById(long id);

    //TabelaPreco findByUF(String uf);

    //TabelaPreco findByAplicacao(String aplicacao);

    // Query para a busca
    //@Query(value = "select u from tabela u where u.id like %?1%")
    //List<Tabela> findByIds(String id);
}