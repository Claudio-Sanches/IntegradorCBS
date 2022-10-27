package com.IntegradorCBS.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

@Entity
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	private String sigla;

	@NotEmpty
	private String descricao;

	@NonNull
	private BigDecimal Fator;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Cliente> clientes;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Produto> produtos;

	//@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	//private List<Order> orders;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Ssd> ssds;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Memoria> memorias;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Karrinho> karrinhos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getFator() {
		return Fator;
	}

	public void setFator(BigDecimal fator) {
		Fator = fator;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	//public List<Order> getOrders() {
	//	return orders;
	//}

	//public void setOrders(List<Order> orders) {
	//	this.orders = orders;
	//}

	public List<Ssd> getSsds() {
		return ssds;
	}

	public void setSsds(List<Ssd> ssds) {
		this.ssds = ssds;
	}

	public List<Memoria> getMemorias() {
		return memorias;
	}

	public void setMemorias(List<Memoria> memorias) {
		this.memorias = memorias;
	}

	public List<Karrinho> getKarrinhos() {
		return karrinhos;
	}

	public void setKarrinhos(List<Karrinho> karrinhos) {
		this.karrinhos = karrinhos;
	}

}
