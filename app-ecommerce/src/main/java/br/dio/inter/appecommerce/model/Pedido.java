package br.dio.inter.appecommerce.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date dataHoraPedido;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itensPedido;
	
	@Embedded
	private Endereco enderecoEntrega;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
	private BigDecimal precoTotal;
	
	private BigDecimal taxaEnvio;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHoraPedido() {
		return dataHoraPedido;
	}

	public void setDataHoraPedido(Date dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public BigDecimal getTaxaEnvio() {
		return taxaEnvio;
	}

	public void setTaxaEnvio(BigDecimal taxaEnvio) {
		this.taxaEnvio = taxaEnvio;
	}
	
	
}
