package de.christian.api.service;

import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.GeneralDaoImpl;
import de.christian.api.dao.interfaces.IGeneralDao;
import de.christian.api.service.interfaces.IGeneralService;



//TODO: Auto-generated Javadoc
/**
* The Class GeneralServiceImpl is not used anymore.
* @author Christian Bergmann
*
* @param <T> the generic type
*/
public abstract class GeneralServiceImpl<T , I> extends GeneralDaoImpl<T ,I> implements IGeneralService<T , I> {
	
	/** The dao. */
	private IGeneralDao<T , I> dao;

	/* (non-Javadoc)
	 * @see de.awz.manschette.dao.GeneralDaoImpl#save(java.lang.Object)
	 */
	@Transactional
	public void save(final T entity) {
		dao.save(entity);
		
	}

	/* (non-Javadoc)
	 * @see de.awz.manschette.dao.GeneralDaoImpl#update(java.lang.Object)
	 */
	@Transactional
	public void update(final T entity) {
		dao.update(entity);
		
	}

	/* (non-Javadoc)
	 * @see de.awz.manschette.dao.GeneralDaoImpl#delete(java.lang.Object)
	 */
	@Transactional
	public void delete(final T entity) {
		dao.delete(entity);
		
	}

	/* (non-Javadoc)
	 * @see de.awz.manschette.dao.GeneralDaoImpl#getById(int)
	 */
	@Transactional
	public T getById(final I entityId) {
		
		return dao.getById(entityId);
	}

}
