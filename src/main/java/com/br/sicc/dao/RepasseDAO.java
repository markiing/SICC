package com.br.sicc.dao;

import java.util.List;

import com.br.sicc.model.Pessoa;
import com.br.sicc.model.ProdutoRepassado;

public interface RepasseDAO {

	List<ProdutoRepassado> recuperarProdutosPorVendedor(Pessoa p) throws Exception;
	void repassarProduto(ProdutoRepassado p) throws Exception;
}
