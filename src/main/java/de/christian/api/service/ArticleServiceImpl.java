package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.IArticleDao;
import de.christian.api.model.Article;
import de.christian.api.service.interfaces.IArticleService;



@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	private IArticleDao dao;
	
	@Transactional
	public void save(final Article entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}

	@Transactional
	public void update(final Article entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Transactional
	public void delete(final Article entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Transactional
	public Article getById(final Long entityId) {
		// TODO Auto-generated method stub
		return dao.getById(entityId);
	}

	@Transactional
	public Set<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return dao.getAllArticles();
	}

	@Transactional
	public Article getByIdOverride(long entityId) {
		return dao.getByIdOverride(entityId);
	}

	@Transactional
	public void updateById(Article article) {
		dao.updateById(article);
		
	}

	@Transactional
	public void deleteById(long entityId) {
		dao.deleteById(entityId);
		
	}

}
