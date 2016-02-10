package de.christian.api.dao.interfaces;

import java.util.Set;

import de.christian.api.model.Article;
import de.christian.api.model.Image;


public interface IImageDao extends IGeneralDao<Image, Long> {
	public Set<Image> getAllImages();
	public Image getByIdOverride(final long entityId);

}
