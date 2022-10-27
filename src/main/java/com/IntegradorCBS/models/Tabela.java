package com.IntegradorCBS.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@Entity
public class Tabela {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String uf;

    @NotEmpty
    private String aplicacao;

    @NotEmpty
    private String descricao;

    @NonNull
    private BigDecimal valor;

    @NotEmpty
    private String descricaossd;

    @NonNull
    private BigDecimal valorssd;

    @NotEmpty
    private String descricaomemoria;

    @NonNull
    private BigDecimal valormemoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricaossd() {
        return descricaossd;
    }

    public void setDescricaossd(String descricaossd) {
        this.descricaossd = descricaossd;
    }

    public BigDecimal getValorssd() {
        return valorssd;
    }

    public void setValorssd(BigDecimal valorssd) {
        this.valorssd = valorssd;
    }

    public String getDescricaomemoria() {
        return descricaomemoria;
    }

    public void setDescricaomemoria(String descricaomemoria) {
        this.descricaomemoria = descricaomemoria;
    }

    public BigDecimal getValormemoria() {
        return valormemoria;
    }

    public void setValormemoria(BigDecimal valormemoria) {
        this.valormemoria = valormemoria;
    }

}

