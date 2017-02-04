package com.br.sicc.business;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sicc.dao.PessoaDAO;
import com.br.sicc.model.Pessoa;

@Service
public class PessoaBOImpl implements PessoaBO {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Override
	public void salvar(Pessoa p) throws Exception {
		if(p.getCpf().isEmpty())
			p.setCpf(null);
		
		p.setDataCadastro(Calendar.getInstance().getTime());
		pessoaDAO.salvar(p);
		
	}

	@Override
	public List<Pessoa> recuperarPessoas() throws Exception {
		return pessoaDAO.listarPessoas();
	}

	@Override
	public void atualizar(Pessoa p) throws Exception {
		if(p.getCpf().isEmpty()) p.setCpf(null);
		
		if(this.recuperarPessoa(p)!=null){
			throw new Exception("Você não pode editar este cadastro. Já existe um nome e um telefone vinculado com esses dados.");
		}else{			
			pessoaDAO.atualizarDados(p);
		}
		
	}

	@Override
	public Pessoa recuperarPessoa(Pessoa p) throws Exception {
		return pessoaDAO.recuperarPessoa(p);
	}

	@Override
	public void chavearStatus(Pessoa p) throws Exception {
		pessoaDAO.chavearStatus(p);
	}

	@Override
	public List<Pessoa> recuperarVendedores() throws Exception {
		return pessoaDAO.recuperarVendedores();
	}

}
