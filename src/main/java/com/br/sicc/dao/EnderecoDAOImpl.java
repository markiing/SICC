package com.br.sicc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.sicc.model.Cidade;
import com.br.sicc.model.Estado;

@Repository
@Transactional
public class EnderecoDAOImpl extends AbstractDAO<Integer, Estado> implements EnderecoDAO {

	@Override
	public List<Estado> recuperarEstados() throws Exception {
		return listAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> recuperarCidades(Estado e) throws Exception {
		Criteria criteria = getSession().createCriteria(Cidade.class);
		criteria.add(Restrictions.eq("estado.codigo", e.getCodigo()));
		return (List<Cidade>) criteria.list();
	}

}
