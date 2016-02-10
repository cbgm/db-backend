package de.christian.api.dao.interfaces;

import java.util.Set;

import de.christian.api.model.Article;


public interface IArticleDao extends IGeneralDao<Article, Long> {
	public Set<Article> getAllArticles();
	public Article getByIdOverride(final long entityId);
	public void updateById(final Article article);
	public void deleteById(final long entityId);
}
