package de.christian.api.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import de.christian.api.dao.interfaces.IGeneralDao;


public abstract class GeneralDaoImpl<T,I> implements IGeneralDao<T, I> {
	
	@Autowired
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(final T entitiy) {
		this.sessionFactory.getCurrentSession().save(entitiy);
		
	}

	public void update(final T entity) {
		this.sessionFactory.getCurrentSession().update(entity);
		
	}

	public void delete(final T entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	public T getById(final I id){
		return (T)sessionFactory.getCurrentSession().get(getEntityClass(), (Serializable) id);
	}
	
	/**
	 * Gets the entity class which is currently used.
	 *
	 * @return the entity class
	 */
	protected abstract Class<T> getEntityClass();
	
	/**
	 * Creates the detached criteria.
	 *
	 * @return the detached criteria
	 */
	protected DetachedCriteria createDetachedCriteria() {

        return DetachedCriteria.forClass(getEntityClass());

	}
	
	
}
