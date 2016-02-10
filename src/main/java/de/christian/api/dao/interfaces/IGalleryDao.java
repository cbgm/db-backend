package de.christian.api.dao.interfaces;

import java.util.Set;

import de.christian.api.model.Gallery;
import de.christian.api.model.News;
import de.christian.api.model.Tag;


public interface IGalleryDao extends IGeneralDao<Gallery, Long> {
	public Set<Gallery> getAllGalleries();
	
	public void deleteById(final long entityId);
	
	public Gallery getByIdOverride(final long entityId);	

}
