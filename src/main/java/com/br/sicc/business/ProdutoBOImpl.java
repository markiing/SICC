package com.br.sicc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.br.sicc.dao.ProdutoDAO;
import com.br.sicc.model.Produto;
import com.br.sicc.model.TipoProduto;

@Service
public class ProdutoBOImpl implements ProdutoBO {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Override
	public List<TipoProduto> recuperarTipoProdutos() throws Exception {
		return produtoDAO.recuperarTiposDeProdutos();
	}

	@Override
	public List<Produto> recuperarProdutosCadastrados() throws Exception {
		return produtoDAO.recuperarProdutos();
	}

	@Override
	public void cadastrar(Produto p) throws Exception {
			produtoDAO.cadastra(p);
	}

	@Override
	public void atualizar(Produto p) throws Exception {
			produtoDAO.atualizar(p);
	}

}
