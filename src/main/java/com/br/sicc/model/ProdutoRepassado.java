package com.br.sicc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="produtos_vendedor")
public class ProdutoRepassado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO")
	private Integer codigo;
	
	@ManyToOne(targetEntity=Produto.class)
	@JoinColumn(name="PRODUTOS_CODIGO", referencedColumnName="CODIGO")
	private Produto produto;
	
	@ManyToOne(targetEntity=Pessoa.class)
	@JoinColumn(name="PESSOA_CODIGO", referencedColumnName="CODIGO")
	private Pessoa responsavel;
	
	@Column(name="QTD_POSSE")
	private Integer qtd;
	
	@Temporal(TemporalType.TIME)
	@Column(name="DATA_ATRIBUICAO")
	private Date dataAtribuicao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pessoa getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Date getDataAtribuicao() {
		return dataAtribuicao;
	}

	public void setDataAtribuicao(Date dataAtribuicao) {
		this.dataAtribuicao = dataAtribuicao;
	}
	
	
}
