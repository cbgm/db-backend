package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.IArticleDao;
import de.christian.api.model.Article;
import de.christian.api.model.News;
import de.christian.api.model.Tag;



@Repository("articleDao")
public class ArticleDaoImpl extends GeneralDaoImpl<Article, Long> implements IArticleDao{

	@Override
	protected Class<Article> getEntityClass() {
		// TODO Auto-generated method stub
		return Article.class;
	}

	@SuppressWarnings("unchecked")
	public Set<Article> getAllArticles() {
		String query = "FROM Article";
		return new HashSet<Article>(sessionFactory.getCurrentSession().createQuery(query).list());
	}

	public Article getByIdOverride(final long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Article where articleId=:id");
		q.setParameter("id", entityId);
		Article article = (Article) q.uniqueResult();
		ArrayList<Tag> tags =  new  ArrayList<Tag>(article.getTags());
		article.setTags(new HashSet<Tag>(tags));
		return article;
	}

	public void updateById(final Article article) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Article where articleId=:id");
		q.setParameter("id", article.getArticleId());
		Article tempArticle = (Article) q.uniqueResult();
		tempArticle.setContent(article.getContent());
		tempArticle.setTitle(article.getTitle());
		tempArticle.setTags(article.getTags());
		
	}

	public void deleteById(long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Article where articleId=:id");
		q.setParameter("id", entityId);
		Article tempArticle = (Article) q.uniqueResult();
		tempArticle.setProject(null);
		this.sessionFactory.getCurrentSession().delete(tempArticle);
		
	}
}

