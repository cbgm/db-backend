package de.christian.api.dao.interfaces;

import java.util.Set;

import de.christian.api.model.News;
import de.christian.api.model.Tag;


public interface INewsDao extends IGeneralDao<News, Long> {
	public Set<News> getAllNews();
	
	public Set<News> getNewsByTags(final Set<Tag> tags);
	
	public void deleteById(final long entityId);
	
	public Set<News> getPaginatedNewsEntries(final int start, final int end);
	
	public News getByIdOverride(final long entityId);
}
