package com.br.sicc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="PRODUTOS")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO")
	private Integer codigo;
	
	@Column(name="DESCRICAO")
	@Size(max=230,message="Descrição longa demais")
	@NotBlank(message="Você precisa descriminar uma descrição")
	@NotNull(message="Descrição não pode ser nula")
	private String descricao;
	
	@Column(name="ESTOQUE")
	@Min(value=1,message="A quantidade disponível deve ser maior que 0")
	@NotNull(message="Você precisa inserir a quantidade disponível em estoque para o produto")
	private Integer qtdDisponivel;
	
	@Column(name="VALOR")
	@DecimalMin(value="1.0", message="Valor unitário deve ser maior que 0")
	@NotNull(message="Você precisa inserir um valor para o produto")
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
