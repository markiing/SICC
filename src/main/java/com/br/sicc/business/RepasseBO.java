package com.br.sicc.business;

import java.util.List;

import com.br.sicc.model.Pessoa;
import com.br.sicc.model.ProdutoRepassado;

public interface RepasseBO {

	List<ProdutoRepassado> recuperarProdutosPorVendedor(Pessoa p) throws Exception;
	void repassarProduto(ProdutoRepassado p) throws Exception;
}
