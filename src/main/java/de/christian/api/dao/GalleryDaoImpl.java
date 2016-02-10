package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.IGalleryDao;
import de.christian.api.dao.interfaces.INewsDao;
import de.christian.api.model.Gallery;
import de.christian.api.model.Image;
import de.christian.api.model.News;
import de.christian.api.model.Tag;



@Repository("galleryDao")
public class GalleryDaoImpl extends GeneralDaoImpl<Gallery, Long> implements IGalleryDao {

	@SuppressWarnings("unchecked")
	public void deleteById(final long entityId) {
		Gallery gallery = new Gallery();
		gallery.setGalleryId(entityId);
		this.sessionFactory.getCurrentSession().delete(gallery);
	}

	@Override
	protected Class<Gallery> getEntityClass() {
		return Gallery.class;
	}
	
	@SuppressWarnings("unchecked")
	public Gallery getByIdOverride(final long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Gallery where galleryId=:id");
		q.setParameter("id", entityId);
		Gallery gallery = (Gallery) q.uniqueResult();
		ArrayList<Image> images =  new  ArrayList<Image>(gallery.getImages());
		gallery.setImages(new HashSet<Image>(images));
		return gallery;
	}

	public Set<Gallery> getAllGalleries() {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM Gallery g ORDER BY g.galleryId ASC");
		ArrayList<Gallery> array = new ArrayList<Gallery>(q.list());

		for (Gallery g: array) {
			ArrayList<Image> images =  new  ArrayList<Image>(g.getImages());
			g.setImages(new HashSet<Image>(images));
		}
		return new HashSet<Gallery>(array);
	}


}
