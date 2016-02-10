package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.IGalleryDao;
import de.christian.api.dao.interfaces.INewsDao;
import de.christian.api.model.Gallery;
import de.christian.api.model.News;
import de.christian.api.model.Tag;
import de.christian.api.service.interfaces.IGalleryService;
import de.christian.api.service.interfaces.INewsService;


@Service("galleryService")
public class GalleryServiceImpl implements IGalleryService{

	@Autowired
	private IGalleryDao dao;

	@Transactional
	public void save(Gallery entity) {
		dao.save(entity);		
	}

	@Transactional
	public void update(Gallery entity) {
		dao.update(entity);		
	}

	@Transactional
	public void delete(Gallery entity) {
		dao.delete(entity);
	}

	@Transactional
	public Gallery getById(Long entityId) {
		return dao.getById(entityId);
	}

	@Transactional
	public Set<Gallery> getAllGalleries() {
		return dao.getAllGalleries();
	}

	@Transactional
	public void deleteById(long entityId) {
		dao.deleteById(entityId);
	}

	@Transactional
	public Gallery getByIdOverride(long entityId) {
		return dao.getByIdOverride(entityId);
	}
}
