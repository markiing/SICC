package com.br.sicc.business;

import java.util.List;

import com.br.sicc.model.Produto;
import com.br.sicc.model.TipoProduto;

public interface ProdutoBO {
	List<Produto> recuperarProdutosCadastrados() throws Exception;
	void cadastrar(Produto p) throws Exception;
	void atualizar(Produto p) throws Exception;
	List<TipoProduto> recuperarTipoProdutos() throws Exception;
}
