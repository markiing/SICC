package com.br.sicc.business;

import java.util.List;

import com.br.sicc.model.Pessoa;

public interface PessoaBO {
	void salvar(Pessoa p) throws Exception;
	void atualizar(Pessoa p) throws Exception;
	void chavearStatus(Pessoa p) throws Exception;
	Pessoa recuperarPessoa(Pessoa p) throws Exception;
	List<Pessoa> recuperarPessoas() throws Exception;
	List<Pessoa> recuperarVendedores() throws Exception;
}
