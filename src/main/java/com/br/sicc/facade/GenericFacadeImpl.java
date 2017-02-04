package com.br.sicc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GenericFacadeImpl implements GenericFacade {

	@Autowired
	private ApplicationContext context;
	
	@Override
	public <T> T get(Class<T> clazz) throws Exception {
		return context.getBean(clazz);
	}

}
