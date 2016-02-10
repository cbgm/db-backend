package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.IArticleDao;
import de.christian.api.dao.interfaces.IImageDao;
import de.christian.api.model.Article;
import de.christian.api.model.GuestbookEntry;
import de.christian.api.model.Image;
import de.christian.api.model.News;
import de.christian.api.model.Tag;



@Repository("imageDao")
public class ImageDaoImpl extends GeneralDaoImpl<Image, Long> implements IImageDao{

	@Override
	protected Class<Image> getEntityClass() {
		// TODO Auto-generated method stub
		return Image.class;
	}

	public Set<Image> getAllImages() {
		String query = "FROM Image i";
		return new HashSet<Image>(sessionFactory.getCurrentSession().createQuery(query).list());
	}

	public Image getByIdOverride(long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Image where imageId=:id");
		q.setParameter("id", entityId);
		Image image = (Image) q.uniqueResult();
		return image;
	}
}

