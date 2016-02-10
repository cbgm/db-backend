package de.christian.api.dao.interfaces;

public interface IGeneralDao<T,I> {
	
	public void save(final T entity);
	
	public void update(final T entity);
	
	public void delete(final T entity);
	
	public T getById(final I entityId);
}
