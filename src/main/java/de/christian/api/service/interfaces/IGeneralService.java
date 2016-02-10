package de.christian.api.service.interfaces;

public interface IGeneralService<T , I> {
	
	/**
	 * This method is used to save an entity.
	 *
	 * @param entity the entity
	 */
	public void save(final T entity);
	
	/**
	 * This method is used to update an entity.
	 *
	 * @param entity the entity
	 */
	public void update(final T entity);
	
	/**
	 * This method is used to delete an entity.
	 *
	 * @param entity the entity
	 */
	public void delete(final T entity);
	
	/**
	 * This method is used to get an entity by its id.
	 *
	 * @param entityId the entity id
	 * @return the by id
	 */
	public T getById(final I entityId);

}