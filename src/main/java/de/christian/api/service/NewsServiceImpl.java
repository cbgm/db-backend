package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.INewsDao;
import de.christian.api.model.News;
import de.christian.api.model.Tag;
import de.christian.api.service.interfaces.INewsService;


@Service("newsService")
public class NewsServiceImpl implements INewsService{

	@Autowired
	private INewsDao dao;
	
	@Transactional
	public void save(News entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}

	@Transactional
	public void update(News entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Transactional
	public void delete(News entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Transactional
	public Set<News> getAllNews() {
		// TODO Auto-generated method stub
		return dao.getAllNews();
	}

	@Transactional
	public Set<News> getNewsByTags(Set<Tag> tags) {
		// TODO Auto-generated method stub
		return dao.getNewsByTags(tags);
	}

	@Transactional
	public Set<News> getPaginatedNewsEntries(final int start, final int end) {
		// TODO Auto-generated method stub
		return dao.getPaginatedNewsEntries(start, end);
	}

	@Transactional
	public void deleteById(final long entityId) {
		dao.deleteById(entityId);
		
	}

	@Transactional
	public News getByIdOverride(long entityId) {
		return dao.getByIdOverride(entityId);
	}

	@Transactional
	public News getById(Long entityId) {
		return dao.getById(entityId);
	}
}
