package com.br.sicc.dao;

import java.util.List;

import com.br.sicc.model.Cidade;
import com.br.sicc.model.Estado;

public interface EnderecoDAO {

	List<Estado> recuperarEstados() throws Exception;
	List<Cidade> recuperarCidades(Estado e) throws Exception;
}
