package com.br.sicc.dao;

import java.util.List;

import com.br.sicc.model.Produto;
import com.br.sicc.model.TipoProduto;

public interface ProdutoDAO {

	List<Produto> recuperarProdutos() throws Exception;
	void cadastra(Produto p) throws Exception;
	void atualizar(Produto p) throws Exception;
	void realizarBaixaEstoque(Produto p) throws Exception;
	List<TipoProduto> recuperarTiposDeProdutos() throws Exception;
}
