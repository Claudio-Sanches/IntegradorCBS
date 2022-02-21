package com.IntegradorCBS.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotEmpty;

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
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Cliente> clientes;
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Produto> produtos;
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Pedido> pedidos;
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Ssd> ssds;
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Memoria> memorias;
	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	private List<Carrinho> carrinhos;

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

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

	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}


}
