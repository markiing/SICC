package com.br.sicc.dao;

import java.util.List;

import com.br.sicc.model.Pessoa;

public interface PessoaDAO {
	void salvar(Pessoa pessoa) throws Exception;
	void atualizarDados(Pessoa p) throws Exception;
	void chavearStatus(Pessoa p) throws Exception;
	Pessoa recuperarPessoa(Pessoa p) throws Exception;
	List<Pessoa> listarPessoas() throws Exception;
	List<Pessoa> recuperarVendedores() throws Exception;
}
