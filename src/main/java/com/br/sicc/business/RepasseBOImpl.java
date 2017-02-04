package com.br.sicc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sicc.dao.RepasseDAO;
import com.br.sicc.model.Pessoa;
import com.br.sicc.model.ProdutoRepassado;


@Service
public class RepasseBOImpl implements RepasseBO {

	@Autowired
	private RepasseDAO repasseDAO;
	
	@Override
	public List<ProdutoRepassado> recuperarProdutosPorVendedor(Pessoa p)throws Exception {
		return repasseDAO.recuperarProdutosPorVendedor(p);
	}

	@Override
	public void repassarProduto(ProdutoRepassado p) throws Exception {
		repasseDAO.repassarProduto(p);
	}

}
