package com.br.sicc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTOS")
public class Produtos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO")
	private Integer codigo;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="ESTOQUE")
	private Integer qtdDisponivel;
	
	@Column(name="VALOR")
	private Double valor;
	
	@ManyToOne(targetEntity=TipoProduto.class)
	@JoinColumn(name="TIPO_PRODUTOS_CODIGO", referencedColumnName="CODIGO")
	private TipoProduto tipo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdDisponivel() {
		return qtdDisponivel;
	}

	public void setQtdDisponivel(Integer qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
}
