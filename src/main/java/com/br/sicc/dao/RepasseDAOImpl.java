package com.br.sicc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.br.sicc.model.Pessoa;
import com.br.sicc.model.ProdutoRepassado;

@Repository
@Transactional
public class RepasseDAOImpl extends AbstractDAO<Integer, ProdutoRepassado> implements RepasseDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoRepassado> recuperarProdutosPorVendedor(Pessoa p) throws Exception {
		return (List<ProdutoRepassado>) createEntityCriteria().add(Restrictions.eq("responsavel.codigo", p.getCodigo())).list();
	}

	@Override
	public void repassarProduto(ProdutoRepassado p) throws Exception {
		persist(p);
	}

}
