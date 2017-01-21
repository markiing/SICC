package com.br.sicc.business;

import java.util.List;

import com.br.sicc.model.Cidade;
import com.br.sicc.model.Estado;

public interface EnderecoBO {

	List<Estado> listarEstados() throws Exception;
	List<Cidade> listarCidade(Estado e) throws Exception;
}
