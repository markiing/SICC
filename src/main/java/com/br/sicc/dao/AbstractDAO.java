package com.br.sicc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO<PK extends Serializable, T> {

	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDAO(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listAll(){
		return (List<T>) createEntityCriteria().list();
	}

	public void persist(T entity) {
		getSession().save(entity);
	}
	
	public void update(T entity){
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

}
