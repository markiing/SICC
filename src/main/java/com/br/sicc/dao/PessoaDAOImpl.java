package com.br.sicc.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.sicc.model.Pessoa;

@Repository
@Transactional
public class PessoaDAOImpl extends AbstractDAO<Integer, Pessoa> implements
		PessoaDAO {

	@Override
	public void salvar(Pessoa pessoa) throws Exception {
		persist(pessoa);
	}

	@Override
	public List<Pessoa> listarPessoas() throws Exception {
		return listAll();
	}

	@Override
	public void atualizarDados(Pessoa p) throws Exception {
		update(p);
	}

	@Override
	public Pessoa recuperarPessoa(Pessoa p) throws Exception {
		return (Pessoa)createEntityCriteria().add(Restrictions.eq("nome", p.getNome()))
		.add(Restrictions.eq("telefone", p.getTelefone())).uniqueResult();
		
	}

	@Override
	public void chavearStatus(Pessoa p) throws Exception {
		update(p);
	}
}
