package de.christian.api.service.interfaces;

import java.util.Set;

import de.christian.api.model.Article;
import de.christian.api.model.Project;


public interface IArticleService extends IGeneralService<Article, Long> {
	public Set<Article> getAllArticles();
	public Article getByIdOverride(final long entityId);
	public void updateById(final Article article);
	public void deleteById(final long entityId);


}
