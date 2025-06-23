package com.mercadinho.produtos.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.mercadinho.produtos.model.enums.Categoria;
import com.mercadinho.produtos.model.enums.Marca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data

public class Produto {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	    name = "UUID",
	    strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "preco", precision = 18, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;
	
	@Column(name = "imagem_url", length = 255, nullable = false)
	private String imagemUrl;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "marca", nullable = false)
	private Marca marca;

	@Enumerated(EnumType.STRING)
	@Column(name = "categoria", nullable = false)
	private Categoria categoria;
}

