package com.br.sicc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.br.sicc.model.Produto;
import com.br.sicc.model.TipoProduto;

@Repository
@org.springframework.transaction.annotation.Transactional
public class ProdutoDAOImpl extends AbstractDAO<Integer, Produto> implements ProdutoDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoProduto> recuperarTiposDeProdutos() throws Exception {
		Criteria c = getSession().createCriteria(TipoProduto.class);
		return c.list();
	}

	@Override
	public List<Produto> recuperarProdutos() throws Exception {
		return listAll();
	}

	@Override
	public void cadastra(Produto p) throws Exception {
		persist(p);
	}

	@Override
	public void atualizar(Produto p) throws Exception {
		update(p);
	}

	@Override
	public void realizarBaixaEstoque(Produto p) throws Exception {
		//TODO REALIZAR BAIXA NO ESTOQUE
		Query q = getSession().createQuery("UPDATE Produto set ");
	}

}
