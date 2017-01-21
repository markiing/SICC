package com.br.sicc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.sicc.enumerator.StatusEnum;

@Entity
@Table(name="FICHA")
public class Ficha {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer codigo;
	
	@ManyToOne(targetEntity=Pessoa.class)
	@JoinColumn(name="PESSOA_CODIGO_CLIENTE",referencedColumnName="CODIGO")
	private Pessoa cliente;
	
	@ManyToOne(targetEntity=Pessoa.class)
	@JoinColumn(name="PESSOA_CODIGO_VENDEDOR", referencedColumnName="CODIGO")
	private Pessoa vendedor;
	
	@Column(name="VALBRUTO")
	private Double valBruto;
	
	@Column(name="VALJUROS")
	private Double valJuros;
	
	@Column(name="VALMULTA")
	private Double valMulta;
	
	@Column(name="VALDESCONTO")
	private Double valDesconto;
	
	@Column(name="VALLIQUIDO")
	private Double valLiquido;
	
	@Column(name="OBSERVACAO")
	private String observacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private StatusEnum status;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Pessoa getVendedor() {
		return vendedor;
	}

	public void setVendedor(Pessoa vendedor) {
		this.vendedor = vendedor;
	}

	public Double getValBruto() {
		return valBruto;
	}

	public void setValBruto(Double valBruto) {
		this.valBruto = valBruto;
	}

	public Double getValJuros() {
		return valJuros;
	}

	public void setValJuros(Double valJuros) {
		this.valJuros = valJuros;
	}

	public Double getValMulta() {
		return valMulta;
	}

	public void setValMulta(Double valMulta) {
		this.valMulta = valMulta;
	}

	public Double getValDesconto() {
		return valDesconto;
	}

	public void setValDesconto(Double valDesconto) {
		this.valDesconto = valDesconto;
	}

	public Double getValLiquido() {
		return valLiquido;
	}

	public void setValLiquido(Double valLiquido) {
		this.valLiquido = valLiquido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
}
