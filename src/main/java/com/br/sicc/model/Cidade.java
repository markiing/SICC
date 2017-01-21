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
@Table(name="cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO")
	private Integer codigo;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@ManyToOne(targetEntity=Estado.class)
	@JoinColumn(name="FKESTADO_CODIGO", referencedColumnName="CODIGO")
	private Estado estado;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
