package br.dio.inter.appecommerce.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item_pedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto Produto;
	
	private int quantidade;
	
	private BigDecimal precoUnitario;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
}
