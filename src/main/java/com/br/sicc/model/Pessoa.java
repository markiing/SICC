package com.br.sicc.model;

import java.sql.Date;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name="NOME")
	private String nome;
	@Column(name="APELIDO")
	private String apelido;
	@Column(name="TELEFONE_CELULAR")
	private String telefone;
	@Column(name="CPF", nullable=true)
	private String cpf;
	@Column(name="RUA")
	private String rua;
	@Column(name="BAIRRO")
	private String bairro;
	@Column(name="NCASA")
	private String ncasa;
	@Column(name="ATIVO")
	private boolean ativo = true;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="DATA_CADASTRO")
	private java.util.Date dataCadastro;
	@ManyToOne(targetEntity=Cidade.class, cascade={CascadeType.MERGE})
	@JoinColumn(name="CIDADE_CODIGO", referencedColumnName="CODIGO")
	private Cidade cidade;
	@Column(name="TIPO_CADASTRO")
	private String tipoCadastro;

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase().trim();
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido.toUpperCase().trim();
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua.toUpperCase().trim();
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase().trim();
	}
	public String getNcasa() {
		return ncasa;
	}
	public void setNcasa(String ncasa) {
		this.ncasa = ncasa;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String getTipoPessoa() {
		return tipoCadastro;
	}
	public void setTipoPessoa(String tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
}
