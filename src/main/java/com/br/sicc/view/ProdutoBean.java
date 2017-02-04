package com.br.sicc.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.br.sicc.business.PessoaBO;
import com.br.sicc.business.ProdutoBO;
import com.br.sicc.config.ApplicationContextProvider;
import com.br.sicc.facade.GenericFacade;
import com.br.sicc.model.Produto;
import com.br.sicc.model.TipoProduto;
import com.br.sicc.util.FeedbackUtils;
import com.br.sicc.util.SICCUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private GenericFacade facade = ApplicationContextProvider
			.getApplicationContext().getBean(GenericFacade.class);
	private List<SelectItem> tipoProdutoSI = new ArrayList<>();
	private List<SelectItem> produtosSI = new ArrayList<>();
	private Produto produto = new Produto();
	private List<Produto> produtosCadastrados = new ArrayList<>();

	@PostConstruct
	public void init() {
		try {
			recuperarProdutos();
			if (tipoProdutoSI.size() > 0 || tipoProdutoSI != null) {
				tipoProdutoSI.clear();
			}
			List<TipoProduto> listTipoProduto = facade.get(ProdutoBO.class)
					.recuperarTipoProdutos();
			for (TipoProduto tipoProduto : listTipoProduto) {
				tipoProdutoSI.add(new SelectItem(tipoProduto, tipoProduto
						.getDescricao()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Produto> recuperarProdutos() {
		try {
			if(produtosSI.size()>0){produtosSI.clear();}
			List<Produto> produtosCadastrados = facade.get(ProdutoBO.class).recuperarProdutosCadastrados();
			for (Produto produto : produtosCadastrados) {
				produtosSI.add(new SelectItem(produto, produto.getDescricao()));
			}
			return produtosCadastrados;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void recuperarInformacoesDoProduto(Produto p) {
		System.out.println(p.getDescricao());
	}

	public void cadastrar(Produto produto) {
		try {
			facade.get(ProdutoBO.class).cadastrar(produto);
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_INFO,
					FeedbackUtils.INSERT_SUCCESSFULLY);
			recuperarProdutos();
		} catch (Exception ex) {
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_ERROR,
					ex.getMessage());
		}
	}

	public void atualizarProduto(RowEditEvent event) {
		try {
			facade.get(ProdutoBO.class).atualizar((Produto) event.getObject());
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_INFO,
					FeedbackUtils.UPDATE_SUCCESSFULLY);
			recuperarProdutos();
		} catch (Exception ex) {
			SICCUtil.exibirMensagem(FacesMessage.SEVERITY_ERROR,
					ex.getMessage());
		}
	}

	// ############################## GETTERS AND SETTERS
	// ##################################

	public void setProdutosSI(List<SelectItem> produtosSI) {
		this.produtosSI = produtosSI;
	}

	public List<SelectItem> getProdutosSI() {
		return produtosSI;
	}

	public List<SelectItem> getTipoProdutoSI() {
		return tipoProdutoSI;
	}

	public void setTipoProdutoSI(List<SelectItem> tipoProdutoSI) {
		this.tipoProdutoSI = tipoProdutoSI;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setProdutosCadastrados(List<Produto> produtosCadastrados) {
		this.produtosCadastrados = produtosCadastrados;
	}

	public List<Produto> getProdutosCadastrados() {
		return produtosCadastrados;
	}
}
