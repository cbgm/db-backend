package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.IArticleDao;
import de.christian.api.dao.interfaces.IImageDao;
import de.christian.api.model.Article;
import de.christian.api.model.Image;
import de.christian.api.service.interfaces.IArticleService;
import de.christian.api.service.interfaces.IImageService;



@Service("imageService")
public class ImageServiceImpl implements IImageService {

	@Autowired
	private IImageDao dao;

	@Transactional
	public void save(Image entity) {
		dao.save(entity);
		
	}

	@Transactional
	public void update(Image entity) {
		dao.update(entity);
		
	}

	@Transactional
	public void delete(Image entity) {
		dao.delete(entity);
		
	}

	@Transactional
	public Image getById(Long entityId) {
		return dao.getById(entityId);
	}

	@Transactional
	public Set<Image> getAllImages() {
		return dao.getAllImages();
	}

	@Transactional
	public Image getByIdOverride(long entityId) {
		return dao.getByIdOverride(entityId);
	}

}
