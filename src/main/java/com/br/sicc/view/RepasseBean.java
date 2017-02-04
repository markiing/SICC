package com.br.sicc.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.sicc.business.PessoaBO;
import com.br.sicc.business.RepasseBO;
import com.br.sicc.config.ApplicationContextProvider;
import com.br.sicc.facade.GenericFacade;
import com.br.sicc.model.Pessoa;
import com.br.sicc.model.Produto;
import com.br.sicc.model.ProdutoRepassado;
import com.br.sicc.util.SICCUtil;

@ManagedBean
@ViewScoped
public class RepasseBean {

	private GenericFacade facade = ApplicationContextProvider.getApplicationContext().getBean(GenericFacade.class);
	private List<Pessoa> listPessoas = new ArrayList<>();
	private List<Pessoa> pessoasFiltradas = new ArrayList<>();
	private List<ProdutoRepassado> listProdutosRepassados = new ArrayList<>();
	private Pessoa pessoa = new Pessoa();
	private Double totalValorProdutoRepassado = new Double(0.0);
	
	@PostConstruct
	public void init(){
		pessoasFiltradas = listPessoas;
	}
	
	public void recuperarVendedores(){
		try{
			this.listPessoas = facade.get(PessoaBO.class).recuperarVendedores();
		}catch(Exception ex){
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage());
		}
	}
	
	public void confVendedor(Pessoa p){
		try {
			this.listProdutosRepassados = facade.get(RepasseBO.class).recuperarProdutosPorVendedor(p);
			for(ProdutoRepassado produto : listProdutosRepassados){
				this.totalValorProdutoRepassado+=produto.getProduto().getValor();
			}
			this.pessoa = p;
		} catch (Exception e) {
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}
	
	//##################################### GETTERS AND SETTERS ##########################################
	
	public void setTotalValorProdutoRepassado(Double totalValorProdutoRepassado) {
		this.totalValorProdutoRepassado = totalValorProdutoRepassado;
	}
	public Double getTotalValorProdutoRepassado() {
		return totalValorProdutoRepassado;
	}
	
	
	public void setListProdutosRepassados(
			List<ProdutoRepassado> listProdutosRepassados) {
		this.listProdutosRepassados = listProdutosRepassados;
	}
	
	public List<ProdutoRepassado> getListProdutosRepassados() {
		return listProdutosRepassados;
	}
	
	public List<Pessoa> getListPessoas() {
		return listPessoas;
	}
	public List<Pessoa> getPessoasFiltradas() {
		return pessoasFiltradas;
	}

	public void setPessoasFiltradas(List<Pessoa> pessoasFiltradas) {
		this.pessoasFiltradas = pessoasFiltradas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setListPessoas(List<Pessoa> listPessoas) {
		this.listPessoas = listPessoas;
	}
	
	
	
	
}
