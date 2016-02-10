package de.christian.api.service.interfaces;

import java.util.Collection;
import java.util.Set;

import de.christian.api.model.Article;
import de.christian.api.model.GuestbookEntry;
import de.christian.api.model.Image;
import de.christian.api.model.Project;


public interface IImageService extends IGeneralService<Image, Long> {

	public Set<Image> getAllImages();
	public Image getByIdOverride(final long entityId);


}
