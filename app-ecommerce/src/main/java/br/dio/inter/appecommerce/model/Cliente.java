package br.dio.inter.appecommerce.model;

import java.util.List;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	@Embedded
	private Endereco endereco;
	
}
