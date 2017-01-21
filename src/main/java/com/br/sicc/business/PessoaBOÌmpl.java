package com.br.sicc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sicc.dao.PessoaDAO;
import com.br.sicc.model.Pessoa;

@Service
public class PessoaBOÌmpl implements PessoaBO {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Override
	public void salvar(Pessoa p) throws Exception {
		if(p.getCpf().isEmpty())
			p.setCpf(null);
		
		
		pessoaDAO.salvar(p);
		
	}

	@Override
	public List<Pessoa> recuperarPessoas() throws Exception {
		return pessoaDAO.listarPessoas();
	}

	@Override
	public void atualizar(Pessoa p) throws Exception {
		pessoaDAO.atualizarDados(p);
		
	}

	@Override
	public Pessoa recuperarPessoa(Pessoa p) throws Exception {
		return pessoaDAO.recuperarPessoa(p);
	}

	@Override
	public void chavearStatus(Pessoa p) throws Exception {
		pessoaDAO.chavearStatus(p);
	}

}
