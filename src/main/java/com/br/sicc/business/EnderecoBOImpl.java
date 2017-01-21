package com.br.sicc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sicc.dao.EnderecoDAO;
import com.br.sicc.model.Cidade;
import com.br.sicc.model.Estado;

@Service
public class EnderecoBOImpl implements EnderecoBO {

	@Autowired
	private EnderecoDAO enderecoDAO;
	
	@Override
	public List<Estado> listarEstados() throws Exception {
		return enderecoDAO.recuperarEstados();
	}

	@Override
	public List<Cidade> listarCidade(Estado e) throws Exception {
		return enderecoDAO.recuperarCidades(e);
	}

}
