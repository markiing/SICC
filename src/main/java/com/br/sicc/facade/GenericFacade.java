package com.br.sicc.facade;

public interface GenericFacade {

	<T> T get(Class<T> clazz) throws Exception;
}
